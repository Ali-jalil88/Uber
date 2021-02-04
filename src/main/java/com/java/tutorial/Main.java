package com.java.tutorial;

import com.java.tutorial.entities.*;
import com.java.tutorial.exception.DaoException;
import com.java.tutorial.exception.ServiceException;
import com.java.tutorial.model.impl.AccountDao;
import com.java.tutorial.model.impl.AddressDao;
import com.java.tutorial.model.impl.OrderDao;
import com.java.tutorial.model.impl.TransactionDao;
import com.java.tutorial.service.impl.AccountService;
import com.java.tutorial.service.impl.AddressService;
import com.java.tutorial.service.impl.OrderService;
import com.java.tutorial.service.impl.TransactionService;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AccountService accountService = new AccountService();
        AddressService addressService = new AddressService();
        OrderService orderService = new OrderService();
        TransactionService transactionService = new TransactionService();

        Account account = new Account();
        Account account1 = new Account();
        Address address = new Address();
        Address address1 = new Address();
        Order order = new Order();
        Transaction transaction = new Transaction();
        Status status;
        StatusTransaction statusTransaction;

        try {
            orderService.delete(order);
            System.out.println(orderService.readAll());
        } catch (ServiceException e){
            e.getMessage();
        }

//        List<Address> addressList = new ArrayList<>();
//        addressList = addressService.readAll();
//        addressService.update(address);
//        addressService.deleteById(address.getId());
//        System.out.println(addressService.readAll());


   ;

    }
}
