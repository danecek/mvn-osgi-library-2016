package org.lib.derbydb;

import org.lib.integration.DAOFactoryService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        DerbyDAOFactoryService ds = new DerbyDAOFactoryService();
        context.registerService(DAOFactoryService.class, ds, null);
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
