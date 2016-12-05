/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.lib.richclient.controller.FileMenu;
import org.lib.richclient.view.BookPane;
import org.lib.richclient.view.LibToolBar;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

public class MainWindow extends Stage {

    /**
     * @return the instance
     */
    public static synchronized MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
        }
        return instance;
    }

    /**
     * @return the context
     */
    public BundleContext getContext() {
        return context;
    }

    /**
     * @param aContext the context to set
     */
    public void setContext(BundleContext aContext) {
        context = aContext;
    }

    //   static Framework p;
    MenuBar menuBar;
    LibToolBar libToolBar;

    private static MainWindow instance;

    private BundleContext context;

    public void addMenu(Menu menu) {
        menuBar.getMenus().add(menu);
    }

    public void addTollButton(Button but) {
        libToolBar.getItems().add(but);
    }

    private MainWindow() {

        setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                stop();
            }
        });

        BookPane bp = new BookPane();
        bp.refresh();
        VBox vbox = new VBox();
        vbox.getChildren().addAll(menuBar = new MenuBar(new FileMenu()),
                libToolBar = new LibToolBar(), bp);
        Scene s = new Scene(vbox, 1200, 1000);
        setScene(s);
        show();
    }

    public void stop() {
        Framework p = (Framework) context.getBundle(0);
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
