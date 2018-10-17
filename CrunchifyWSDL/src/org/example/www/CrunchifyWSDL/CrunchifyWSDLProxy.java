package org.example.www.CrunchifyWSDL;

public class CrunchifyWSDLProxy implements org.example.www.CrunchifyWSDL.CrunchifyWSDL_PortType {
  private String _endpoint = null;
  private org.example.www.CrunchifyWSDL.CrunchifyWSDL_PortType crunchifyWSDL_PortType = null;
  
  public CrunchifyWSDLProxy() {
    _initCrunchifyWSDLProxy();
  }
  
  public CrunchifyWSDLProxy(String endpoint) {
    _endpoint = endpoint;
    _initCrunchifyWSDLProxy();
  }
  
  private void _initCrunchifyWSDLProxy() {
    try {
      crunchifyWSDL_PortType = (new org.example.www.CrunchifyWSDL.CrunchifyWSDL_ServiceLocator()).getCrunchifyWSDLSOAP();
      if (crunchifyWSDL_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)crunchifyWSDL_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)crunchifyWSDL_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (crunchifyWSDL_PortType != null)
      ((javax.xml.rpc.Stub)crunchifyWSDL_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.example.www.CrunchifyWSDL.CrunchifyWSDL_PortType getCrunchifyWSDL_PortType() {
    if (crunchifyWSDL_PortType == null)
      _initCrunchifyWSDLProxy();
    return crunchifyWSDL_PortType;
  }
  
  public java.lang.String newOperation(java.lang.String in) throws java.rmi.RemoteException{
    if (crunchifyWSDL_PortType == null)
      _initCrunchifyWSDLProxy();
    return crunchifyWSDL_PortType.newOperation(in);
  }
  
  
}