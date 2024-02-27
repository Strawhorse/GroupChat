Group chat app using UDP multicastsockets built on Java 17 in Intellij

Help from: https://www.geeksforgeeks.org/a-group-chat-application-in-java/

Save the file as GroupChat.java and compile it using javac and then run the program using two command line arguments: 
javac GroupChat.java
java GroupChat 239.0.0.0 1234   (ip address and port, the two arguments taken in by the main method)

Then enter your name and begin chatting.

A multicast host is specified by a class D IP address and by a standard UDP port number. Class D IP addresses are in the range 224.0.0.0 to 239.255.255.255, inclusive. The address 224.0.0.0 is reserved and should not be used.

Thanks to this Stackoverflow thread about running threads using Runnable interface: https://stackoverflow.com/questions/13327571/in-a-simple-to-understand-explanation-what-is-runnable-in-java
"A Runnable is basically a type of class (Runnable is an Interface) that can be put into a thread, describing what the thread is supposed to do."

Also thanks to a great article on Medium: https://medium.com/@AlexanderObregon/introduction-to-multicast-sockets-in-java-c276a897d8e8

And to a good explanation of what datagrampackets are on geekforgeeks.com: https://www.geeksforgeeks.org/java-net-datagrampacket-class-java/

Working running on 2 consoles
![image](https://github.com/Strawhorse/GroupChat/assets/47267071/7e8e5318-234c-45cd-9df4-94b177b84d03)
