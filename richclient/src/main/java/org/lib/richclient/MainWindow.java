/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author danecek
 */
public class MainWindow extends Stage {

    public MainWindow() {
        BorderPane bp = new BorderPane(new Rectangle(100, 50));
        Scene s = new Scene(bp, 800, 600);
        setScene(s);
        show();
    }

}
