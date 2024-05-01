package com.example.hopital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TypeUtilisateurController implements Initializable {
    private DatabaseManager dbManager;
    @FXML
    private TextField libelle_typeuser;

    @FXML
    private RadioButton utilisateurvue,typeutilisateurvue,consultationvue,medicamentvue,rdvvue,dashboardvue,salleattentevue,traitementvue,patientvue,specialistevue;

    @FXML
    private Button valider_type_user;


    @FXML
    private TableView table_type_user;

    PreparedStatement pst;

    public TypeUtilisateurController() {
        dbManager = DatabaseManager.getInstance(); // Utiliser l'instance Singleton
    }


    @FXML
    void ajouter_type_utilisateur(ActionEvent event) {
        Connection conn = dbManager.getConnection();
        String libelle = libelle_typeuser.getText();

        // Vérifier si le libellé est vide
        if (libelle == null || libelle.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation Error");
            alert.setHeaderText("Validation de la saisie");
            alert.setContentText("Le libellé ne peut pas être vide.");
            alert.showAndWait();
            return; // Stop further execution
        }

        boolean user = utilisateurvue.isSelected();
        boolean type_user = typeutilisateurvue.isSelected();
        boolean consult = consultationvue.isSelected();
        boolean medic = medicamentvue.isSelected();
        boolean rdv = rdvvue.isSelected();
        boolean dashboard = dashboardvue.isSelected();
        boolean attente = salleattentevue.isSelected();
        boolean trait = traitementvue.isSelected();
        boolean patient = patientvue.isSelected();
        boolean specialiste = specialistevue.isSelected();

        try {
            pst = conn.prepareStatement("insert into type_user(libelle, acces_utilisateur, acces_type_utilisateur, acces_consultation, acces_medicament, acces_rdv, acces_dashboard, acces_salle_attente, acces_traitement, acces_patient, acces_specialiste) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, libelle);
            pst.setBoolean(2, user);
            pst.setBoolean(3, type_user);
            pst.setBoolean(4, consult);
            pst.setBoolean(5, medic);
            pst.setBoolean(6, rdv);
            pst.setBoolean(7, dashboard);
            pst.setBoolean(8, attente);
            pst.setBoolean(9, trait);
            pst.setBoolean(10, patient);
            pst.setBoolean(11, specialiste);
            pst.executeUpdate();

            // Afficher une alerte d'information sur l'enregistrement réussi
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Type Utilisateur");
            alert.setHeaderText("Enregistrement du Type Utilisateur");
            alert.setContentText("Type Utilisateur enregistré avec succès");
            alert.showAndWait();

            // Réinitialiser le formulaire
            libelle_typeuser.setText("");
            libelle_typeuser.requestFocus();
            utilisateurvue.setSelected(false);
            typeutilisateurvue.setSelected(false);
            consultationvue.setSelected(false);
            medicamentvue.setSelected(false);
            rdvvue.setSelected(false);
            dashboardvue.setSelected(false);
            salleattentevue.setSelected(false);
            traitementvue.setSelected(false);
            patientvue.setSelected(false);
            specialistevue.setSelected(false);
        } catch (SQLException ex) {
            Logger.getLogger(TypeUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void chargerDonnees() {

        try {
            Connection conn = dbManager.getConnection();
            pst = conn.prepareStatement("SELECT * FROM type_user");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String libelle = rs.getString("libelle");
                boolean accesUtilisateur = rs.getBoolean("acces_utilisateur");
                boolean accesTypeUtilisateur = rs.getBoolean("acces_type_utilisateur");
                boolean accesConsultation = rs.getBoolean("acces_consultation");
                boolean accesMedicament = rs.getBoolean("acces_medicament");
                boolean accesRdv = rs.getBoolean("acces_rdv");
                boolean accesDashboard = rs.getBoolean("acces_dashboard");
                boolean accesSalleAttente = rs.getBoolean("acces_salle_attente");
                boolean accesTraitement = rs.getBoolean("acces_traitement");
                boolean accesPatient = rs.getBoolean("acces_patient");
                boolean accesSpecialiste = rs.getBoolean("acces_specialiste");

                // Créer un objet Eleve avec les informations récupérées de la base de données
                TypeUtilisateur type_utilisateur = new TypeUtilisateur(id, libelle, accesUtilisateur, accesTypeUtilisateur,accesConsultation,accesMedicament,accesRdv,accesDashboard,accesSalleAttente,accesTraitement,accesPatient,accesSpecialiste);

                // Ajouter l'objet Eleve au TableView
                table_type_user.getItems().add(type_utilisateur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }









    @Override
    public void initialize(URL url, ResourceBundle rb){
        Connection conn = dbManager.getConnection();
        // Logique d'initialisation suivant la connexion
    }
}
