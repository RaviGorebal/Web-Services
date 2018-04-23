package edu.aspire.bookstore.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Catalog extends Remote {
	float getBookPrice(String isbn) throws RemoteException;
}
