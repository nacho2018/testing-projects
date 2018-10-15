package com.xml.testing;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class SaxParserTesting {

	   public static void main(String[] args) throws Exception{
		   
		    final String FILES_PATH = "C:/Users/jose-ignacio.villanu/pruebas_xml_xsd_examples";
		    
	        String xsdFile = FILES_PATH + "/" + "contralia_metadata_schema.xsd";
	        String xmlFile = FILES_PATH + "/" + "contralia_circuits.xml";
	       
	        
	        InputStream isXsdFile = new FileInputStream( xsdFile );
	      
	        
	        Source[] sourceArray = new Source[]{ new StreamSource( isXsdFile ) };
	        
	        SchemaValidator schemaValidator = new SchemaValidator();
	        List<SchemaError> listError = 
	        		schemaValidator.execute( new FileInputStream(xmlFile), sourceArray );
	        
	        if( listError != null && listError.size() > 0 ) {
	        	for ( SchemaError schemaErr : listError ) {
	        		System.out.println( "Line: " + schemaErr.getLineNumber() + " " + schemaErr.getParsedMessage() );
	        	}
	        }else{
	        	System.out.println( "No errors found");
	        }
	    }
}
