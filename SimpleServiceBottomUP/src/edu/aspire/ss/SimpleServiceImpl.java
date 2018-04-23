package edu.aspire.ss;

public class SimpleServiceImpl implements SimpleServiceSkeletonInterface {
	public edu.aspire.ss.ConcatResponse concat(edu.aspire.ss.Concat concat0) {
		String result = concat0.getS1().concat(concat0.getS2());

		ConcatResponse resp = new ConcatResponse();
		resp.set_return(result);

		return resp;
	}
}
