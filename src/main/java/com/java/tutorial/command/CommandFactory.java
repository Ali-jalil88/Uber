package com.java.tutorial.command;

import com.java.tutorial.service.impl.AccountService;

public class CommandFactory {
    public static Command createCommand(String commandT){
        switch (commandT){
            case"command_create_account":
                return new CreateAccount(new AccountService());
            case "command_create_address":
                return new CreateAddress();
            case "command_create_order":
                return new CreateOrder();
            case "command_create_transaction":
                return new CreateTransaction();
            case "command_read_account":
                return new ReadAccount();
            case "command_read_address":
                return new ReadAddress();
            case "command_read_order":
                return new ReadOrder();
            case "command_read_transaction":
                return new ReadTransaction();
            case "command_update_account":
                return new UpdateAccount();
            case "command_update_address":
                return new UpdateAddress();
            case "command_update_order":
                return new UpdateOrder();
            case "command_update_transaction":
                return new UpdateTransaction();
            case "command_delete_account":
                return new DeleteAccount();
            case "command_delete_address":
                return new DeleteAddress();
            case "command_delete_order":
                return new DeleteOrder();
            case "command_delete_transaction":
                return new DeleteTransaction();
            case "command_login_account":
                return new CreateLogin(new AccountService());

            default:
                return null;
        }
    }
}
