/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.protocol;

import javax.xml.bind.annotation.XmlRootElement;
import org.lib.business.LibraryFacadeService;
import org.lib.model.MyBook;
import org.lib.utils.LibException;

@XmlRootElement
public class CreateBookCommand extends Command {

    /**
     * @return the myBook
     */
    public MyBook getMyBook() {
        return myBook;
    }

    /**
     * @param myBook the myBook to set
     */
    public void setMyBook(MyBook myBook) {
        this.myBook = myBook;
    }

    private MyBook myBook;

    @Override
    public <T> T execute() throws LibException {
        LibraryFacadeService.service().createBook(getMyBook());
        return (T) ok;
    }

    public CreateBookCommand(MyBook myBook) {
        this.myBook = myBook;
    }

    public CreateBookCommand() {
    }

}
