/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.protocol;

import org.lib.business.LibraryFacadeService;
import org.lib.model.MyBook;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class CreateBook extends Command {

    MyBook myBook;

    @Override
    <T> T execute() throws LibException {
        LibraryFacadeService.service().createBook(myBook);
        return (T) OK;
    }

    public CreateBook(MyBook myBook) {
        this.myBook = myBook;
    }

}
