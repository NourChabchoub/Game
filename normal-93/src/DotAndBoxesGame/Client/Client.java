package DotAndBoxesGame.Client;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Client {
    private String address;
    private int portnumber;
    private ClientConnection clientConnection;

    Set<ClientListener> listener = new HashSet<>();

    public Client(String address, int portnumber) throws IOException {
        this.address = address;
        this.portnumber = portnumber;
        this.clientConnection = new ClientConnection(address, portnumber);
    }

    public void close(){
        clientConnection.close();
    }

    public void handleDisconnected() throws IOException{
        for (var clientListener: listener){
            listener.removeAll(listener);
            clientListener.connectionLost();
        }
    }
    public void addListener (ClientListener clientListener){
        listener.add(clientListener);
    }
}
