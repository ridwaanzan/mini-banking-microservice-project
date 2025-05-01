package id.co.mybank.controllers;

import id.co.mybank.entity.Product;
import id.co.mybank.services.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

@Path("product")
public class ProductController {
    @Inject
    ProductService productService;

    @GET
    @Path("/")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object getProduct() {
        return productService.getAllProduct();
    }

    @GET
    @Path("/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object getProductById(@PathParam("id") Long id) {
        return productService.getProductById(id);
    }

    @POST
    @Path("/saveOrUpdate")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object saveOrUpdateProduct(Product data) {
        return productService.saveOrUpdateProduct(data);
    }
}
