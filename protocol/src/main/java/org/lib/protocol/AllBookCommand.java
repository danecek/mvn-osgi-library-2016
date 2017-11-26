package org.lib.protocol;

import javax.xml.bind.annotation.XmlRootElement;
import org.lib.business.LibraryFacadeService;
import org.lib.utils.LibException;

@XmlRootElement
public class AllBookCommand extends Command {

    @Override
    public <T> T execute() throws LibException {
        return (T) LibraryFacadeService.service().allBook();
    }

    public AllBookCommand() {
    }

}
