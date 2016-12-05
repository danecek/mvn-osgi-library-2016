package org.lib.connection;

import java.util.logging.Logger;
import javafx.application.Platform;
import org.lib.richclient.MainWindow;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MainWindow.getInstance().addTollButton(ConnectAction.instance.createButton());
                MainWindow.getInstance().addTollButton(DisconnectAction.instance.createButton());
            }
        });

    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
