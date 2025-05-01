package id.co.mybank.controllers;

import id.co.mybank.entity.Customer;
import id.co.mybank.services.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

@Path( "customer")
public class CustomerController {
    @Inject
    CustomerService service;

    @GET
    @Path("/")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object getCustomer() {
        return service.getAllCustomer();
    }

    @POST
    @Path("/saveOrUpdate")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object saveOrUpdateCustomerData(Customer customer) {
        return service.saveOrUpdateCustomer(customer);
    }
}
