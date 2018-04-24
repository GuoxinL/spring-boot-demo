package pub.guoxin.mybatis.model;

/**
 * Created by guoxin on 17-9-17.
 */
public class SalaryMessage {
    private String message;
    private boolean transfer;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public SalaryMessage(String message, boolean transfer) {
        this.message = message;
        this.transfer = transfer;
    }

    public SalaryMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "\nSalaryMessage{" +
                "message='" + message + '\'' +
                ", transfer=" + transfer +
                '}';
    }
}
