package s28216.g33c.masfinal.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
import s28216.g33c.masfinal.model.Fabryka;
import s28216.g33c.masfinal.model.Kontrakt;
import s28216.g33c.masfinal.model.Pojazd;
import s28216.g33c.masfinal.service.DyrektorService;
import s28216.g33c.masfinal.service.FabrykaService;
import s28216.g33c.masfinal.service.PojazdService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class PojazdController implements Initializable {
    PojazdService pojazdService;

    private final DyrektorService dyrektorService;

    private final SharedFormData data;

    @FXML
    private ListView<Pojazd> pojazdList;

    @FXML
    private StackPane rootPane;

    @Autowired
    public PojazdController(PojazdService pojazdService, DyrektorService dyrektorService, SharedFormData data) {
        this.pojazdService = pojazdService;
        this.dyrektorService = dyrektorService;
        this.data = data;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Pojazd> items =
                FXCollections.observableArrayList(pojazdService.wyswietlPojazdy());
        pojazdList.setItems(items);
        pojazdList.setCellFactory(listView -> new PojazdItem());
    }

    public void selectPojazd(ActionEvent e) throws IOException {

        //System.out.println(data.getIdK()+ " " + data.getIdF());
        Pojazd pojazd = pojazdList.getSelectionModel().getSelectedItem();
        if (pojazd != null) {
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


            Label title = new Label("Podtwierdz Przypisanie Kontraktu");
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

                Platform.exit();
                System.exit(0);

            });
            btnPotwierdzam.setOnAction(evt -> {

                dyrektorService.przekazDoProdukcji(data.getIdK(), data.getIdF(), pojazd.getId());

                Platform.exit();
                System.exit(0);
            });
        }
    }


}
