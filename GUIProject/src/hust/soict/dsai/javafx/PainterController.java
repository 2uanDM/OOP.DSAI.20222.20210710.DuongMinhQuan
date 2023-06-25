package hust.soict.dsai.javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.paint.Color;

public class PainterController implements Initializable {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup tools;

    @FXML
    private ToggleButton pen;

    @FXML
    private ToggleButton eraser;

    @FXML
    public void handleOptions(MouseEvent event) {
        ToggleButton selected = (ToggleButton) tools.getSelectedToggle();
        if (selected == pen) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        } else {
            if (selected == eraser) {
                Circle newCircle = new Circle(event.getX(), event.getY(), 8, Color.WHITE);
                newCircle.setStrokeType(StrokeType.OUTSIDE);
                newCircle.setStrokeWidth(0);
                newCircle.setStroke(Color.BLACK);
                drawingAreaPane.getChildren().add(newCircle);
            }
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pen.setSelected(true);
    }
}
