package s28216.g33c.masfinal.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import s28216.g33c.masfinal.model.Kontrakt;
import s28216.g33c.masfinal.service.KontraktService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static s28216.g33c.masfinal.MasFinalApplication.springContext;


@Component
public class KontraktController implements Initializable {

    KontraktService kontraktService;
    FXMLLoader fxmlLoader;

    private final SharedFormData data;

    Kontrakt kontrakt;

    @FXML
    private ListView<Kontrakt> kontraktList;

    @Autowired
    public KontraktController(KontraktService kontraktService, FXMLLoader fxmlLoader, SharedFormData data) {
        this.kontraktService = kontraktService;
        this.fxmlLoader = fxmlLoader;
        this.data = data;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Kontrakt> items =
                FXCollections.observableArrayList(kontraktService.wyswietlKontrakty());
        kontraktList.setItems(items);
        kontraktList.setCellFactory(listView -> new KontraktItem());
    }


    @FXML
    public void selectKontrakt(ActionEvent e) throws IOException {
        kontrakt = kontraktList.getSelectionModel().getSelectedItem();
        if (kontrakt != null) {
            data.setIdK(kontrakt.getId());
            fxmlLoader.setLocation(getClass().getResource("/view/FabrykList.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
