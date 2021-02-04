package com.java.tutorial.command;

import com.java.tutorial.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class ReadAccount implements Command{
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        return null;
    }
}
