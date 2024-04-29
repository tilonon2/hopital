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

        Book book = new Book();
        book.setImageSrc("/images/nouveauxpatients.jpg");
        book.setName("Nouveaux patients");
        book.setAuthor("3");
        ls.add(book);

        //Ajout
        book = new Book();

        book.setImageSrc("/images/rdvprevuscejour.png");
        book.setName("RDV prévus ce jour");
        book.setAuthor("0");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totaldespraticiens.jpg");
        book.setName("Total des praticiens");
        book.setAuthor("10");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totalpatient.png");
        book.setName("Total des patients");
        book.setAuthor("9");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/nouveaurdv.png");
        book.setName("Nouveau RDV");
        book.setAuthor("1");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/nouvellesconsultations.png");
        book.setName("Nouvelles consultations");
        book.setAuthor("1");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/consultation-medicale.png");
        book.setName("Nouvelles hospitalisations");
        book.setAuthor("1");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/nouveausoins.png");
        book.setName("Nouveau soins");
        book.setAuthor("1");

        ls.add(book);
        //Fin ajout


        //Ajout
        book = new Book();

        book.setImageSrc("/images/consultationencours.png");
        book.setName("Consultation en cours...");
        book.setAuthor("0");

        ls.add(book);
        //Fin ajout
        //Ajout
        book = new Book();

        book.setImageSrc("/images/hospitalisationsencours.png");
        book.setName("Hospitalisations en cours...");
        book.setAuthor("0");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totaldesprescriptions.png");
        book.setName("Total des prescriptions");
        book.setAuthor("5");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totaldesconsultations.png");
        book.setName("Total des consultations");
        book.setAuthor("5");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totaldessoins.png");
        book.setName("Total des soins");
        book.setAuthor("5");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totaldeshospitalisations.png");
        book.setName("Total des hospitalisations");
        book.setAuthor("5");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/litoccupes.png");
        book.setName("Lits occupés");
        book.setAuthor("1");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/litlibre.png");
        book.setName("Lits libre");
        book.setAuthor("10");

        ls.add(book);
        //Fin ajout


        return ls;

    }
}
