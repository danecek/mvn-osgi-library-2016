/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connectionxml;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.lib.connection.LibConnection;
import org.lib.model.MyBooks;
import org.lib.protocol.AllBookCommand;
import org.lib.protocol.DeleteAllBookCommand;
import org.lib.protocol.Command;
import org.lib.protocol.CreateBookCommand;
import org.lib.protocol.DeleteBookCommand;
import org.lib.protocol.Ok;
import org.lib.utils.LibException;
import org.lib.utils.Messages;
import static org.lib.utils.Messages.Books;

public class LibConnectionXML extends LibConnection {

    private Socket s;
    private DataInputStream ois;
    private DataOutputStream oos;
    private Marshaller jxbm;
    private Unmarshaller jxbu;

    @Override
    public void connect(String host, int port) throws IOException {
        s = new Socket(host, port);
        s.setSoTimeout(5000);
        ois = new DataInputStream(s.getInputStream());
        oos = new DataOutputStream(s.getOutputStream());
        try {
            JAXBContext jxbc = JAXBContext.newInstance(AllBookCommand.class,
                    CreateBookCommand.class, DeleteBookCommand.class, 
                    DeleteAllBookCommand.class, MyBooks.class, Ok.class);
            jxbm = jxbc.createMarshaller();
            jxbu = jxbc.createUnmarshaller();
        } catch (JAXBException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean isConnected() {
        return s != null;
    }

    @Override
    public void disconnect() throws IOException {
        try (Socket s = this.s;
                DataOutputStream oos = this.oos;
                DataInputStream ois = this.ois) {
        }
        s = null;
    }

    @Override
    public <T> T send(Command com) throws LibException {
        if (!isConnected()) {
            throw new LibException(Messages.Not_connected.createMessage());
        }
        try {
            StringWriter sw = new StringWriter();
            jxbm.marshal(com, sw);
            String comStr = sw.toString();
            LOG.info(comStr);
            oos.writeUTF(comStr);
            oos.flush();
            String resStr = ois.readUTF();
            LOG.info("received: " + resStr);
            Object res = jxbu.unmarshal(new StringReader(resStr));
            if (res instanceof LibException) {
                throw (LibException) res;
            }
            return (T) res;
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new LibException(ex);
        } catch (JAXBException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

    }
    private static final Logger LOG = Logger.getLogger(LibConnectionXML.class.getName());

}
