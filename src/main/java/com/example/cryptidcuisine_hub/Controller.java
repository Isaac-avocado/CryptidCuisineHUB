package com.example.cryptidcuisine_hub;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent; // Importa ActionEvent de javafx.event
import javafx.util.Duration;

import java.io.IOException;

public class Controller {
    @FXML
    public TextField token;
    public Menu log_out;
    public MenuItem quit;
    @FXML
    private Button logInButton, searchDeviceText, cancelButton, continueButton, notMyAuth;

    @FXML
    private void notMyAuthClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("compromisedDevice.fxml"));
            Parent newRoot = loader.load();
            Scene newScene = new Scene(newRoot);
            Stage stage = (Stage) notMyAuth.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void quitButtonClicked(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void logInButtonClicked(ActionEvent event) {
        if (token.getText().equals("42")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("panelsMain.fxml"));
                Parent newRoot = loader.load();
                Scene newScene = new Scene(newRoot);
                Stage stage = (Stage) logInButton.getScene().getWindow();
                stage.setScene(newScene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("El token no es válido. Intenta pulsar el texto Search for Auth device :D");
            alert.showAndWait();
            System.out.println("El token no es válido.");
        }
    }
    @FXML
    private void cancelButtonClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("logIn.fxml"));
            Parent newRoot = loader.load();
            Scene newScene = new Scene(newRoot);
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void continueButtonClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("logIn.fxml"));
            Parent newRoot = loader.load();
            Scene newScene = new Scene(newRoot);
            Stage stage = (Stage) continueButton.getScene().getWindow();
            stage.setScene(newScene);

            // Obtener el controlador de la nueva escena y establecer el texto del TextField token
            Controller controller = loader.getController();
            controller.token.setText("42");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void searchDeviceTextClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("deviceText.fxml"));
            Parent newRoot = loader.load();
            Scene newScene = new Scene(newRoot);
            Stage stage = (Stage) searchDeviceText.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();

            PauseTransition delay = new PauseTransition(Duration.seconds(10)); // Retraso de 20 segundos
            delay.setOnFinished(_ -> {
                try {
                    FXMLLoader nextLoader = new FXMLLoader(getClass().getResource("foundedDevice.fxml"));
                    Parent nextRoot = nextLoader.load();
                    Scene nextScene = new Scene(nextRoot);
                    stage.setScene(nextScene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            delay.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {

    }
}
