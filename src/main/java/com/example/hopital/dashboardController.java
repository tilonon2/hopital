package com.example.hopital;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class dashboardController {
    @FXML
    private Button dashboard;

    @FXML
    private StackPane principale;

    @FXML
    private Button utilisateurs;

    // Méthode pour charger la vue dashboard
    @FXML
    private void loadDashboard() {
        loadView("dash.fxml");
    }

    // Méthode pour charger la vue utilisateurs
    @FXML
    private void loadUtilisateurs() {
        loadView("utilisateurs.fxml");
    }

    @FXML
    private void loadConsultation() {
        loadView("consultation.fxml");
    }

    @FXML
    private void loadMedicament() {
        loadView("medicament.fxml");
    }

    @FXML
    private void loadPatient() {
        loadView("patient.fxml");
    }

    @FXML
    private void loadRdv() {
        loadView("rdv.fxml");
    }

    @FXML
    private void loadSalle_attente() {
        loadView("salle_attente.fxml");
    }

    @FXML
    private void loadTraitement() {
        loadView("traitement.fxml");
    }

    @FXML
    private void loadtype_utilisateur() {
        loadView("type_utilisateur.fxml");
    }


    // Méthode générique pour charger des vues
    private void loadView(String fxmlFile) {
        try {
            // Crée un FXMLLoader pour le fichier FXML spécifié
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            // Charge le fichier FXML et obtient la racine (root) de la vue chargée
            Node view = loader.load();
            // Met à jour le contenu du StackPane principale avec la vue chargée
            principale.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace(); // Gestion des erreurs en cas de problème de chargement du fichier FXML
        }
    }



}
