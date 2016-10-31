/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.integration;

import org.lib.integration.impl.DAOFactoryServiceImpl;

public abstract class DAOFactoryService {

    private static DAOFactoryService service;

    public static DAOFactoryService service() {
        // todo
        if (service == null) {
            service = new DAOFactoryServiceImpl();
        }
        return service;
    }

    public abstract BookDAO getBookDAO();
//    public  UserDAO getUserDAO() {
//        return null;
//    }

}
