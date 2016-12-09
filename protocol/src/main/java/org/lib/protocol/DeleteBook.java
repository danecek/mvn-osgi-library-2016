package org.lib.protocol;

import org.lib.business.LibraryFacadeService;
import org.lib.model.BookId;
import org.lib.utils.LibException;

public class DeleteBook extends Command {

    private BookId bookId;

    @Override
    public <T> T execute() throws LibException {
        LibraryFacadeService.service().delete(bookId);
        return (T) OK;
    }

    public DeleteBook(BookId bookId) {
        this.bookId = bookId;
    }

}
