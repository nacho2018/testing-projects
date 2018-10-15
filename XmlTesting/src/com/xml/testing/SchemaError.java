package com.xml.testing;

import com.seresnet.tools.StringUtils;



public class SchemaError {

	String publicID;
    String systemID;
    int lineNumber;
    int columnNumber;
    String message;
    
    public SchemaError(String publicID, String systemID, int lineNumber,
            int columnNumber, String message) {
        super();
        this.publicID = publicID;
        this.systemID = systemID;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.message = message;
    }
    
    public String getPublicID() {
        return publicID;
    }
    
    public void setPublicID(String publicID) {
        this.publicID = publicID;
    }
    
    public String getSystemID() {
        return systemID;
    }
    
    public void setSystemID(String systemID) {
        this.systemID = systemID;
    }
    
    public int getLineNumber() {
        return lineNumber;
    }
    
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
    
    public int getColumnNumber() {
        return columnNumber;
    }
    
    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
   
    public String getErrorCode() {
        
        String result = message;
        
        if (!StringUtils.isBlankOrNull(message)) {
            int index = message.indexOf(":");
            if (index != -1) {
                result = message.substring(0, index);
            }
        }
        
        return result;
    }
    
    public String getParsedMessage() {
        
        String result = message;
        
        if (!StringUtils.isBlankOrNull(message)) {
            int index = message.indexOf(":");
            if (index != -1) {
                result = message.substring(index + 1);
            }
        }
        
        return result.trim();
    }
}
