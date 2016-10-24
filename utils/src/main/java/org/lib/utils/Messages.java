/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.utils;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public enum Messages {

    Library;

    private static final Logger LOG = Logger.getLogger(Messages.class.getName());
    private static final ResourceBundle rb = ResourceBundle.getBundle("org.lib.utils.Messages");

    public String createMessage(String... args) {
        try {
            String m = (String) rb.getString(this.name());
            return MessageFormat.format(m, args);
        } catch (MissingResourceException ex) {
            LOG.log(Level.SEVERE, "missing resource", ex);
            return name();
        }
    }

}
