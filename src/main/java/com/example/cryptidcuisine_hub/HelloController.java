package com.example.cryptidcuisine_hub;// HelloController.java
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private Button helloButton;

    @FXML
    private void initialize() {
        helloButton.setOnAction(event -> System.out.println("Hello!"));
    }
}
