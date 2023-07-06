package com.ecomerce.app.ecommerceapp.exceptions;

public enum ErrorCode {
    GENERIC_ERROR("PACK-0001", "The system is unable to complete  the request. Contact system support."),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED("PACK-0002", "Requested  media type is not supported. Please use application/json or  application/xml as 'Content-Type' header value"),
    HTTP_MESSAGE_NOT_WRITABLE("PACK-0003", "Missing 'Accept'  header. Please add 'Accept' header."),
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("PACKT-0004", "Requested 'Accept' header value is not supported. Please use application/json or application/xml as 'Accept' value"),
    JSON_PARSE_ERROR("PACKT-0005", "Make sure request payload should be a valid JSON object."),
    HTTP_MESSAGE_NOT_READABLE("PACKT-0006", "Make sure request payload should be a valid JSON or XML object according to 'Content-Type'."),
    RESOURCE_NOT_FOUND("PACKT-0010", "Requested resource not found");

    private String errCode;
    private String errMsgKey;

    ErrorCode(String errCode, String errMsgKey) {
        this.errCode = errCode;
        this.errMsgKey = errMsgKey;
    }
/*
return the error code
 */
    public String getErrCode() {
        return errCode;
    }
/*
return the error msg key
 */
    public String getErrMsgKey() {
        return errMsgKey;
    }
}
