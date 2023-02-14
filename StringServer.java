import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    String message = "";
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Krystal's Message: %d", message);
        } 
        else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("=");
                message += parameters[1] + "/n";
                return message;
            }
            return "404 Not Found!";
        }
    }
}