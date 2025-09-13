package s28216.g33c.masfinal.controllers;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import s28216.g33c.masfinal.model.Kontrakt;


public class KontraktItem extends ListCell<Kontrakt> {

    private final HBox row;
    private final Label idLabel;
    private final Label opisLabel;
    private final Label statusLabel;
    private final Label wartoscLabel;
    private final Label liczbaLabel;

    public KontraktItem() {
        super();
        idLabel      = new Label();
        opisLabel    = new Label();
        statusLabel  = new Label();
        wartoscLabel = new Label();
        liczbaLabel  = new Label();

        idLabel.setPrefWidth(40);
        opisLabel.setPrefWidth(210);
        statusLabel.setPrefWidth(100);
        wartoscLabel.setPrefWidth(90);
        liczbaLabel.setPrefWidth(40);

        row = new HBox(20, idLabel, opisLabel, statusLabel, wartoscLabel, liczbaLabel);
        row.setPadding(new Insets(10));
    }

    @Override
    protected void updateItem(Kontrakt item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            idLabel.setText(String.valueOf(item.getId()));
            opisLabel.setText(item.getOpis());
            statusLabel.setText(item.getStatus().toString());
            wartoscLabel.setText(item.getWartoscKontraktu().toString());
            liczbaLabel.setText(String.valueOf(item.getLiczba()));
            setGraphic(row);
        }
    }


}
