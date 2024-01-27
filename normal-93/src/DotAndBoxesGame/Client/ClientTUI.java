package DotAndBoxesGame.Client;

import java.io.IOException;
import java.util.Scanner;

public class ClientTUI implements ClientListener{
    private static Client client;
    private static String username1;
    private static int size;

    public static void main(String[] args) throws IOException{
        ClientTUI clientTUI = new ClientTUI();
        ClientTUI.runTUI();
    }

    public void runTUI() throws IOException{
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter a port number: ");
            int portnumber = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter address: ");
            String address = scanner.nextLine();
            this.client = new Client(address, portnumber);
            client.addListener(this);

            System.out.println("What is your username? ");
            username1 = scanner.nextLine();

            System.out.println("What size for the board grid? ");
            size = scanner.nextInt();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public String getUsername (String username){
        return username1;
    }
    public static int getSize(int size){
        return size;
    }

    @Override
    public void connectionLost() throws IOException {

    }

    @Override
    public void chatMessage(String username, String message) {

    }
}
