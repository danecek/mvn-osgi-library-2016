/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.proxy;

import java.util.Collection;
import org.lib.connection.LibConnection;
import org.lib.business.LibraryFacadeService;
import org.lib.model.MyBook;
import org.lib.protocol.AllBook;
import org.lib.protocol.ClearAllBook;
import org.lib.protocol.CreateBook;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class LibraryFacadeServiceProxy extends LibraryFacadeService {

    @Override
    public void createBook(MyBook book) throws LibException {
        LibConnection.inst.send(new CreateBook(book));
    }

    @Override
    public Collection<MyBook> allBook() throws LibException {
       return LibConnection.inst.send(new AllBook());
    }

    @Override
    public void clearAllBook() throws LibException {
       LibConnection.inst.send(new ClearAllBook());
    }

//    private void send(CreateBook createBook) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
