import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
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
//                Java InetAddress class represents an IP address. The java.net.InetAddress class provides methods to get the IP of any host name

                int port = Integer.parseInt(args[1]);
                Scanner scan = new Scanner(System.in);
                System.out.println("Please enter your name: \n");
                name = scan.nextLine();

//                This class is used for sending and receiving multicast IP packets.
//                It extends DatagramSocket class and provides additional functionality for joining groups.
                MulticastSocket socket = new MulticastSocket(port);


//                since deploying
                socket.setTimeToLive(0);
//                for localhost only

                socket.joinGroup(group);
                Thread t = new Thread(new ReadThread(socket, group, port));

//                create a thread for reading messages
                t.start();

//                Message sent to current group
                System.out.println("Starting typing your messages here: \n");

                while(true) {
                    String message;
                    message = scan.nextLine();
                    if(message.equalsIgnoreCase(GroupChat.TERMINATE)){
                        finished = true;
                        socket.leaveGroup(group);
                        socket.close();
                        break;
                    }
                    message = name + ": " + message;

//                    You could use a byte array to store a collection of binary data ( byte[] ), for example, the contents of a file
                    byte[] buffer = message.getBytes();
                    DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, group, port);
                    socket.send(datagram);
//                    This class provides mechanisms for creation of datagram packets for connectionless delivery using datagram socket class.
                }

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