package edu.aspire.ss.client;
public class SimpleClient {
	public static void main(String[] args)throws Exception {
		SimpleServiceStub stub = new SimpleServiceStub();
		
		ConcatRequest req = new ConcatRequest();
		req.setS1("ASPIRE ");
		req.setS2("Technologies");
		
		ConcatResponse resp = stub.concat(req);
		
		System.out.println(resp.getConcatResponse());
	}
}
