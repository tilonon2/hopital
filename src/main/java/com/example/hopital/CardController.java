package com.example.hopital;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.Book;

public class CardController{

    @FXML
    private Label authorName;

    @FXML
    private Label bookName;

    @FXML
    private HBox box;

    @FXML
    private ImageView bookImage;

    //generer les couleurs du cadre Aléatoirement

    private String [] colors = {"#000000", "#000000", "#000000", "#000000"};

    public void setData(Book book){
        Image image = new Image(getClass().getResourceAsStream(book.getImageSrc()));
        bookImage.setImage(image);

        bookName.setText(book.getName());
        authorName.setText(book.getAuthor());
        box.setStyle("-fx-background-color: " + Color.web(colors[(int) (Math.random() * colors.length)]));
    }

}
