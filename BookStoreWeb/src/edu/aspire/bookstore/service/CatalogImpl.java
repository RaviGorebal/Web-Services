package edu.aspire.bookstore.service;

import java.rmi.RemoteException;

public class CatalogImpl implements Catalog {

	public float getBookPrice(String isbn) {
		float price = 0.0f;

		if (isbn != null && !isbn.trim().equals("")) {
			// connect to db
			// query table
			// get price and return
			if (isbn.equals("ISBN1001")) {
				price = 200.20f;
			} else if (isbn.equals("ISBN1002")) {
				price = 144.44f;
			} else {
				price = 1500.50f;
			}

		}

		return price;
	}

}
