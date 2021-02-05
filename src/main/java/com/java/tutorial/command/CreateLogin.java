package com.java.tutorial.command;

import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.Address;
import com.java.tutorial.exception.ServiceException;
import com.java.tutorial.service.impl.AccountService;

import javax.servlet.http.HttpServletRequest;

public class CreateLogin implements Command{
  private AccountService accountService;

    public CreateLogin(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
       Page page = new Page("jsp/login.jsp" , true);
       Account account = new Account();
       Address address = new Address();
       account.setLogin(req.getParameter("login"));
       account.setPassword(req.getParameter("pass"));
//       account.setFirstName(req.getParameter(""));
//       account.setLastName(req.getParameter(""));
//       account.setEmail(req.getParameter(""));
        System.out.println(account.getLogin() + account.getPassword());
       accountService.createByLogin(account.getLogin(), account.getPassword());
        System.out.println(accountService.createByLogin(account.getLogin(), account.getPassword()));
       return page;
    }
}
