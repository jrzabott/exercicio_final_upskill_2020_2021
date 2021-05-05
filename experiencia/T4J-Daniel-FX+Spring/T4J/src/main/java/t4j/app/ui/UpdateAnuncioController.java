package t4j.app.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UpdateAnuncioController implements Initializable {

    @Autowired
    private MainSceneController mainSceneController;
    
    @FXML
    private ComboBox<?> cmbAnuncio;
    @FXML
    private ComboBox<?> cmbTipoRegimento;
    @FXML
    private DatePicker dataFimCandidatura;
    @FXML
    private DatePicker dataFimPublicitacao;
    @FXML
    private DatePicker dataFimSeriacao;
    @FXML
    private DatePicker dataInicioCandidatura;
    @FXML
    private DatePicker dataInicioPublicitacao;
    @FXML
    private DatePicker dataInicioSeriacao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void btnAtualizarAnuncio(ActionEvent event) {
    }

    @FXML
    private void btnCancelarAtualizarAnuncio(ActionEvent event) {
    }

    @FXML
    private void btnLimparAtualizarAnuncio(ActionEvent event) {
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
    }
    
    void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }
}
