/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.protocol;

import org.lib.business.LibraryFacadeService;
import org.lib.utils.LibException;

public class AllBook extends Command {

    @Override
    <T> T execute() throws LibException {
        return (T) LibraryFacadeService.service().allBook();
    }
    
}
