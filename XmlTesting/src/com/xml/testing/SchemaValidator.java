package com.xml.testing;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class SchemaValidator {

    private static final String PARSER_CLASS = "org.apache.xerces.parsers.SAXParser";
    
    public SchemaValidator(){}
    
    public List<SchemaError> validate( InputStream inputXmlFile, Schema schema ) {
        
        SchemaErrorHandler schemaErrorHandler = new SchemaErrorHandler();
        
        Validator validator = schema.newValidator();
        validator.setErrorHandler(schemaErrorHandler);
        
        try {
        	SAXParser saxParser = (SAXParser)XMLReaderFactory.createXMLReader(PARSER_CLASS);

            saxParser.setErrorHandler( schemaErrorHandler );
            
            InputSource inputSource = new InputSource(inputXmlFile);
            SAXSource saxSource = new SAXSource( saxParser, inputSource );
        	validator.validate( saxSource );
        } catch( Exception e ) {
        	e.printStackTrace();
        }
        
        return schemaErrorHandler.getErrors();        
    }
    
    public List<SchemaError> execute( InputStream inputXmlFile, Source[] schemas ) throws Exception {
        
        SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        
        Schema schema = sf.newSchema( schemas );
                
        return validate( inputXmlFile, schema);
    }
    
    /**
     * Manejador de los errores del esquema
     *
     */
    private static class SchemaErrorHandler extends DefaultHandler {
        
        private List<SchemaError> errors = new ArrayList<SchemaError>(0);
        
        public SchemaErrorHandler() {}

        public void error(SAXParseException exception) throws SAXException {
            // En caso de error añadimos el error correspondiente a la lista
        	/** Los errores vienen duplicados. Tengo en cuenta únicamente los que empiezan por 'cvc-type.3.1.3'
        	
        	Ejemplo:
        	cvc-pattern-valid: Value 'adjunto1.pdff' is not facet-valid with respect to pattern '\w+\.pdf' for type 'pdfDocumentType'.
			cvc-type.3.1.3: The value 'adjunto1.pdff' of element 'document' is not valid.
        	*/
            if ( !exception.getMessage().startsWith("cvc-pattern-valid"))  {
            	addError(exception);
            }
        }

        public void fatalError(SAXParseException exception) throws SAXException {
            // En caso de error grave añadimos el error a la lista
            addError(exception);  
        }           
        
        public void warning( SAXParseException exception ) throws SAXException {
            // Ignoramos los avisos
        }

        /**
         * Añade un nuevo error a la lista de errores del esquema. 
         * @param e
         */
        private void addError(SAXParseException e) {
            errors.add(
                    new SchemaError(e.getPublicId(),
                        e.getSystemId(),
                        e.getLineNumber(),
                        e.getColumnNumber(),
                        e.getMessage()));
        }
        
        public List<SchemaError> getErrors() {
            return errors;
        }
    }
}
