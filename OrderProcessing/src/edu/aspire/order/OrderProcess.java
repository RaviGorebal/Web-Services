package edu.aspire.order;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface OrderProcess {
	@WebMethod
	//returns unique order ID back to customer
	public String processOrder(Order order);
}
