package zodd.volt.api.exception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -810584736845301051L;

    public BusinessException(String message) {
        super(message);
    }
}
