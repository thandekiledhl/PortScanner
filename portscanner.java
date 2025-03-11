//This Java Port Scanner scans a IP address provided by the user over a specified range of ports to check for open ports. 
//The results are displayed on the terminal and file (scan_results.txt) is logged.
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class portscanner {
    private static final int THREAD_POOL_SIZE = 50;  // Number of threads to use
    private static final String LOG_FILE = "scan_results.txt";  // Log file for results

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java PortScanner <IP Address> <Start Port> <End Port>");
            return;
        } //takes command line arguments for IP address, start port, and end port

        String targetIP = args[0];
        int startPort = Integer.parseInt(args[1]);
        int endPort = Integer.parseInt(args[2]);

        System.out.println("Scanning " + targetIP + " from port " + startPort + " to " + endPort);
        
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE); //speeds up scannning by using multiple threads

        for (int port = startPort; port <= endPort; port++) {
            int finalPort = port;
            executor.execute(() -> scanPort(targetIP, finalPort));
        } //loops through the range of ports and scans each port using a  thread

        executor.shutdown();
    }

    private static void scanPort(String ip, int port) {
        try {
            Socket socket = new Socket(ip, port);
            System.out.println("Port " + port + " is OPEN");
            logResult("Port " + port + " is OPEN");
            socket.close();
        } catch (IOException e) {
            // Port is closed or inaccessible
        }
    }

    private static void logResult(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    } //writes open ports to a log file
}
