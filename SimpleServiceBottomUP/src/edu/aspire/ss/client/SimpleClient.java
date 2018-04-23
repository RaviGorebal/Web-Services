package edu.aspire.ss.client;
public class SimpleClient {
	public static void main(String[] args) throws Exception{
		SimpleServiceStub stub = new SimpleServiceStub();
		
		Concat req = new Concat();
		req.setS1("Kandepu ");
		req.setS2("Ramesh");
		
		ConcatResponse resp = stub.concat(req);
		System.out.println(resp.get_return());
	}
}
