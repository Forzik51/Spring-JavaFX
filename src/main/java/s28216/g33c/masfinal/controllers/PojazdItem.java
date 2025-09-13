package s28216.g33c.masfinal.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import s28216.g33c.masfinal.model.Fabryka;
import s28216.g33c.masfinal.model.Pojazd;

public class PojazdItem extends ListCell<Pojazd> {
    private final HBox row;
    private final Label idLabel;
    private final Label OpisLabel;
    private final Label ModelLabel;

    public PojazdItem() {
        super();
        idLabel      = new Label();
        OpisLabel    = new Label();
        ModelLabel  = new Label();

        idLabel.setPrefWidth(90);
        OpisLabel.setPrefWidth(165);
        ModelLabel.setPrefWidth(165);

        idLabel.setAlignment(Pos.CENTER);
        OpisLabel.setAlignment(Pos.CENTER);
        ModelLabel.setAlignment(Pos.CENTER);

        row = new HBox(50, idLabel, OpisLabel, ModelLabel);
        row.setPadding(new Insets(10));
    }

    @Override
    protected void updateItem(Pojazd item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            idLabel.setText(String.valueOf(item.getId()));
            OpisLabel.setText(item.getOpisStatusu());
            ModelLabel.setText(item.getModel());
            setGraphic(row);
        }
    }
}
