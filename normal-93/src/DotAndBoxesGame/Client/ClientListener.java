package DotAndBoxesGame.Client;
import java.io.IOException;

public interface ClientListener {
    public void connectionLost() throws IOException;
    public  void chatMessage(String username, String message);
}
