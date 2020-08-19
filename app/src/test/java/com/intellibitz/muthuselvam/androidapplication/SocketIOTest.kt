package com.intellibitz.muthuselvam.androidapplication;

import org.junit.Test;

import java.net.URISyntaxException;
import java.util.Arrays;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Created by muthuselvam on 04-02-2016.
 */
public class SocketIOTest {

    @Test
    public void socket_io() throws Exception {
        // write your code here
        final Socket socket;
        try {
            socket = IO.socket("http://ec2-54-169-147-206.ap-southeast-1.compute.amazonaws.com:3010");
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Connect.....");
                    socket.emit("my other event", "968768");
                    socket.emit("test1", "968768");
                    socket.emit("test_send_msg", "This is from Android .. woohoooo");
//                    socket.disconnect();
                }
            }).on(Socket.EVENT_ERROR, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Error.....");
                    // socket.emit("my other event", "968768");
//                    socket.disconnect();
                }
            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Disconnect.....");
                    // socket.emit("my other event", "968768");
//                    socket.disconnect();
                }
            }).on("test_new_msg", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Listening....." + Arrays.toString(args));
                    // socket.emit("my other event", "968768");
//                    socket.disconnect();
                }
            }).on("test2", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Listening....." + Arrays.toString(args));
                    // socket.emit("my other event", "968768");
//                    socket.disconnect();
                }
            });
            socket.connect();
//            Thread.sleep(5000);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
