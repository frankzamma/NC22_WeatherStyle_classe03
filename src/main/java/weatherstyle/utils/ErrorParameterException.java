package weatherstyle.utils;

import java.util.List;

public class ErrorParameterException extends Exception{
    private List<String> errorParameter;

    public ErrorParameterException(List<String> errorParameter) {
        this.errorParameter = errorParameter;
    }

    public ErrorParameterException(String message, List<String> errorParameter) {
        super(message);
        this.errorParameter = errorParameter;
    }

    public ErrorParameterException(String message, Throwable cause, List<String> errorParameter) {
        super(message, cause);
        this.errorParameter = errorParameter;
    }

    public ErrorParameterException(Throwable cause, List<String> errorParameter) {
        super(cause);
        this.errorParameter = errorParameter;
    }

    public ErrorParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, List<String> errorParameter) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorParameter = errorParameter;
    }

    public ErrorParameterException() {
    }

    public ErrorParameterException(String message) {
        super(message);
    }

    public ErrorParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorParameterException(Throwable cause) {
        super(cause);
    }

    public ErrorParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    public List<String> getErrorParameter() {
        return errorParameter;
    }

    public void setErrorParameter(List<String> errorParameter) {
        this.errorParameter = errorParameter;
    }
}
