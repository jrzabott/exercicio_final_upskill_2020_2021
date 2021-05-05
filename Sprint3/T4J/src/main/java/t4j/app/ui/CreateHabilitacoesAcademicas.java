/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UIHabilitacaoAcademicaController;
import t4j.app.dto.HabilitacaoAcademicaDTO;
import t4j.app.utils.AlgoritmoGeradorPasswords;

/**
 * FXML Controller class
 *
 * @author Home
 */
@Controller
public class CreateHabilitacoesAcademicas implements Initializable {


     @Autowired
    private MainSceneController mainSceneController;
    @Autowired
    private UIHabilitacaoAcademicaController uihac;
    @Autowired
    private CreateFreelancer createFreelancer;


    @FXML
    private Button btnPop;
    @FXML
    private TextField txtFieldGrauFreelancer;
    @FXML
    private TextField txtFieldNomeCursoFreelancer;
    @FXML
    private TextField txtFieldNomeInstituicaoFreelancer;
    @FXML
    private TextField txtFieldMediaCursoFreelancer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnRegistarHabilitacaoAcademica(ActionEvent event) {

        String mediaCursoHabilitacaoAcademica, nomeInstituicaoHabilitacaoAcademica,designacaoCursoHabilitacaoAcademica
                ,grauHabilitacaoAcademica;

        mediaCursoHabilitacaoAcademica = txtFieldMediaCursoFreelancer.getText();
        nomeInstituicaoHabilitacaoAcademica = txtFieldNomeInstituicaoFreelancer.getText();
        designacaoCursoHabilitacaoAcademica = txtFieldNomeCursoFreelancer.getText();
        grauHabilitacaoAcademica = txtFieldGrauFreelancer.getText();




        HabilitacaoAcademicaDTO  hadto = new HabilitacaoAcademicaDTO();
        hadto.setDesignacaocurso(designacaoCursoHabilitacaoAcademica);
        hadto.setGrau(grauHabilitacaoAcademica);
        hadto.setMediacurso(mediaCursoHabilitacaoAcademica);
        hadto.setNomeinstituicao(nomeInstituicaoHabilitacaoAcademica);

        createFreelancer.getHabilitacoes().add(hadto);
                 limparCampos();
         ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnLimparHabilitacaoAcademica(ActionEvent event) {
                limparCampos();
    }

    private void limparCampos() {
        this.txtFieldGrauFreelancer.clear();
        this.txtFieldMediaCursoFreelancer.clear();
        this.txtFieldNomeCursoFreelancer.clear();
        this.txtFieldNomeInstituicaoFreelancer.clear();

    }

    @FXML
    private void btnCancelarHabilitacaoAcademica(ActionEvent event) {
         limparCampos();
         ((Node) event.getSource()).getScene().getWindow().hide();
    }
    void associarParentUI(MainSceneController mainSceneController) {
//        this.mainSceneController = mainSceneController;
//        this.appController = mainSceneController.getAppController();
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
                  String mediaCursoHabilitacaoAcademica, nomeInstituicaoHabilitacaoAcademica,designacaoCursoHabilitacaoAcademica
                ,grauHabilitacaoAcademica;
        mediaCursoHabilitacaoAcademica = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.NUMEROS, 2);
        nomeInstituicaoHabilitacaoAcademica = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 6);
        designacaoCursoHabilitacaoAcademica = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 10);
        grauHabilitacaoAcademica= String.format(
                AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 6)
               );

        txtFieldGrauFreelancer.setText(grauHabilitacaoAcademica);
        txtFieldMediaCursoFreelancer.setText(mediaCursoHabilitacaoAcademica);
        txtFieldNomeCursoFreelancer.setText(designacaoCursoHabilitacaoAcademica);
        txtFieldNomeInstituicaoFreelancer.setText(nomeInstituicaoHabilitacaoAcademica);



    }

}
