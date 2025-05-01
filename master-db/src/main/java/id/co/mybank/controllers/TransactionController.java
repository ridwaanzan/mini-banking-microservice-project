package id.co.mybank.controllers;

import id.co.mybank.entity.Transaction;
import id.co.mybank.services.TransactionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

@Path("transaction")
public class TransactionController {
    @Inject
    TransactionService transactionService;

    @GET
    @Path("/")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object getTransaction() {
        return transactionService.getAllTransaction();
    }

    @GET
    @Path("/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object getTransactionById(@PathParam("id") Long id) {
        return transactionService.getTransactionById(id);
    }

    @POST
    @Path("/saveOrUpdate")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object saveOrUpdateTransaction(Transaction data) {
        return transactionService.saveOrUpdateTransaction(data);
    }
}
