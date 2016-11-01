/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

/**
 *
 * @author danecek
 */
public class MainWindow extends Stage {

    static Framework p;

    public MainWindow(final BundleContext context) {
        p = (Framework) context.getBundle(0);
        setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                stop();
            }
        });
 
       BookPane bp = new BookPane();
        bp.refresh();
        VBox vbox = new VBox();
        vbox.getChildren().addAll(new MenuBar(new FileMenu()), bp);
        Scene s = new Scene(vbox, 1200, 1000);
        setScene(s);
        show();
    }

    public static void stop() {
        try {
            p.waitForStop(1000);
            p.stop();
        } catch (BundleException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
