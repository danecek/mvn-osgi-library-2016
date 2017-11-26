package org.lib.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookId extends AbstrId<BookId> {

    public BookId() {
    }
    
    public BookId(Integer id) {
        super(id);
    }

}
