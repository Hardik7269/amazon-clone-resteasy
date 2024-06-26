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
	
	@GET
	@Path("/addToCart")
	public Response addToCart(@QueryParam("name") String pName, @QueryParam("price") int pPrice, @QueryParam("quantity") int pQuantity) {
		product.addToCart(pName, pPrice, pQuantity);
		return Response.ok().entity("Item Added to Databse Thank you").build();
	}
	
	@GET
	@Path("/updateData")
	public Response updateCartData(@QueryParam("id") int pid,@QueryParam("name") String pName, @QueryParam("price") int pPrice, @QueryParam("quantity") int pQuantity) {
		product.updateCartItem(pid, pName, pPrice, pQuantity);
		return Response.ok().entity("Item of id : "+pid+ " is Updated Accordingly").build();
	}
	
	@GET
	@Path("/removeProduct")
	public Response removeProduct(@QueryParam("id") int pId) {
		product.removeProductItem(pId);
		return Response.ok().entity("Removed id : " + pId).build();
	}
	
	@GET
	@Path("/addAllProduct")
	public Response addAllProduct(@QueryParam("q1") int q1 ,@QueryParam("q2") int q2 , @QueryParam("q3") int q3){
		product.addAllProduct(q1, q2, q3);
		return Response.ok().entity("Thank you for your purchase").build();
	}

}
