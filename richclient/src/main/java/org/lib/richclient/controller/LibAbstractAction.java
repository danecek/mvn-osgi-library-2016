/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

/**
 *
 * @author danecek
 */
public abstract class LibAbstractAction {
    String name;

    public LibAbstractAction(String name) {
        this.name = name;
    }
    
    public abstract void execute();

    public MenuItem createItem() {
        MenuItem mi = new MenuItem(name);
        mi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                execute();
            }
        });
        return mi;
    }
    
}
