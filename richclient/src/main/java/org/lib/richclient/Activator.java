package org.lib.richclient;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MainWindow.instance.setContext(context);
            }
        });

    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
