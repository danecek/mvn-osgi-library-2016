/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.integration;

import java.util.Collection;
import org.lib.model.Book;

public interface BookDAO {

    public void create(Book book);

    Collection<Book> all();
}
