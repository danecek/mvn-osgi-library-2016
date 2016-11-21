/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.integration;

import org.lib.integration.impl.DAOFactoryServiceImpl;
import org.osgi.util.tracker.ServiceTracker;

public abstract class DAOFactoryService {

    private static DAOFactoryService service;
    private static ServiceTracker<DAOFactoryService, DAOFactoryService> st;

    public static DAOFactoryService service() {
        service = st.getService();
        if (service == null) {
            service = new DAOFactoryServiceImpl();
        }
        return service;
    }

    public abstract BookDAO getBookDAO();


    /**
     * @param aSt the st to set
     */
    public static void setSt(ServiceTracker<DAOFactoryService, DAOFactoryService> aSt) {
        st = aSt;
    }

}
