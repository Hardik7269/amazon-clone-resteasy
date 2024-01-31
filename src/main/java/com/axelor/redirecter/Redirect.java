package com.axelor.redirecter;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.axelor.service.ProductDetail;
import com.google.inject.Inject;

@Path("/p")
public class Redirect {
	
	@Inject
	ProductDetail product;
	
	@GET
	@Path("/r")
	public Response print() {
		return Response.ok().entity("ok").build();	
	}
	
	@POST
	@Path("/addToCart")
	public Response addToCart(@QueryParam("name") String pName, @QueryParam("price") int pPrice, @QueryParam("quantity") int pQuantity) {
		
		System.out.println("01");
		product.addToCartt(pName, pPrice, pQuantity);
		
		return Response.ok().entity("Item Added Sucessfully to Databse Thank you").build();
	}
	
	@POST
	@Path("/updateData")
	public Response updateCartData(@QueryParam("id") int pid,@QueryParam("name") String pName, @QueryParam("price") int pPrice, @QueryParam("quantity") int pQuantity) {
		System.out.println("hitting method");
		product.updateCartItem(pid, pName, pPrice, pQuantity);
		
		return Response.ok().entity("Item of id : "+pid+ " is Updated Accordingly").build();
	}
	
	@POST
	@Path("/removeProduct")
	public Response removeProduct(@QueryParam("id") int pId) {
		System.out.println("hitting method");
		product.removeProductItem(pId);
		return Response.ok().entity("Removed id : " + pId).build();
	}

}
