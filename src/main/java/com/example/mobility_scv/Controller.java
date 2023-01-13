package com.example.mobility_scv;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML private ImageView exit,menu;
    @FXML private AnchorPane pane1,pane2,usr;
    @FXML private BorderPane mainpane;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        pane1.setVisible(false);

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),pane2);
        translateTransition.setByX(-280);
        translateTransition.play();

        menu.setOnMouseClicked(event -> {
            pane1.setVisible(true);

            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),pane1);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),pane2);
            translateTransition1.setByX(+280);
            translateTransition1.play();
        });

        pane1.setOnMouseClicked(event -> {
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),pane1);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                pane1.setVisible(false);
            });

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),pane2);
            translateTransition1.setByX(-280);
            translateTransition1.play();
        });
    }

    @FXML
    private void click_usr(MouseEvent event){
        mainpane.setCenter(usr);
    }
    @FXML
    private void click_data(MouseEvent event){loadPage("Data");}
    @FXML
    private void click_export(MouseEvent event){loadPage("Export");}
    @FXML
    private void click_return(MouseEvent event){loadPage("Return");}
    @FXML
    private void click_setup(MouseEvent event){loadPage("Setup");}



    private void loadPage(String page) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
            mainpane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}