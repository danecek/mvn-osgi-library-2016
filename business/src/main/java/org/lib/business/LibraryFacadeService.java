/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import java.util.Collection;
import org.lib.business.impl.LibraryFacadeServiceImpl;
import org.lib.model.MyBook;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public abstract class LibraryFacadeService {

    private static LibraryFacadeService service;

    public static LibraryFacadeService service() {
        // todo
        if (service == null) {
            service = new LibraryFacadeServiceImpl();
        }
        return service;
    }

    public abstract void createBook(MyBook book) throws LibException;

    public abstract Collection<MyBook> allBook() throws LibException;

    public abstract void clearAllBook() throws LibException;
}
