package weatherstyle.utils;

import java.util.List;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Error parameter exception.
 */
public class ErrorParameterException extends Exception{
    private List<String> errorParameter;

    /**
     * Instanzia a new Error parameter exception.
     *
     * @param errorParameter error parameter
     */
    public ErrorParameterException(List<String> errorParameter) {
        this.errorParameter = errorParameter;
    }

    /**
     * Instanzia a new Error parameter exception.
     *
     * @param message        message
     * @param errorParameter error parameter
     */
    public ErrorParameterException(String message,List<String> errorParameter) {
        super(message);
        this.errorParameter = errorParameter;
    }

    /**
     * Instanzia a new Error parameter exception.
     *
     * @param message        message
     * @param cause          cause
     * @param errorParameter error parameter
     */
    public ErrorParameterException(String message,Throwable cause,List<String> errorParameter) {
        super(message,cause);
        this.errorParameter = errorParameter;
    }

    /**
     * Instanzia a new Error parameter exception.
     *
     * @param cause          cause
     * @param errorParameter error parameter
     */
    public ErrorParameterException(Throwable cause,List<String> errorParameter) {
        super(cause);
        this.errorParameter = errorParameter;
    }

    /**
     * Instanzia a new Error parameter exception.
     *
     * @param message            message
     * @param cause              cause
     * @param enableSuppression  enable suppression
     * @param writableStackTrace writable stack trace
     * @param errorParameter     error parameter
     */
    public ErrorParameterException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace,List<String> errorParameter) {
        super(message,cause,enableSuppression,writableStackTrace);
        this.errorParameter = errorParameter;
    }

    /**
     * Instanzia a new Error parameter exception.
     */
    public ErrorParameterException() {
    }

    /**
     * Instanzia a new Error parameter exception.
     *
     * @param message message
     */
    public ErrorParameterException(String message) {
        super(message);
    }

    /**
     * Instanzia a new Error parameter exception.
     *
     * @param message message
     * @param cause   cause
     */
    public ErrorParameterException(String message,Throwable cause) {
        super(message,cause);
    }

    /**
     * Instanzia a new Error parameter exception.
     *
     * @param cause cause
     */
    public ErrorParameterException(Throwable cause) {
        super(cause);
    }

    /**
     * Instanzia a new Error parameter exception.
     *
     * @param message            message
     * @param cause              cause
     * @param enableSuppression  enable suppression
     * @param writableStackTrace writable stack trace
     */
    public ErrorParameterException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace) {
        super(message,cause,enableSuppression,writableStackTrace);
    }


    /**
     * Restituisce error parameter.
     *
     * @return the error parameter
     */
    public List<String> getErrorParameter() {
        return errorParameter;
    }

    /**
     * Imposta error parameter.
     *
     * @param errorParameter error parameter
     */
    public void setErrorParameter(List<String> errorParameter) {
        this.errorParameter = errorParameter;
    }
}
