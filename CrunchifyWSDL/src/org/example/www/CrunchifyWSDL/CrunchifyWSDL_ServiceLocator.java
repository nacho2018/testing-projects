/**
 * CrunchifyWSDL_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.CrunchifyWSDL;

public class CrunchifyWSDL_ServiceLocator extends org.apache.axis.client.Service implements org.example.www.CrunchifyWSDL.CrunchifyWSDL_Service {

    public CrunchifyWSDL_ServiceLocator() {
    }


    public CrunchifyWSDL_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CrunchifyWSDL_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CrunchifyWSDLSOAP
    private java.lang.String CrunchifyWSDLSOAP_address = "http://crunchify.com";

    public java.lang.String getCrunchifyWSDLSOAPAddress() {
        return CrunchifyWSDLSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CrunchifyWSDLSOAPWSDDServiceName = "CrunchifyWSDLSOAP";

    public java.lang.String getCrunchifyWSDLSOAPWSDDServiceName() {
        return CrunchifyWSDLSOAPWSDDServiceName;
    }

    public void setCrunchifyWSDLSOAPWSDDServiceName(java.lang.String name) {
        CrunchifyWSDLSOAPWSDDServiceName = name;
    }

    public org.example.www.CrunchifyWSDL.CrunchifyWSDL_PortType getCrunchifyWSDLSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CrunchifyWSDLSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCrunchifyWSDLSOAP(endpoint);
    }

    public org.example.www.CrunchifyWSDL.CrunchifyWSDL_PortType getCrunchifyWSDLSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.example.www.CrunchifyWSDL.CrunchifyWSDLSOAPStub _stub = new org.example.www.CrunchifyWSDL.CrunchifyWSDLSOAPStub(portAddress, this);
            _stub.setPortName(getCrunchifyWSDLSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCrunchifyWSDLSOAPEndpointAddress(java.lang.String address) {
        CrunchifyWSDLSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.example.www.CrunchifyWSDL.CrunchifyWSDL_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.example.www.CrunchifyWSDL.CrunchifyWSDLSOAPStub _stub = new org.example.www.CrunchifyWSDL.CrunchifyWSDLSOAPStub(new java.net.URL(CrunchifyWSDLSOAP_address), this);
                _stub.setPortName(getCrunchifyWSDLSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CrunchifyWSDLSOAP".equals(inputPortName)) {
            return getCrunchifyWSDLSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.example.org/CrunchifyWSDL/", "CrunchifyWSDL");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.example.org/CrunchifyWSDL/", "CrunchifyWSDLSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CrunchifyWSDLSOAP".equals(portName)) {
            setCrunchifyWSDLSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
