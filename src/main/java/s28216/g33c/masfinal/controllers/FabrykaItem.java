package s28216.g33c.masfinal.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import s28216.g33c.masfinal.model.Fabryka;
import s28216.g33c.masfinal.model.Kontrakt;

public class FabrykaItem extends ListCell<Fabryka> {

    private final HBox row;
    private final Label idLabel;
    private final Label nazwaLabel;
    private final Label lokalizacjaLabel;

    public FabrykaItem() {
        super();
        idLabel      = new Label();
        nazwaLabel    = new Label();
        lokalizacjaLabel  = new Label();

        idLabel.setPrefWidth(90);
        nazwaLabel.setPrefWidth(165);
        lokalizacjaLabel.setPrefWidth(165);

        idLabel.setAlignment(Pos.CENTER);
        nazwaLabel.setAlignment(Pos.CENTER);
        lokalizacjaLabel.setAlignment(Pos.CENTER);

        row = new HBox(50, idLabel, nazwaLabel, lokalizacjaLabel);
        row.setPadding(new Insets(10));
    }

    @Override
    protected void updateItem(Fabryka item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            idLabel.setText(String.valueOf(item.getId()));
            nazwaLabel.setText(item.getNazwa());
            lokalizacjaLabel.setText(item.getLokalizacja());
            setGraphic(row);
        }
    }
}
