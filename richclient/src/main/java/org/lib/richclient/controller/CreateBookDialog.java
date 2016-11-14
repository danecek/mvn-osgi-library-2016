/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.controller;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.lib.business.LibraryFacadeService;
import org.lib.model.MyBook;
import org.lib.richclient.LibObservable;
import org.lib.richclient.view.MyAlert;
import org.lib.utils.LibException;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public final class CreateBookDialog extends Dialog<ButtonType> implements MyValidator {

    MyTextField authorTf;
    MyTextField titleTf;

    Text errorMessage = new Text();
    private String author;
    private String title;

    Node content() {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(5));
        gp.setHgap(5);
        gp.setVgap(5);
        gp.add(new Label(Messages.Author.createMessage()), 0, 0);
        gp.add(authorTf = new MyTextField(this), 1, 0);
        gp.add(new Label(Messages.Title.createMessage()), 0, 1);
        gp.add(titleTf = new MyTextField(this), 1, 1);
        return gp;
    }

    public CreateBookDialog() {
        setTitle(Messages.Create_book.createMessage());
        getDialogPane().setContent(new VBox(content(), errorMessage));
        getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
        validate();
    }

    public void ok() {
        try {
            validate();
            MyBook book = new MyBook(title, author);
            LibraryFacadeService.service().createBook(book);
            LibObservable.INST.stateChanged();
        } catch (LibException ex) {
            MyAlert.error(ex);
        }
    }

    public void execute() {
        Optional<ButtonType> result = showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ok();
        }
    }

    @Override
    public boolean validate() {
        author = authorTf.getText();
        if (author.isEmpty()) {
            errorMessage.setText(Messages.Empty_author.createMessage());
            return false;
        }
        title = titleTf.getText();
        if (title.isEmpty()) {
            errorMessage.setText(Messages.Empty_title.createMessage());
            return false;
        }
        errorMessage.setText("");
        return true;
    }

}
