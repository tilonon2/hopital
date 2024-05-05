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
        book.setImageSrc("/images/newpatients.png");
        book.setAuthor("Nouveaux patients");
        book.setName("3");
        ls.add(book);

        //Ajout
        book = new Book();

        book.setImageSrc("/images/rdvprevuscejour.png");
        book.setAuthor("RDV prévus ce jour");
        book.setName("0");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totaldespraticiens.png");
        book.setAuthor("Total des praticiens");
        book.setName("10");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totalpatient.png");
        book.setAuthor("Total des patients");
        book.setName("9");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/nouveaurdv.png");
        book.setAuthor("Nouveau RDV");
        book.setName("1");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/nouvellesconsultations.png");
        book.setAuthor("Nouvelles consultations");
        book.setName("1");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/consultation-medicale.png");
        book.setAuthor("Nouvelles hospitalisations");
        book.setName("1");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/nouveausoins.png");
        book.setAuthor("Nouveau soins");
        book.setName("1");

        ls.add(book);
        //Fin ajout


        //Ajout
        book = new Book();

        book.setImageSrc("/images/consultationencours.png");
        book.setAuthor("Consultation en cours...");
        book.setName("0");

        ls.add(book);
        //Fin ajout
        //Ajout
        book = new Book();

        book.setImageSrc("/images/hospitalisationsencours.png");
        book.setAuthor("Hospitalisations en cours...");
        book.setName("0");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totaldesprescriptions.png");
        book.setAuthor("Total des prescriptions");
        book.setName("5");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totaldesconsultations.png");
        book.setAuthor("Total des consultations");
        book.setName("5");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totaldessoins.png");
        book.setAuthor("Total des soins");
        book.setName("5");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/totaldeshospitalisations.png");
        book.setAuthor("Total des hospitalisations");
        book.setName("5");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/litoccupes.png");
        book.setAuthor("Lits occupés");
        book.setName("1");

        ls.add(book);
        //Fin ajout

        //Ajout
        book = new Book();

        book.setImageSrc("/images/litlibre.png");
        book.setAuthor("Lits libre");
        book.setName("10");

        ls.add(book);
        //Fin ajout


        return ls;

    }
}
