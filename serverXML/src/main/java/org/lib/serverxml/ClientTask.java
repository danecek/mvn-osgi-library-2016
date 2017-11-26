package org.lib.serverxml;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.lib.model.MyBooks;
import org.lib.protocol.AllBookCommand;
import org.lib.protocol.DeleteAllBookCommand;
import org.lib.protocol.Command;
import org.lib.protocol.CreateBookCommand;
import org.lib.protocol.DeleteBookCommand;
import org.lib.protocol.Ok;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class ClientTask implements Runnable {

    DataInputStream ois;
    DataOutputStream oos;
    private Marshaller jxbm;
    private Unmarshaller jxbu;

    public ClientTask(Socket s) throws IOException {
        try {
            oos = new DataOutputStream(s.getOutputStream());
            ois = new DataInputStream(s.getInputStream());
            JAXBContext jxbc = JAXBContext.newInstance(AllBookCommand.class,
                    ArrayList.class, DeleteAllBookCommand.class,
                    CreateBookCommand.class, DeleteBookCommand.class,
                    MyBooks.class, Ok.class);
            jxbm = jxbc.createMarshaller();
            jxbu = jxbc.createUnmarshaller();
        } catch (JAXBException ex) {
            Logger.getLogger(ClientTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

        try {
            for (;;) {
                LOG.info("waiting for command");
                Object result;
                try {
                    String comStr = ois.readUTF();
                    LOG.info("received: " + comStr);
                    Command com = (Command) jxbu.unmarshal(new StringReader(comStr));
                    LOG.info("umarshalled: " + com);
                    result = com.execute();
                } catch (LibException ex) {
                    result = ex;
                }
                LOG.info(result.toString());
                StringWriter sw = new StringWriter();
                jxbm.marshal(result, sw);
                String resXML = sw.toString();
                LOG.info("result:" + resXML);
                oos.writeUTF(resXML);
                oos.flush();
            }
        } catch (IOException | JAXBException ex) {
            Logger.getLogger(ClientTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static final Logger LOG = Logger.getLogger(ClientTask.class.getName());

}
