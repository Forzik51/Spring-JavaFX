package s28216.g33c.masfinal.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import s28216.g33c.masfinal.service.DyrektorService;

import java.io.IOException;

@Component
public class AddFabrykaController {

    private final DyrektorService dyrektorService;

    private final FXMLLoader fxmlLoader;

    @FXML
    private TextField nazwaFabryki;

    @FXML
    private TextField lokalizacjaFabryki;

    @FXML
    private StackPane rootPane;
    private Parent myRoot;



    @Autowired
    public AddFabrykaController(DyrektorService dyrektorService, FXMLLoader fxmlLoader) {
        this.dyrektorService = dyrektorService;
        this.fxmlLoader = fxmlLoader;
    }

    @FXML
    public void addFabryka(ActionEvent e) throws IOException {
        //System.out.println(nazwaFabryki.getText());
        //System.out.println(lokalizacjaFabryki.getText());
        if (!nazwaFabryki.getText().isBlank() && !lokalizacjaFabryki.getText().isBlank()) {

            Rectangle shade = new Rectangle(
                    rootPane.getWidth(), rootPane.getHeight(),
                    Color.rgb(0,0,0,0.3) // czarne, 30% krycia
            );
            shade.widthProperty().bind(rootPane.widthProperty());
            shade.heightProperty().bind(rootPane.heightProperty());

            VBox dialog = new VBox(20);
            dialog.setPrefSize(400, 150);
            dialog.setMaxSize(400, 150);
            dialog.setAlignment(Pos.TOP_CENTER);
            dialog.setTranslateY(50);
            dialog.setPadding(new Insets(20));
            dialog.setStyle("-fx-background-color: white; -fx-background-radius: 8;");

            ImageView icon = new ImageView(
                    new Image(getClass().getResourceAsStream("/images/done.png"))
            );
            icon.setFitWidth(40);
            icon.setFitHeight(40);


            Label title = new Label("Potwierdź Dodanie Fabryki");
            title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0066FF;");

            HBox buttons = new HBox(10);
            buttons.setAlignment(Pos.CENTER);
            Button btnOdrzucam = new Button("Odrzucam");
            btnOdrzucam.setStyle("-fx-background-color: white; -fx-text-fill: #0066FF; -fx-padding: 8 40; -fx-border-color: #0066FF; -fx-border-radius: 7px; -fx-font-size: 14px; -fx-font-weight: bold;");
            Button btnPotwierdzam = new Button("Potwierdzam");
            btnPotwierdzam.setStyle("-fx-background-color: #0066FF; -fx-text-fill: white; -fx-padding: 8 40; -fx-background-radius: 7px; -fx-font-size: 14px; -fx-font-weight: 800;");
            buttons.getChildren().addAll(btnOdrzucam, btnPotwierdzam);

            dialog.getChildren().addAll(icon, title, buttons);

            StackPane overlay = new StackPane(shade, dialog);
            overlay.setPickOnBounds(true);

            StackPane.setAlignment(dialog, Pos.TOP_CENTER);

            rootPane.getChildren().add(overlay);

            btnOdrzucam.setOnAction(evt -> {
                rootPane.getChildren().remove(overlay);
                try {
                    changeView(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            });
            btnPotwierdzam.setOnAction(evt -> {
                rootPane.getChildren().remove(overlay);
                dyrektorService.TworzenieFabryki(nazwaFabryki.getText(), lokalizacjaFabryki.getText());
                try {
                    changeView(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }

    }

    public void changeView(ActionEvent e) throws IOException {


        if (myRoot == null) {
            fxmlLoader.setLocation(getClass().getResource("/view/FabrykList.fxml"));
            myRoot = fxmlLoader.load();

            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene = new Scene(myRoot);
            stage.setScene(scene);
            stage.show();
        }
        else {

            FabrykaController fabrykaController = fxmlLoader.getController();
            fabrykaController.refreshList();

            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene = myRoot.getScene();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void clearLabel() {
        nazwaFabryki.clear();
        lokalizacjaFabryki.clear();
    }

}
