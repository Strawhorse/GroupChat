import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GroupChat {

    public static final String TERMINATE = "Exit";
    static String name;

//    volatile keyword used for multithreading, where each thread can manipulate the variable as it needs
    static volatile boolean finished = false;


    public static void main(String[] args) {
        System.out.println("Group Chat app...");

        if (args.length !=2)
            System.out.println("Two arguments required: <multicast host> <port-number>");
        else{
            try{
                InetAddress group = InetAddress.getByName(args[0]);
//                The InetAddress class is used to encapsulate both, the numerical IP address and the domain name for that address
                int port = Integer.parseInt(args[1]);
                Scanner scan = new Scanner(System.in);
                System.out.println("Please enter your name: \n");
                name = scan.nextLine();

//                This class is used for sending and receiving multicast IP packets.
//                It extends DatagramSocket class and provides additional functionality for joining groups.
                MulticastSocket socket = new MulticastSocket(Integer.parseInt(args[1]));
                


            }
            catch (SocketException se) {
                System.out.println("Error creating the socket ...");
                se.printStackTrace();

            } catch (IOException e) {
                System.out.println("Problem reading/writing to/from the socket ...");
                e.printStackTrace();
            }
        }

    }
}