package com.axelor.redirecter;

import javax.ws.rs.GET;
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
	public Response addToCart(@QueryParam("name") String pName, @QueryParam("price") int pPrice,
			@QueryParam("quantity") int pQuantity) {
		product.addToCartt(pName, pPrice, pQuantity);
		String script = "<script>alert('Item added Successfully');</script>";
		return Response.ok().entity(script).build();
	}

	@GET
	@Path("/updateData")
	public Response updateCartData(@QueryParam("id") int pid, @QueryParam("name") String pName,
			@QueryParam("price") int pPrice, @QueryParam("quantity") int pQuantity) {
		System.out.println("hitting method");
		product.updateCartItem(pid, pName, pPrice, pQuantity);

		return Response.ok().entity("Item of id : " + pid + " is Updated Accordingly").build();
	}

	@GET
	@Path("/removeProduct")
	public Response removeProduct(@QueryParam("id") int pId) {
		System.out.println("hitting method");
		product.removeProductItem(pId);
		String script = "<script>alert('Product with id " + pId + " has been removed');</script>";
		return Response.ok().entity(script).build();
	}

	@GET
	@Path("/removeCart")
	public Response removeCart(@QueryParam("cId") int cId) {
		System.out.println("removing cart ***");
		product.removeCart(cId);

		return Response.ok().entity("okay Cart and all other data is removed").build();
	}

}
