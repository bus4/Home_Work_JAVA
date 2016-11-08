import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class client2 {

    public static void main(String[] args) throws IOException {
        int port = 6666;
        InetAddress address = InetAddress.getByName("127.0.0.1");

        Socket socket = new Socket(address, port);

        System.out.println("Мой сокет " + socket);

        new Thread(() -> {
            while (true){

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    String s = null;
                    s = "[Второй] " + reader.readLine();
                    if (s == null) {
                        break;
                    }
                    writer.write(s);
                    writer.newLine();
                    writer.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                }
        }).start();

        new Thread(() -> {
            while (true) {

                BufferedReader InReader = null;
                try {
                    InReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String sIn = null;
                    sIn = InReader.readLine();
                    if (sIn == null) {
                        break;
                    }
                    System.out.println(sIn);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        }
    }

