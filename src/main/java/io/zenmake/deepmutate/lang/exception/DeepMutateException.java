package io.zenmake.deepmutate.lang.exception;

/**
 * Created by Talal Ahmed on 12/02/2023
 */
public class DeepMutateException extends RuntimeException {

    public DeepMutateException() {
        super();
    }

    public DeepMutateException(String message) {
        super(message);
    }

    public DeepMutateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeepMutateException(Throwable cause) {
        super(cause);
    }

    protected DeepMutateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
