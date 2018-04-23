
/**
 * SimpleService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.0-SNAPSHOT  Built on : Jan 08, 2012 (09:40:19 GMT)
 */

package edu.aspire.ss.client;

/*
 *  SimpleService java interface
 */

public interface SimpleService {

	/**
	 * Auto generated method signature
	 * 
	 * @param concat0
	 */

	public edu.aspire.ss.client.ConcatResponse concat(

	edu.aspire.ss.client.Concat concat0) throws java.rmi.RemoteException;

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param concat0
	 */
	public void startconcat(

	edu.aspire.ss.client.Concat concat0,

	final edu.aspire.ss.client.SimpleServiceCallbackHandler callback)

	throws java.rmi.RemoteException;

	//
}
