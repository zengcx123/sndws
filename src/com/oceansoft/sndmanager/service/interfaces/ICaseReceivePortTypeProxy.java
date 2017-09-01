package com.oceansoft.sndmanager.service.interfaces;

public class ICaseReceivePortTypeProxy implements com.oceansoft.sndmanager.service.interfaces.ICaseReceivePortType {
  private String _endpoint = null;
  private com.oceansoft.sndmanager.service.interfaces.ICaseReceivePortType iCaseReceivePortType = null;
  
  public ICaseReceivePortTypeProxy() {
    _initICaseReceivePortTypeProxy();
  }
  
  public ICaseReceivePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initICaseReceivePortTypeProxy();
  }
  
  private void _initICaseReceivePortTypeProxy() {
    try {
      iCaseReceivePortType = (new com.oceansoft.sndmanager.service.interfaces.ICaseReceiveLocator()).getICaseReceiveHttpPort();
      if (iCaseReceivePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iCaseReceivePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iCaseReceivePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iCaseReceivePortType != null)
      ((javax.xml.rpc.Stub)iCaseReceivePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.oceansoft.sndmanager.service.interfaces.ICaseReceivePortType getICaseReceivePortType() {
    if (iCaseReceivePortType == null)
      _initICaseReceivePortTypeProxy();
    return iCaseReceivePortType;
  }
  
  public boolean setCasebyObject(com.oceansoft.sndmanager.cooperate.pojo.XtCaseInfoWeb in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (iCaseReceivePortType == null)
      _initICaseReceivePortTypeProxy();
    return iCaseReceivePortType.setCasebyObject(in0, in1);
  }
  
  public boolean setCase(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException{
    if (iCaseReceivePortType == null)
      _initICaseReceivePortTypeProxy();
    return iCaseReceivePortType.setCase(in0, in1, in2);
  }
  
  
}