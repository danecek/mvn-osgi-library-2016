/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.integration;

import org.lib.integration.impl.DAOFactoryServiceImpl;


public abstract class DAOFactoryService {

    public static DAOFactoryService inst() {
        return new DAOFactoryServiceImpl();
    }

    public abstract BookDAO getBookDAO();

}
