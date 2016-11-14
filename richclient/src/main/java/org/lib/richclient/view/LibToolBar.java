/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.view;

import javafx.scene.control.ToolBar;
import org.lib.richclient.controller.ClearAllBooksAction;
import org.lib.richclient.controller.CreateBookAction;
import org.lib.richclient.controller.ExitAction;

/**
 *
 * @author danecek
 */
public class LibToolBar extends ToolBar {

    public LibToolBar() {
        getItems().addAll(ExitAction.inst.createButton(),
                CreateBookAction.inst.createButton(),
                ClearAllBooksAction.inst.createButton()
                );
    }
    
    
}
