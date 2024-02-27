import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

public class ReadThread implements Runnable{

    private final MulticastSocket socket;
    private final InetAddress group;
    private final int port;


    private static final int MAX_LEN = 1000;

    ReadThread(MulticastSocket socket, InetAddress group, int port) {
        this.socket = socket;
        this.group = group;
        this.port = port;
    }


//    requires a run method because
    @Override
    public void run() {

//        could use while(!Thread.currentThread().isInterrupted()) below
        while(!GroupChat.finished){
            byte[] buffer = new byte[ReadThread.MAX_LEN];
            DatagramPacket datagram = new DatagramPacket((buffer), buffer.length, group, port);

//            set up String variable to read messages coming in as datagrampackets
            String message;

            try{
                socket.receive(datagram);    // Receive packet from multicast group
                message = new String(buffer, 0, datagram.getLength(), "UTF-8");

                if(!message.startsWith(GroupChat.name)) System.out.println(message);

                // Reset the length of the packet before the next packet is received
                datagram.setLength(buffer.length);

            } catch (IOException e) {
                System.out.println("Socket is closed...");
            }
        }

    }
}
