/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import org.lib.business.LibraryFacadeService;
import org.lib.model.Book;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class BookPane extends TitledPane {

    ObservableList<Book> books = FXCollections.observableArrayList();

    public BookPane() {
        super(Messages.Books.createMessage(), null);
        setContent(createContent());
    }

    private Node createContent() {
        TableView<Book> table = new TableView<Book>();
        TableColumn<Book, Integer> idCol = new TableColumn<Book, Integer>(Messages.Id.createMessage());
        idCol.setCellValueFactory(
                new PropertyValueFactory<Book, Integer>("bookId"));
        TableColumn<Book, String> titleCol = new TableColumn<>(Messages.Title.createMessage());
        titleCol.setCellValueFactory(
                new PropertyValueFactory<Book, String>("title"));
        TableColumn<Book, String> authCol = new TableColumn<>(Messages.Author.createMessage());
        authCol.setCellValueFactory(
                new PropertyValueFactory<Book, String>("author"));
        table.getColumns().addAll(idCol, titleCol, authCol);
        table.setItems(books);
        return table;
    }

    public void refresh() {
        books.clear();
        books.addAll(LibraryFacadeService.service().allBook());
    }

}
