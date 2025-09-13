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
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import s28216.g33c.masfinal.MasFinalApplication;
import s28216.g33c.masfinal.model.Fabryka;
import s28216.g33c.masfinal.model.Kontrakt;
import s28216.g33c.masfinal.service.FabrykaService;
import s28216.g33c.masfinal.service.KontraktService;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class FabrykaController implements Initializable {

    FabrykaService fabrykaService;

    @FXML
    private ListView<Fabryka> fabrykaList;

    private final FXMLLoader fxmlLoader;
    private Parent myRoot;

    private final SharedFormData data;

    private ObservableList<Fabryka> items;

    @Autowired
    public FabrykaController(FabrykaService fabrykaService , FXMLLoader fxmlLoader, SharedFormData data) {
        this.fabrykaService = fabrykaService;
        this.fxmlLoader = fxmlLoader;
        this.data = data;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        items = FXCollections.observableArrayList();
        fabrykaList.setItems(items);
        fabrykaList.setCellFactory(listView -> new FabrykaItem());

        refreshList();
    }

    public void refreshList() {
        List<Fabryka> all = fabrykaService.wyswietlFabryki();
        items.setAll(all);
    }

    public void addNewFabryka(ActionEvent e) throws IOException {
        if (myRoot == null) {
            fxmlLoader.setLocation(getClass().getResource("/view/AddFabryka.fxml"));
            myRoot = fxmlLoader.load();

            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene = new Scene(myRoot);
            stage.setScene(scene);
            stage.show();
        }
        else {

            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene = myRoot.getScene();
            stage.setScene(scene);
            stage.show();

            AddFabrykaController afc = fxmlLoader.getController();
            afc.clearLabel();
        }

    }

    public void selectFabryka(ActionEvent e) throws IOException {
        Fabryka fabryka = fabrykaList.getSelectionModel().getSelectedItem();
        if (fabryka != null) {
            data.setIdF(fabryka.getId());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PojazdyList.fxml"));
            loader.setControllerFactory(MasFinalApplication.springContext::getBean);

            Parent root = loader.load();

            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}
