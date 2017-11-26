package org.lib.connectionxml;

import java.util.logging.Logger;
import org.lib.connection.LibConnection;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        context.registerService(LibConnection.class, new LibConnectionXML(), null);

    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
