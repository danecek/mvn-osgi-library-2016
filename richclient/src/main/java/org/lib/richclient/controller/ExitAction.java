/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.controller;

import org.lib.richclient.view.MainWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class ExitAction extends LibAbstractAction {

    public static ExitAction inst = new ExitAction();

    private ExitAction() {
        super(Messages.Exit.createMessage());
    }

    @Override
    public void execute() {
        MainWindow.stop();
    }


}
