/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.controller;

import org.lib.richclient.view.MainWindow;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class CreateBookAction extends LibAbstractAction {

    public static CreateBookAction inst = new CreateBookAction();

    private CreateBookAction() {
        super(Messages.Create_book.createMessage());
    }

    @Override
    public void execute() {
        new CreateBookDialog().execute();
    }


}
