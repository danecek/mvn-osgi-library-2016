/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business.impl;

import java.util.Collection;
import org.lib.business.LibraryFacadeService;
import org.lib.integration.DAOFactoryService;
import org.lib.model.Book;

/**
 *
 * @author danecek
 */
public class LibraryFacadeServiceImpl extends LibraryFacadeService {

    @Override
    public void createBook(Book book) {
        DAOFactoryService.service().getBookDAO().create(book);
    }

    @Override
    public Collection<Book> allBook() {
        return DAOFactoryService.service().getBookDAO().all();
    }

}
