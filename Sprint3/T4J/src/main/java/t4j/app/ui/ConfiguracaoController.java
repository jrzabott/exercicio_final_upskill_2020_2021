package t4j.app.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.utils.CoresTema;
import t4j.app.utils.TamanhoFonte;

@Controller
public class ConfiguracaoController implements Initializable {

    @Autowired
    private MainSceneController mainSceneController;

    @FXML
    private ChoiceBox<CoresTema> cbTemasCores;

    @FXML
    private Slider sliderTamanhoFonte;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpTema();
        setUpFonte();
    }

    @FXML
    private void btnAplicarAction(ActionEvent event) {
        mainSceneController.setCoresTema(cbTemasCores.getValue());
        mainSceneController.setTamanhoFonte(TamanhoFonte.values()[(int)(sliderTamanhoFonte.getValue())]);
        mainSceneController.updateAllStyles();
    }

    @FXML
    private void btnCancelarAction(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    private void setUpFonte() {
        sliderTamanhoFonte.setMin(0);
        sliderTamanhoFonte.setMax(TamanhoFonte.values().length - 1);
        sliderTamanhoFonte.setValue(TamanhoFonte.MEDIO.ordinal());
//        sliderTamanhoFonte.setValue(mainSceneController.getTamanhoFonte().ordinal());
        sliderTamanhoFonte.setMajorTickUnit(1);
        sliderTamanhoFonte.setMinorTickCount(0);
        sliderTamanhoFonte.setBlockIncrement(1);
        sliderTamanhoFonte.setSnapToTicks(true);
        sliderTamanhoFonte.setShowTickMarks(true);
        sliderTamanhoFonte.setShowTickLabels(true);
        sliderTamanhoFonte.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public Double fromString(String string) {
                return null;
            }

            @Override
            public String toString(Double object) {
                int i = object.intValue();
                return TamanhoFonte.values()[i].toString();
            }
        });
        sliderTamanhoFonte.valueProperty().addListener((obs, oldVal, newVal) -> {
            sliderTamanhoFonte.setValue(newVal.intValue());
        });
    }

    private void setUpTema() {
        cbTemasCores.setItems(FXCollections.observableArrayList(CoresTema.values()));
        cbTemasCores.setValue(CoresTema.DEFAULT);
//        cbTemasCores.setValue(mainSceneController.getCoresTema());
    }

    public void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }
}
