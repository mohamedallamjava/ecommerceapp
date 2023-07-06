package com.ecomerce.app.ecommerceapp.exceptions;

public class ErrorUtils {

/*
create and return ann error object
@param error msg
@param erorCode
@param httpstatuscode
@param url
@param error

*/
    public static Error createError(final String errMsgKey,final String errCode,final Integer httpStatusCode )
    {
        Error error=new Error();
        error.setMessage(errMsgKey);
        error.setErrorCode(errCode);
        error.setStatus(httpStatusCode);
        return error;
    }
}
