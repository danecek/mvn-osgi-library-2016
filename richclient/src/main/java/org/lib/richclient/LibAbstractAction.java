/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

/**
 *
 * @author danecek
 */
public abstract class LibAbstractAction {
    String name;

    public LibAbstractAction(String name) {
        this.name = name;
    }
    
    public abstract void execute();
    
}
