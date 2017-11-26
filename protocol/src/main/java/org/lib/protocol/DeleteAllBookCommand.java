package org.lib.protocol;

import javax.xml.bind.annotation.XmlRootElement;
import org.lib.business.LibraryFacadeService;
import org.lib.utils.LibException;

@XmlRootElement
public class DeleteAllBookCommand extends Command {

    @Override
    public <T> T execute() throws LibException {
        LibraryFacadeService.service().clearAllBook();
        return (T) ok;
    }

    public DeleteAllBookCommand() {
    }

}
