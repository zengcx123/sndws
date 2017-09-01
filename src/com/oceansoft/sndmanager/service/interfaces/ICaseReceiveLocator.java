/**
 * ICaseReceiveLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oceansoft.sndmanager.service.interfaces;

public class ICaseReceiveLocator extends org.apache.axis.client.Service implements com.oceansoft.sndmanager.service.interfaces.ICaseReceive {

    public ICaseReceiveLocator() {
    }


    public ICaseReceiveLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ICaseReceiveLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ICaseReceiveHttpPort
    private java.lang.String ICaseReceiveHttpPort_address = "http://localhost:8080/sndmanager/snd/caseReceive.ws";

    public java.lang.String getICaseReceiveHttpPortAddress() {
        return ICaseReceiveHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ICaseReceiveHttpPortWSDDServiceName = "ICaseReceiveHttpPort";

    public java.lang.String getICaseReceiveHttpPortWSDDServiceName() {
        return ICaseReceiveHttpPortWSDDServiceName;
    }

    public void setICaseReceiveHttpPortWSDDServiceName(java.lang.String name) {
        ICaseReceiveHttpPortWSDDServiceName = name;
    }

    public com.oceansoft.sndmanager.service.interfaces.ICaseReceivePortType getICaseReceiveHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ICaseReceiveHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getICaseReceiveHttpPort(endpoint);
    }

    public com.oceansoft.sndmanager.service.interfaces.ICaseReceivePortType getICaseReceiveHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.oceansoft.sndmanager.service.interfaces.ICaseReceiveHttpBindingStub _stub = new com.oceansoft.sndmanager.service.interfaces.ICaseReceiveHttpBindingStub(portAddress, this);
            _stub.setPortName(getICaseReceiveHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setICaseReceiveHttpPortEndpointAddress(java.lang.String address) {
        ICaseReceiveHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.oceansoft.sndmanager.service.interfaces.ICaseReceivePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.oceansoft.sndmanager.service.interfaces.ICaseReceiveHttpBindingStub _stub = new com.oceansoft.sndmanager.service.interfaces.ICaseReceiveHttpBindingStub(new java.net.URL(ICaseReceiveHttpPort_address), this);
                _stub.setPortName(getICaseReceiveHttpPortWSDDServiceName());
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
        if ("ICaseReceiveHttpPort".equals(inputPortName)) {
            return getICaseReceiveHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://interfaces.service.sndmanager.oceansoft.com", "ICaseReceive");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://interfaces.service.sndmanager.oceansoft.com", "ICaseReceiveHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ICaseReceiveHttpPort".equals(portName)) {
            setICaseReceiveHttpPortEndpointAddress(address);
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
