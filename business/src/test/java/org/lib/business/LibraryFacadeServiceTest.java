/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import junit.framework.TestCase;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.lib.model.MyBook;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class LibraryFacadeServiceTest {

    public LibraryFacadeServiceTest() {
    }

    @Test
    public void testService() throws LibException {
        LibraryFacadeService facade = LibraryFacadeService.service();
        TestCase.assertNotNull(facade);
        MyBook maj = new MyBook("Maj", "Macha");
      // facade.createBook(maj);
//        assertTrue(facade.allBook().getBooks().size() == 1);
    }

}
