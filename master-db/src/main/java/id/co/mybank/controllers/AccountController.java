package id.co.mybank.controllers;

import id.co.mybank.entity.Account;
import id.co.mybank.services.AccountService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

@Path("account")
public class AccountController {
    @Inject
    AccountService accountService;

    @GET
    @Path("/")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object getAccount() {
        return accountService.getAllAccount();
    }

    @GET
    @Path("/{accountNumber}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object getAccountByAccountNumber(@PathParam("accountNumber") String accountNumber) {
        return accountService.getAccountByAccountNumber(accountNumber);
    }

    @POST
    @Path("/saveOrUpdate")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object getAccountByAccountNumber(Account account) {
        return accountService.saveOrUpdateAccount(account);
    }
}
