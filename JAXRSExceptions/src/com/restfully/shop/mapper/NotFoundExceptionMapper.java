package com.restfully.shop.mapper;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.restfully.shop.exceptions.NotFoundException;
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException>{
   @Override
   public Response toResponse(NotFoundException exception){
          return Response.status(404).entity(exception.getMessage()).type("text/plain").build();
   }
}
