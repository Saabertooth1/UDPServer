import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {
    public static void main(String args[]) {
        try {
            int port = 8000;
            Robot robot = new Robot();

            // Create a socket to listen on the port.
            DatagramSocket dsocket = new DatagramSocket(port);

            // Create a buffer to read datagrams into. If a
            // packet is larger than this buffer, the
            // excess will simply be discarded!
            byte[] buffer = new byte[2048];

            // Create a packet to receive data into the buffer
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Now loop forever, waiting to receive packets and printing them.
            while (true) {
                // Wait to receive a datagram
                dsocket.receive(packet);

                // Convert the contents to a string, and display them
                String msg = new String(buffer, 0, packet.getLength());
                System.out.println(packet.getAddress().getHostName() + ": " + msg);

                switch (msg){
                    case "pausa":
                        robot.keyPress(KeyEvent.VK_SPACE);
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        break;

                    case "+5s":
                        robot.keyPress(KeyEvent.VK_RIGHT);
                        robot.keyRelease(KeyEvent.VK_RIGHT);
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_RIGHT);
                        robot.keyRelease(KeyEvent.VK_RIGHT);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        break;

                    case "-5s":
                        robot.keyPress(KeyEvent.VK_LEFT);
                        robot.keyRelease(KeyEvent.VK_LEFT);
                        break;

                    case "m":
                        robot.keyPress(KeyEvent.VK_M);
                        robot.keyRelease(KeyEvent.VK_M);
                        robot.keyPress(KeyEvent.VK_ALT_GRAPH);
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_DOWN);
                        robot.keyRelease(KeyEvent.VK_DOWN);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        robot.keyRelease(KeyEvent.VK_ALT_GRAPH);
                        break;

                    case "f":
                        robot.keyPress(KeyEvent.VK_F);
                        robot.keyRelease(KeyEvent.VK_F);
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_F);
                        robot.keyRelease(KeyEvent.VK_F);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        break;

                    case "up":
                        robot.keyPress(KeyEvent.VK_UP);
                        robot.keyRelease(KeyEvent.VK_UP);
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_UP);
                        robot.keyRelease(KeyEvent.VK_UP);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        break;

                    case "down":
                        robot.keyPress(KeyEvent.VK_DOWN);
                        robot.keyRelease(KeyEvent.VK_DOWN);
                        break;

                    case "0":
                        robot.keyPress(KeyEvent.VK_0);
                        robot.keyRelease(KeyEvent.VK_0);
                        break;
                    case "nueva lista":
                        robot.keyPress(0x8);
                        robot.keyPress(KeyEvent.VK_N);
                        robot.keyRelease(KeyEvent.VK_N);
                        robot.keyRelease(0x8);

                        /**robot.keyPress(KeyEvent.VK_A);
                        robot.keyRelease(KeyEvent.VK_A);
                        robot.keyPress(KeyEvent.VK_N);
                        robot.keyRelease(KeyEvent.VK_N);**/

                }




                // Reset the length of the packet before reusing it.
                packet.setLength(buffer.length);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}