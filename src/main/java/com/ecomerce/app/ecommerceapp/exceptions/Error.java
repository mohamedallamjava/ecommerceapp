package com.ecomerce.app.ecommerceapp.exceptions;


import org.apache.logging.log4j.util.Strings;

public class Error {
    /**
     * App error code ,wich is diffrent from http code
     */
    private static final long serialVersionUid=1L;
    /*error code

     */

    private String errorCode;
    /*
    meesage human -readable message for error
     */
    private String message;
    /*
      http status
     */
    private Integer status;
    /*
     url of the request
     */
    private String url="not available";
    private String reqMethod="not avialble";

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public Error setUrl(String url) {
        if(Strings.isNotBlank(url)) {
            this.url = url;
        }
        return this;
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public Error setReqMethod(String reqMethod) {
        if(Strings.isBlank(reqMethod)) {
            this.reqMethod = reqMethod;
        }
        return this;

    }
}
