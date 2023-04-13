package cl.ey.bci.response;

public class Message {
    private String mensaje;

    public Message(String message) {
        this.mensaje = message;
    }

    public String getMessage() {
        return mensaje;
    }

    public void setMessage(String message) {
        this.mensaje = message;
    }
}
