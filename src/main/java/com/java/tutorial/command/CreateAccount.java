package com.java.tutorial.command;

import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.UserType;
import com.java.tutorial.exception.ServiceException;
import com.java.tutorial.service.Service;
import com.java.tutorial.service.impl.AccountService;

import javax.servlet.http.HttpServletRequest;

public class CreateAccount implements Command{
    private AccountService accountService;

    public CreateAccount(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("jsp/register.jsp", true);
        Account account = new Account();
        account.setFirstName(req.getParameter("first_name"));
        account.setLastName(req.getParameter("last_name"));
        account.setLogin(req.getParameter("login"));
        account.setPassword(req.getParameter("pass"));
        account.setEmail(req.getParameter("email"));
        account.setType(UserType.valueOf(req.getParameter("type")));
        accountService.create(account);
        return page;
    }
}

