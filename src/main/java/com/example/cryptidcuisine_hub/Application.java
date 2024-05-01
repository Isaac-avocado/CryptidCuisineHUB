package com.example.cryptidcuisine_hub;

import com.jfoenix.controls.JFXDecorator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("logIn.fxml"));
        Parent root = loader.load();

        // Configura la raíz del FXMLLoader
        loader.setRoot(root);

        // FXDecorator con la escena
        JFXDecorator decorator = new JFXDecorator(primaryStage, root);
        decorator.setCustomMaximize(true); // Permitir maximizar/restaurar la ventana
        decorator.setStyle("-fx-background-color: black;"); // Establecer color de fondo de la barra de título

        // Obtener las dimensiones de pantalla del dispositivo
        double screenWidth = 1030.0;//javafx.stage.Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = 596.0;//javafx.stage.Screen.getPrimary().getVisualBounds().getHeight();

        // Escena con el decorador
        Scene decoratorScene = new Scene(decorator, screenWidth, screenHeight);
        decoratorScene.setFill(javafx.scene.paint.Color.rgb(0, 0, 0, 0.2)); // Configurar la transparencia de la escena
        // Configurar la escena
        primaryStage.setTitle("CriptidCuisine HUB");
        primaryStage.setScene(decoratorScene);
        //primaryStage.setFullScreen(true);
        //primaryStage.setOpacity(0.8);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
