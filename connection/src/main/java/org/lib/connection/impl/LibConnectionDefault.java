/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connection.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.connection.LibConnection;
import org.lib.model.MyBook;
import org.lib.protocol.Command;
import org.lib.utils.LibException;
import org.lib.utils.Messages;

public class LibConnectionDefault extends LibConnection {
    
      
    public static final Class[] x = {MyBook.class};
    private Socket s;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    
    @Override
    public void connect(String host, int port) throws IOException {
        s = new Socket(host, port);
        s.setSoTimeout(1000);
        ois = new ObjectInputStream(s.getInputStream());
        oos = new ObjectOutputStream(s.getOutputStream());
    }
    
    @Override
    public boolean isConnected() {
        return s != null;
    }
    
    public void disconnect() throws IOException {
        try (Socket s = this.s;
                ObjectOutputStream oos = this.oos;
                ObjectInputStream ois = this.ois) {
        }
        s = null;
    }
    
    @Override
    public <T> T send(Command com) throws LibException {
        if (!isConnected()) {
            throw new LibException(Messages.Not_connected.createMessage());
        }
        try {
            LOG.info(com.toString());
            oos.writeObject(com);
            oos.flush();
            T res = (T) ois.readObject();
            if (res instanceof LibException) {
                throw (LibException) res;
            }
            return res;
        } catch (IOException ex) {
            throw new LibException(ex);
        } catch (ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        
    }
    private static final Logger LOG = Logger.getLogger(LibConnectionDefault.class.getName());
    
}
