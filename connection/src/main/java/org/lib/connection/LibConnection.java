package org.lib.connection;

import org.lib.connection.impl.LibConnectionDefault;
import java.io.IOException;
import org.lib.protocol.Command;
import org.lib.utils.LibException;
import org.osgi.util.tracker.ServiceTracker;

public abstract class LibConnection {

    public static void setSt(ServiceTracker<LibConnection, LibConnection> aSt) {
        st = aSt;
    }

    private static LibConnection service;

    private static ServiceTracker<LibConnection, LibConnection> st;

    public static LibConnection getService() {
        if (service == null) {
            service = st.getService();
            if (service == null) {
                service = new LibConnectionDefault();
            }
        }
        return service;
    }

    public abstract void connect(String host, int port) throws IOException;

    public abstract boolean isConnected();

    public abstract void disconnect() throws IOException;

    public abstract <T> T send(Command com) throws LibException;

}
