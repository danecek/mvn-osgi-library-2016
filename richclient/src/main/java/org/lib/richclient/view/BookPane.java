/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.view;

import org.lib.richclient.MyAlert;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import org.lib.business.LibraryFacadeService;
import org.lib.model.MyBook;
import org.lib.richclient.controller.LibObservable;
import org.lib.utils.LibException;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class BookPane extends TitledPane implements Observer {

    ObservableList<MyBook> books = FXCollections.observableArrayList();

    public BookPane() {
        super(Messages.Books.createMessage(), null);
        setContent(createContent());
        LibObservable.INST.addObserver(this);
    }

    private Node createContent() {
        TableView<MyBook> table = new TableView<MyBook>();
        TableColumn<MyBook, Integer> idCol = new TableColumn<MyBook, Integer>(Messages.Id.createMessage());
        idCol.setCellValueFactory(new PropertyValueFactory<MyBook, Integer>("bookId"));
        TableColumn<MyBook, String> titleCol = new TableColumn<>(Messages.Title.createMessage());
        titleCol.setCellValueFactory(new PropertyValueFactory<MyBook, String>("title"));
        TableColumn<MyBook, String> authCol = new TableColumn<>(Messages.Author.createMessage());
        authCol.setCellValueFactory(new PropertyValueFactory<MyBook, String>("author"));
        table.getColumns().addAll(idCol, titleCol, authCol);
        table.setItems(books);
        return table;
    }

    public void refresh() {
        try {
            books.setAll(LibraryFacadeService.service().allBook());
        } catch (LibException ex) {
            MyAlert.error(ex);
        }
         
    }

    @Override
    public void update(Observable o, Object arg) {
        refresh();
    }

}
