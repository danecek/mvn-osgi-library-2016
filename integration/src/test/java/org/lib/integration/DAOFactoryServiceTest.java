/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.integration;

import org.junit.Test;
import static org.junit.Assert.*;
import org.lib.model.Book;

/**
 *
 * @author danecek
 */
public class DAOFactoryServiceTest {

    public DAOFactoryServiceTest() {
    }

    @org.junit.Test
    public void testInst() {
    }

    @org.junit.Test
    public void testGetBookDAO() {
        BookDAO bookDAO = DAOFactoryService.inst().getBookDAO();
        bookDAO.create(new Book("title", "autho"));
        assertTrue(bookDAO.all().contains(this));
    }

    public class DAOFactoryServiceImpl extends DAOFactoryService {

        public BookDAO getBookDAO() {
            return null;
        }
    }

}
