package com.java.tutorial.command;

import com.java.tutorial.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Page execute(HttpServletRequest req) throws ServiceException;
}
