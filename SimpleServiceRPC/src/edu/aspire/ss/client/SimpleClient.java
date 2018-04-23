package edu.aspire.ss.client;

public class SimpleClient {
	public static void main(String[] args) throws Exception {
		SimpleServiceStub stub = new SimpleServiceStub();

		Concat req = new Concat();
		req.setS1("Hello");
		req.setS2("World!");

		ConcatResponse resp = stub.concat(req);
		System.out.println(resp.getResult());
	}
}
