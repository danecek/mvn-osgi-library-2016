package org.lib.protocol;

import javax.xml.bind.annotation.XmlRootElement;
import org.lib.business.LibraryFacadeService;
import org.lib.model.BookId;
import org.lib.utils.LibException;

@XmlRootElement
public class DeleteBookCommand extends Command {

    public BookId getBookId() {
        return bookId;
    }

    public void setBookId(BookId bookId) {
        this.bookId = bookId;
    }

    public DeleteBookCommand() {
    }

    private BookId bookId;

    @Override
    public <T> T execute() throws LibException {
        LibraryFacadeService.service().delete(getBookId());
        return (T) ok;
    }

    public DeleteBookCommand(BookId bookId) {
        this.bookId = bookId;
    }

}
