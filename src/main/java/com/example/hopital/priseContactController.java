package com.example.hopital;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class priseContactController {

    private Scanner in;


    @FXML
    private Label alertage;

    @FXML
    private Label alertmob;

    @FXML
    private Label alertname;

    @FXML
    private Label alertname1;

    @FXML
    private Button btnback;

    @FXML
    private Button btnconfirm;

    @FXML
    private TextField txtage;

    @FXML
    private TextField txtfrequencecardiaque;

    @FXML
    private TextField txtfrequencerespiration;

    @FXML
    private TextField txtmob;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtpoids;

    @FXML
    private TextField txtprenom;

    @FXML
    private TextField txtpressionarterielle;

    @FXML
    private TextField txtsaturationoxygène;

    @FXML
    private TextField txttaille;

    @FXML
    private TextField txttemperature;

    PayeeDetails pd = new PayeeDetails();
    DatabaseList dl = new DatabaseList();

    @FXML private void initialize(){
        btnconfirm.setOnAction( new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                int newWindow = onConfirmClicked();

                Parent ticket_window;
                try {
                    ticket_window = FXMLLoader.load(getClass().getResource("contactView.fxml"));
                    Scene payee_details = new Scene(ticket_window);
                    Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

                    if(newWindow == 1){
                        app_stage.hide();
                        app_stage.setScene(payee_details);
                        app_stage.show();
                    }

                } catch (IOException e1) {

                    e1.printStackTrace();
                }


            }
        });

        btnback.setOnAction( new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Parent payee_details_parent;
                try {
                    payee_details_parent = FXMLLoader.load(getClass().getResource("salle.fxml"));
                    Scene payee_details = new Scene(payee_details_parent);
                    Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

                    app_stage.hide();
                    app_stage.setScene(payee_details);
                    app_stage.show();


                } catch (IOException e1) {

                    e1.printStackTrace();
                }

            }
        });


    }//initialize method ends

    private int onConfirmClicked(){



		/*alertemail.setText("");
		alertmob.setText("");
		alertage.setText("");
		alertname.setText("");*/
        int temp =0;
        try{
            pd.setName(txtname.getText());

        }

        catch (NullPointerException e) {
            temp = 1;
            alertname.setText("You must enter your name.");
        }

        try{
            pd.setAge(Integer.parseInt(txtage.getText()));

        }

        catch (Exception e) {
            temp = 1;
            alertage.setText("You must enter your age.");
        }
        try{
            pd.setMob(txtmob.getText());

        }

        catch (NullPointerException e) {
            temp = 1;
            alertmob.setText("You must enter your mobile number.");
        }
        catch (IllegalArgumentException e) {
            temp = 1;
            alertmob.setText("Phone number must be of 10 digits.");
        }

        try{
            pd.setEmail(txtemail.getText());

        }

        catch (NullPointerException e) {
            temp = 1;
            alertemail.setText("You must enter your email.");
        }

        try{
            pd.setCard(txtcard.getText());

        }

        catch (NullPointerException e) {
            temp = 1;
            alertcard.setText("You must enter your card details");
        }

        catch (IllegalArgumentException e) {
            temp = 1;
            alertcard.setText("Card number must be of 16 digits.");
        }

        int temp2 =0;
        if(credit.isSelected()){
            pd.setPayment("Paid by Credit/Debit Card");
            temp2 =1;

        }
        if(scene.isSelected()){
            pd.setPayment("Paid by Scene Card");
            temp2 =1;

        }
        if (temp2 ==0){
            alertpayment.setText("You must enter your card details to proceed.");
            temp = 1;
        }










}
