package tomas.testar;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Message {
    private String message;

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
