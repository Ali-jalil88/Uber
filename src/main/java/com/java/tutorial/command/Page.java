package com.java.tutorial.command;

public class Page {
    private String url;
    private boolean isRedirect;

    public Page(String url, boolean isRedirect){
        this.url=url;
        this.isRedirect=isRedirect;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }
}
