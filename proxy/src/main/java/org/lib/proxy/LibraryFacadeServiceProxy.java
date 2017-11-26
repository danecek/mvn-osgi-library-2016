/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.proxy;

import java.util.Collection;
import org.lib.business.LibraryFacadeService;
import org.lib.connection.LibConnection;
import org.lib.model.BookId;
import org.lib.model.MyBook;
import org.lib.model.MyBooks;
import org.lib.protocol.AllBookCommand;
import org.lib.protocol.DeleteAllBookCommand;
import org.lib.protocol.CreateBookCommand;
import org.lib.protocol.DeleteBookCommand;
import org.lib.utils.LibException;

public class LibraryFacadeServiceProxy extends LibraryFacadeService {

    @Override
    public void createBook(MyBook book) throws LibException {
        LibConnection.getService().send(new CreateBookCommand(book));
    }

    @Override
    public MyBooks allBook() throws LibException {
        return LibConnection.getService().send(new AllBookCommand());
    }

    @Override
    public void clearAllBook() throws LibException {
        LibConnection.getService().send(new DeleteAllBookCommand());
    }

    @Override
    public boolean isConnected() {
        return LibConnection.getService().isConnected();
    }

    @Override
    public void delete(BookId bookId) throws LibException {
        LibConnection.getService().send(new DeleteBookCommand(bookId));
    }

}
