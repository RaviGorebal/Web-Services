package edu.aspire.ss;

public class SimpleServiceSkeleton implements SimpleServiceSkeletonInterface {
	public edu.aspire.ss.ConcatResponse concat(
			edu.aspire.ss.ConcatRequest concatRequest0) {
		String result = concatRequest0.getS1().concat(concatRequest0.getS2());

		ConcatResponse resp = new ConcatResponse();
		resp.setConcatResponse(result);
		return resp;
	}
}
