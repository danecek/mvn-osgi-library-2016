package org.lib.integration;

import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

    public void start(BundleContext context) throws Exception {
       LOG.info("");
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
