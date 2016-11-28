/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connection;

import java.util.logging.Logger;
import org.lib.richclient.LibAbstractAction;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class ConnectAction extends LibAbstractAction {

    @Override
    public void execute() {
        new ConnectDialog().execute();
    }

    public ConnectAction() {
        super(Messages.Connect.createMessage());
    }
    private static final Logger LOG = Logger.getLogger(ConnectAction.class.getName());
    
}
