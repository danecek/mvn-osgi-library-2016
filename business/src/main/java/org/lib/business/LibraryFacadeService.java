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
import org.osgi.util.tracker.ServiceTracker;

/**
 *
 * @author danecek
 */
public abstract class LibraryFacadeService {

    private static LibraryFacadeService service;
    private static ServiceTracker<LibraryFacadeService, LibraryFacadeService> xst;

    public static LibraryFacadeService service() {
        service = xst.getService();
        if (service == null) {
            service = new LibraryFacadeServiceImpl();
        }
        return service;
    }

    static void setSt(ServiceTracker<LibraryFacadeService, LibraryFacadeService> st) {
        xst = st;
    }

    public abstract void createBook(MyBook book) throws LibException;

    public abstract Collection<MyBook> allBook() throws LibException;

    public abstract void clearAllBook() throws LibException;
}
