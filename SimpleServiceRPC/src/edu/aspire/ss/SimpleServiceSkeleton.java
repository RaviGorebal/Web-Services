package edu.aspire.ss;

public class SimpleServiceSkeleton implements SimpleServiceSkeletonInterface {
	public edu.aspire.ss.ConcatResponse concat(edu.aspire.ss.Concat concat0) {
		String result = concat0.getS1() + concat0.getS1();

		ConcatResponse resp = new ConcatResponse();
		resp.setResult(result);
		return resp;
	}
}
