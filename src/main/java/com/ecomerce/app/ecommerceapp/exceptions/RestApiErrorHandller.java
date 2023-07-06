package com.ecomerce.app.ecommerceapp.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@ControllerAdvice
public class RestApiErrorHandller {
public static  final Logger log= LoggerFactory.getLogger(RestApiErrorHandller.class);
private final MessageSource messageSource;
@Autowired

    public RestApiErrorHandller(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
@ExceptionHandler(Exception.class)
public ResponseEntity<Error> handelException(HttpServletRequest request, Exception ex, Locale locale)
{
Error error=ErrorUtils.createError(ErrorCode.GENERIC_ERROR.getErrMsgKey(),
                                    ErrorCode.GENERIC_ERROR.getErrCode(),
                                     HttpStatus.INTERNAL_SERVER_ERROR.value()).setUrl(request.getRequestURI().toString())
                                     .setReqMethod(request.getMethod());
return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
}
@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Error> handelHttpMediaTypeNotSupportedException(HttpServletRequest request, HttpMediaTypeNotSupportedException ex, Locale locale)
    {
        Error error=ErrorUtils.createError(ErrorCode.HTTP_MEDIA_TYPE_NOT_SUPPORTED.getErrMsgKey(),
                        ErrorCode.HTTP_MEDIA_TYPE_NOT_SUPPORTED.getErrCode(),
                        HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()).setUrl(request.getRequestURI().toString())
                .setReqMethod(request.getMethod());
        log.info("http media type not supported exception :: "+request.getMethod());
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
  @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<Error> handelHttpMessageNotWritableException(HttpServletRequest request,HttpMessageNotWritableException ex,Locale locale)
  {
      ex.printStackTrace(); // TODO: Should be kept only for development
      Error error = ErrorUtils
              .createError(ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getErrMsgKey(),
                      ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getErrCode(),
                      HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()).setUrl(request.getRequestURL().toString())
              .setReqMethod(request.getMethod());
      log.info("HttpMessageNotWritableException :: request.getMethod(): " + request.getMethod());
      return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<Error> handleHttpMediaTypeNotAcceptableException(HttpServletRequest request,
                                                                           HttpMediaTypeNotAcceptableException ex,
                                                                           Locale locale) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        Error error = ErrorUtils
                .createError(ErrorCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE.getErrMsgKey(),
                        ErrorCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE.getErrCode(),
                        HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod());
        log.info("HttpMediaTypeNotAcceptableException :: request.getMethod(): " + request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleHttpMessageNotReadableException(HttpServletRequest request,
                                                                       HttpMessageNotReadableException ex,
                                                                       Locale locale) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        Error error = ErrorUtils
                .createError(ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrMsgKey(),
                        ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrCode(),
                        HttpStatus.NOT_ACCEPTABLE.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod());
        log.info("HttpMessageNotReadableException :: request.getMethod(): " + request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Error> handleJsonParseException(HttpServletRequest request,
                                                          JsonParseException ex,
                                                          Locale locale) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        Error error = ErrorUtils
                .createError(ErrorCode.JSON_PARSE_ERROR.getErrMsgKey(),
                        ErrorCode.JSON_PARSE_ERROR.getErrCode(),
                        HttpStatus.NOT_ACCEPTABLE.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod());
        log.info("JsonParseException :: request.getMethod(): " + request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

