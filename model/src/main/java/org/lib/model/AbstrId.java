/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.model;

/**
 *
 * @author danecek
 */
public class AbstrId<T extends AbstrId> implements Comparable<T> {

    private final Integer id;

    public int compareTo(T o) {
        return getId() - o.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        return compareTo((T) obj) == 0;
    }

    public AbstrId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

}
