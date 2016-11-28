/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connection;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.richclient.LibAbstractAction;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class DisconnectAction extends LibAbstractAction {

    @Override
    public void execute() {
        try {
            LibConnection.inst.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(DisconnectAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DisconnectAction() {
        super(Messages.Disconnect.createMessage());
    }
    private static final Logger LOG = Logger.getLogger(DisconnectAction.class.getName());

}
