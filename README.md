Group chat app using UDP multicastsockets built on Java 17 in Intellij

Help from: https://www.geeksforgeeks.org/a-group-chat-application-in-java/

Save the file as GroupChat.java and compile it using javac and then run the program using two command line arguments: 
javac GroupChat.java
java GroupChat 239.0.0.0 1234   (ip address and port, the two arguments taken in by the main method)

Then enter your name and begin chatting.

A multicast host is specified by a class D IP address and by a standard UDP port number. Class D IP addresses are in the range 224.0.0.0 to 239.255.255.255, inclusive. The address 224.0.0.0 is reserved and should not be used.
