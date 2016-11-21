/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.protocol.Command;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class ClientTask implements Runnable {

    ObjectInputStream ois;
    ObjectOutputStream oos;

    public ClientTask(Socket s) throws IOException {
        ois = new ObjectInputStream(s.getInputStream());
        oos = new ObjectOutputStream(s.getOutputStream());
    }

    @Override
    public void run() {

        try {
            for (;;) {
                try {
                    Command com;
                    com = (Command) ois.readObject();
                    Object result = com.execute();
                    oos.writeObject(result);
                } catch (LibException ex) {
                    oos.writeObject(ex);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
