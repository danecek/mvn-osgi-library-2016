/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.business.LibraryFacadeService;
import org.lib.richclient.LibObservable;
import org.lib.richclient.view.MyAlert;
import org.lib.utils.LibException;
import org.lib.utils.Messages;

public class ClearAllBooksAction extends LibAbstractAction {

    public static ClearAllBooksAction inst = new ClearAllBooksAction();

    private ClearAllBooksAction() {
        super(Messages.Clear_all_books.createMessage());
    }

    @Override
    public boolean checkDisable() {
        try {
            return LibraryFacadeService.service().allBook().isEmpty();
        } catch (LibException ex) {
            return false;
        }
    }

    @Override
    public void execute() {
        try {
            LibraryFacadeService.service().clearAllBook();
            LibObservable.INST.stateChanged();
        } catch (LibException ex) {
            Logger.getLogger(ClearAllBooksAction.class.getName()).log(Level.SEVERE, null, ex);
            MyAlert.error(ex);
        }
    }

}
