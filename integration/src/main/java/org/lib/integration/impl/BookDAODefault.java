/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.integration.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.lib.integration.BookDAO;
import org.lib.model.Book;
import org.lib.model.BookId;

/**
 *
 * @author danecek
 */
public class BookDAODefault implements BookDAO {

    Map<BookId, Book> books = new HashMap<>();
    static int counter;

    public void create(Book book) {
        BookId bookId = new BookId(++counter);
        books.put(bookId, new Book(bookId, book.getTitle(), book.getTitle()));
    }

    public Collection<Book> all() {
        return new ArrayList<>(books.values());
    }

}
