package crunchify.com.web.service;

public class CrunchifyHelloWorldProxy implements crunchify.com.web.service.CrunchifyHelloWorld {
  private String _endpoint = null;
  private crunchify.com.web.service.CrunchifyHelloWorld crunchifyHelloWorld = null;
  
  public CrunchifyHelloWorldProxy() {
    _initCrunchifyHelloWorldProxy();
  }
  
  public CrunchifyHelloWorldProxy(String endpoint) {
    _endpoint = endpoint;
    _initCrunchifyHelloWorldProxy();
  }
  
  private void _initCrunchifyHelloWorldProxy() {
    try {
      crunchifyHelloWorld = (new crunchify.com.web.service.CrunchifyHelloWorldServiceLocator()).getCrunchifyHelloWorld();
      if (crunchifyHelloWorld != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)crunchifyHelloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)crunchifyHelloWorld)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (crunchifyHelloWorld != null)
      ((javax.xml.rpc.Stub)crunchifyHelloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public crunchify.com.web.service.CrunchifyHelloWorld getCrunchifyHelloWorld() {
    if (crunchifyHelloWorld == null)
      _initCrunchifyHelloWorldProxy();
    return crunchifyHelloWorld;
  }
  
  public float addValue(float value) throws java.rmi.RemoteException{
    if (crunchifyHelloWorld == null)
      _initCrunchifyHelloWorldProxy();
    return crunchifyHelloWorld.addValue(value);
  }
  
  public float subtractValue(float value) throws java.rmi.RemoteException{
    if (crunchifyHelloWorld == null)
      _initCrunchifyHelloWorldProxy();
    return crunchifyHelloWorld.subtractValue(value);
  }
  
  
}