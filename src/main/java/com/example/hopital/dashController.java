package com.example.hopital;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import model.Book;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class dashController implements Initializable {
    @FXML
    private HBox cardLayoout;
    private List<Book> recentlyAdded;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyAdded = new ArrayList<>(recentlyAdded());
        try{
            for(int i=0; i<recentlyAdded.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                HBox cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setData(recentlyAdded.get(i));
                cardLayoout.getChildren().add(cardBox);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Book> recentlyAdded() {
        List<Book> ls = new ArrayList<>();

        //Ajout
        Book book = new Book();

        book.setImageSrc("/images/book1.jpg");
        book.setName("book1");
        book.setAuthor("John");

        ls.add(book);
        //Fin ajout

    }
}
