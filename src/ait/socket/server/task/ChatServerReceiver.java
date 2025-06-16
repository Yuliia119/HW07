package ait.socket.server.task;

import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class ChatServerReceiver implements Runnable{
    private final Socket socket;
    private final BlockingQueue<String> messageBox;

    public ChatServerReceiver(Socket socket, BlockingQueue<String> messageBox) {
        this.socket = socket;
        this.messageBox = messageBox;
    }

    @Override
    public void run() {

    }
}
