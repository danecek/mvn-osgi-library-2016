package org.lib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyBooks implements Serializable {

    public Collection<MyBook> getBooks() {
        return books;
    }

    public void setBooks(Collection<MyBook> books) {
        this.books = books;
    }

    private Collection<MyBook> books;

    public MyBooks(Collection<MyBook> books) {
        this.books = books;
    }

    public MyBooks() {
        books = new ArrayList<>();
    }

}
