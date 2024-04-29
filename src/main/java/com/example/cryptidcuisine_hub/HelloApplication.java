package com.example.cryptidcuisine_hub;

import com.jfoenix.controls.JFXDecorator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear un efecto de desenfoque
        BoxBlur blur = new BoxBlur(5, 5, 3);

        // Configurar la escena
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 320, 240);

        // Aplicar el efecto de desenfoque al nodo contenedor
        root.setEffect(blur);
        root.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");//128, 0, 32, 0.5

        // Crear un JFXDecorator con la escena
        JFXDecorator decorator = new JFXDecorator(primaryStage, root);
        decorator.setCustomMaximize(true); // Permitir maximizar/restaurar la ventana
        decorator.setStyle("-fx-background-color: black;"); // Establecer color de fondo de la barra de título

        // Configurar la escena con el JFXDecorator
        Scene decoratorScene = new Scene(decorator);

        // Configurar la ventana principal
        primaryStage.setTitle("CriptidCuisine HUB");
        primaryStage.setScene(decoratorScene);

        // Establecer la transparencia de la ventana
        primaryStage.setOpacity(0.8);

        // Mostrar la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
