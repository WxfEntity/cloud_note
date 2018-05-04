package cn.wxf.note.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by TYZ027 on 2018/1/15.
 */
public class GreetingServer extends Thread{

    private static final int MAX_THREADS = 5;
    ExecutorService pool= Executors.newFixedThreadPool(5);
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run() {
        while(true) {
            InputStream in = null;
            try {
                int recvMsgSize = 0;
                byte[] recvBuf = new byte[1024];
                while(true){
                    Socket clntSocket = serverSocket.accept();
                    SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
                    System.out.println("Handling client at "+clientAddress);
                    in = clntSocket.getInputStream();
                    while((recvMsgSize=in.read(recvBuf))!=-1){
                        byte[] temp = new byte[recvMsgSize];
                        System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
                        System.out.println(new String(temp));
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally{
                try{
                    if(serverSocket!=null){
                        serverSocket.close();
                    }
                    if(in!=null){
                        in.close();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String [] args) {
        int port = 8080;
        try {
            Thread t = new GreetingServer(port);
            t.run();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
