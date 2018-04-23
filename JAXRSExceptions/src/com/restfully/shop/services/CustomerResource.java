package com.restfully.shop.services;

import com.restfully.shop.domain.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import com.restfully.shop.exceptions.NotFoundException;
import java.sql.*;
import java.net.*;

@Path("/customers")
public class CustomerResource{
   public CustomerResource(){}

   @POST
   @Consumes("application/xml")
   public Response createCustomer(Customer c){
	  //Declare resources
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  Statement stmt = null;
	  ResultSet rs = null;
	  Customer cust = null;
	  Response resp = null;

	  try{
			//Load & Register Jdbc Driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Establish connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");

			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT MAX(ID) FROM CUSTOMER");
			int id;
			if(rs.next()){
				id = rs.getInt(1);
				id++; // Primary key increment
			}else{
				id = 1;
			}

			//Prepare query
			String query = "INSERT INTO CUSTOMER(ID, FIRSTNAME, LASTNAME) VALUES(?,?,?)";

			//Create JDBC Statement
			pstmt = con.prepareStatement(query);

			//set data
			pstmt.setInt(1,id);
			pstmt.setString(2,c.getFirstName());
			pstmt.setString(3, c.getLastName());
			
			int count = pstmt.executeUpdate();

			if(count == 1){ //process result
				resp = Response.created(URI.create("/customers/"+id)).build();
			}else{
				//exception code
			}
	  }catch(Exception e){
		  e.printStackTrace();
	  }
      return resp;
   }
   
   @GET
   @Path("{id}")
   @Produces("application/xml")
   public Customer getCustomer(@PathParam("id") int id){
	  //Declare resources
	  Connection con = null;
	  Statement stmt = null;
	  ResultSet rs = null;
	  Customer cust = null;

	  try{
			//Load & Register Jdbc Driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Establish connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			
			//Prepare query
			String query = "SELECT * FROM CUSTOMER WHERE ID="+id;

			//Create JDBC Statement
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			//System.out.println("******"+rs.next());
			if(!rs.next()){ //empty rs
				//throw new WebApplicationException(Response.Status.NOT_FOUND);
				throw new NotFoundException("Could not found customer:"+id);
			}else{
				cust = new Customer();
				cust.setId(rs.getInt(1));
				cust.setFirstName(rs.getString(2));
				cust.setLastName(rs.getString(3));
			}
	  }catch(SQLException e){
		  e.printStackTrace();
	  }catch(ClassNotFoundException c){
		  c.printStackTrace();
	  }
      return cust;
   }
}
