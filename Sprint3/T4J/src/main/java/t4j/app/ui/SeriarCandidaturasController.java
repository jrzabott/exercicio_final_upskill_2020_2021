package t4j.app.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UICandidaturaController;
import t4j.app.dao.CandidaturaDAO;
import t4j.app.dao.ClassificacaoDAO;
import t4j.app.dao.ProcessoSeriacaoDAO;
import t4j.app.dto.AnuncioDTO;
import t4j.app.dto.CandidaturaDTO;
import t4j.app.dto.ClassificacaoDTO;
import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.LocalDateDTO;
import t4j.app.dto.Mapper;
import t4j.app.dto.ProcessoSeriacaoDTO;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.exception.ElementoNaoExistenteException;
import t4j.app.model.Candidatura;
import t4j.app.model.Classificacao;
import t4j.app.model.ProcessoSeriacao;
import t4j.app.service.CandidaturasService;

@Controller
public class SeriarCandidaturasController implements Initializable {

    @Autowired
    private MainSceneController mainSceneController;
    @Autowired
    private UICandidaturaController uicc;
    @Autowired
    CandidaturaDAO cdao;
    @Autowired
    ClassificacaoDAO cldao;
    @Autowired
    ProcessoSeriacaoDAO pdao;
    @Autowired
    CandidaturasService cs;

    private ArrayList<CandidaturaDTO> cdto = new ArrayList<>();
    private ArrayList<ColaboradorDTO> colabDTO = new ArrayList<>();
    private ArrayList<ColaboradorDTO> colabDtoByOrganizacao = new ArrayList<>();
    private ObservableList<CandidaturaDTO> cdtoByAnuncio = FXCollections.observableArrayList();
    private ObservableList<String> emailColaboradores = FXCollections.observableArrayList();
    private String nifOrganizacaoByEmailColaborador;

    @FXML
    private Button btnPop;
    @FXML
    private ComboBox<String> cmbBoxAnuncio;
    @FXML
    private ListView<String> listViewCandidaturasSeriadas;
    @FXML
    private TableView<CandidaturaDTO> tableViewClassificacao;
    @FXML
    private TableColumn<CandidaturaDTO, Long> tableColumnCandidatura;
    @FXML
    private TableColumn<CandidaturaDTO, String> tableColumnClassificacao;
    @FXML
    private TableColumn<CandidaturaDTO, String> tableColumnColaborador;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cdto.clear();
        colabDTO.clear();
        colabDtoByOrganizacao.clear();
        cdtoByAnuncio.clear();
        emailColaboradores.clear();

        cdto = uicc.getListaCandidaturas();
        colabDTO = uicc.getListaColaboradores();
//        nifOrganizacaoByEmailColaborador = mainSceneController.getUidto().getNifOrganizacao();
        nifOrganizacaoByEmailColaborador = "878545419";
        for (int i = 0;
                i < colabDTO.size();
                i++) {
            if (colabDTO.get(i).getNifOrganizacao().equalsIgnoreCase(nifOrganizacaoByEmailColaborador)) {
                colabDtoByOrganizacao.add(colabDTO.get(i));
            }
        }
        for (int i = 0;
                i < colabDtoByOrganizacao.size();
                i++) {
            emailColaboradores.add(colabDtoByOrganizacao.get(i).getEmail());
        }

        preencherComboBoxAnuncios();

        configurarComboBoxAnuncios();

        prepTable();
//        configurarTableColumnClassificacao();
//        configurarTableColumnColaborador();
    }

    @FXML
    private void btnCancelarSeriarCandidaturas(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnLimparSeriarCandidaturas() {
        limparCampos();
    }

    @FXML
    private void btnSeriarCandidaturas(ActionEvent event) {
        try {
            boolean result = false;
            ClassificacaoDTO classdto = new ClassificacaoDTO();
            LocalDateDTO dpsdto = new LocalDateDTO();
            dpsdto.setLocalDate(LocalDate.now());

            String referenciaAnuncio = cmbBoxAnuncio.getValue();
            Long idTipoRegimentoByReferenciaAnuncio = uicc.idTipoRegimentoByCandidatura(referenciaAnuncio);

            ProcessoSeriacaoDTO psdto = new ProcessoSeriacaoDTO();
            psdto.setDataRealizacao(dpsdto);
            psdto.setReferenciaAnuncio(referenciaAnuncio);

            switch (idTipoRegimentoByReferenciaAnuncio.intValue()) {
                case 1:
                    //                    result = uicc.seriarCandidaturaNaoAutomaticamente(psdto, idCandidaturaVencedora);
                    break;
                case 2:
                    //                    result = uicc.seriarCandidaturaNaoAutomaticamente(psdto, idCandidaturaVencedora);
                    break;
                case 3:
                    //                    result = uicc.seriarCandidatura(psdto, idCandidaturaVencedora);
                    break;
                default:
            }

            cs.seriarCandidaturas(cdtoByAnuncio, psdto);
//            lixo(psdto, classdto);

            if (result) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Seriar Candidatura",
                        "Seriar Candidatura",
                        "Candidatura seriada com sucesso"
                );
                a.show();

                ((Node) event.getSource()).getScene().getWindow().hide();
                limparCampos();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.ERROR,
                    "Seriar Candidatura",
                    "Erro ao seriar candidatura",
                    e.getMessage());
            a.show();
        }
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
        Long classif = 15L;
//        String emailColaborador = "nbgept@qdbgoqekwr.com";
//        String emailFreelancer = "TtAXNK@hjbvCx.pt";
//        uicc.updateTabelaCandidatura(emailFreelancer, classif, emailColaborador);
    }

    private void limparCampos() {
        cmbBoxAnuncio.getSelectionModel().clearSelection();
        listViewCandidaturasSeriadas.getItems().clear();
        tableViewClassificacao.getItems().clear();
        cdtoByAnuncio.clear();
    }

    private void candidaturasEmPeriodoSeriacao() {
        List<Long> candidaturasEmPeriodoSeriacao = uicc.candidaturasEmPeriodoSeriacao(cmbBoxAnuncio.getValue());

    }

    private void preencherComboBoxAnuncios() {
//        ArrayList<AnuncioDTO> listaAnuncios = uicc.anunciosEmPeriodoSeriacao(mainSceneController.getUidto().getEmail());
        ArrayList<AnuncioDTO> listaAnuncios = uicc.anunciosEmPeriodoSeriacao("nbgept@qdbgoqekwr.com");
        ArrayList<String> listaReferencias = new ArrayList<>();
        for (int i = 0; i < listaAnuncios.size(); i++) {
            String referencia = listaAnuncios.get(i).getReferenciaTarefa();
            listaReferencias.add(referencia);
        }
        cmbBoxAnuncio.getItems().setAll(listaReferencias);
    }

    private void configurarComboBoxAnuncios() {
        cmbBoxAnuncio.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                cdtoByAnuncio.clear();
                for (CandidaturaDTO candidaturaDTO : cdto) {
                    if (candidaturaDTO.getRefAnuncio().equalsIgnoreCase(newValue)) {
                        cdtoByAnuncio.add(candidaturaDTO);
                    }
                }
            }
        });
    }

    private void configurarTableColumnClassificacao() {
//        tableColumnClassificacao.setEditable(true);
//        tableColumnClassificacao.setCellFactory(TextFieldTableCell.<CandidaturaDTO>forTableColumn());
//        tableColumnClassificacao.setOnEditCommit(
//                (TableColumn.CellEditEvent<CandidaturaDTO, String> i)
//                -> (i.getTableView().getItems().get(
//                        i.getTablePosition().getRow()))
//                        .setClassificacao(Integer.parseInt(i.getNewValue())));
    }

    private void configurarTableColumnColaborador() {
//        tableColumnColaborador.setEditable(true);
//        Callback<TableColumn<CandidaturaDTO, String>, TableCell<CandidaturaDTO, String>> cbec
//                = ComboBoxTableCell.forTableColumn((ObservableList<String>) emailColaboradores);
//        tableColumnColaborador.setCellFactory(cbec);
    }

    private void prepTable() {
        tableViewClassificacao.setItems(cdtoByAnuncio);
        tableViewClassificacao.setEditable(true);

        tableColumnCandidatura.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnClassificacao.setCellValueFactory(new PropertyValueFactory<>("classificacao_seriacao"));
        tableColumnColaborador.setCellValueFactory(new PropertyValueFactory<>("email_colaborador_classificou"));

        tableColumnColaborador.setEditable(true);
        tableColumnColaborador.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnColaborador.setOnEditCommit(
                new EventHandler<CellEditEvent<CandidaturaDTO, String>>() {
            @Override
            public void handle(CellEditEvent<CandidaturaDTO, String> t) {
                ((CandidaturaDTO) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setEmailColaboradorClassificou(t.getNewValue());
            }
        });

        tableColumnColaborador.setCellFactory(t -> {
            ComboBoxTableCell cbtc = new ComboBoxTableCell() {

                @Override
                public void startEdit() {
                    CandidaturaDTO currentCCDTO = (CandidaturaDTO) getTableRow().getItem();
                    getItems().clear();
                    List<String> temp = new ArrayList();
                    getItems().addAll(emailColaboradores);
                    super.startEdit();
                }

                @Override
                public void updateItem(Object item, boolean empty) {
                    CandidaturaDTO currentCCDTO = (CandidaturaDTO) getTableRow().getItem();
                    if (item != null && currentCCDTO != null) {
                        currentCCDTO.setEmailColaboradorClassificou(((CandidaturaDTO) item).getEmailColaboradorClassificou());
                    }
                    if (currentCCDTO != null) {
                        System.out.println("getGrauProficiencia(): " + currentCCDTO.getEmailColaboradorClassificou() + "\ngetGrauProficienciaProp(): " + currentCCDTO.getEmailColaboradorClassificou());
                    }
                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                }
            };
            return cbtc;
        });

        tableColumnClassificacao.setEditable(true);
        tableColumnClassificacao.setCellFactory(TextFieldTableCell.<CandidaturaDTO>forTableColumn());
        tableColumnClassificacao.setOnEditCommit(
                new EventHandler<CellEditEvent<CandidaturaDTO, String>>() {
            @Override
            public void handle(CellEditEvent<CandidaturaDTO, String> t) {
                ((CandidaturaDTO) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setClassificacao(t.getNewValue());
            }
        });
    }

    private void lixo(ProcessoSeriacaoDTO psdto, ClassificacaoDTO classdto) throws ElementoNaoExistenteException, NumberFormatException, ElementoInvalidoException {
        ///////////////////////////////////////////////////////////////////////////////
        // VALIDAÇÕES DAS CANDIDATURAS E SUAS CLASSIFICAÇOES
        ///////////////////////////////////////////////////////////////////////////////
        // Testar se tabela tem registos (se há candidaturas para esta tarefa)
        if (cdtoByAnuncio.size() < 1) {
            throw new ElementoNaoExistenteException("Não existem candidaturas para a tarefa.");
        }
        // Testar se Classificaca está preenchida (!= null ou "")
        boolean classificaoEmBranco = false;
        for (CandidaturaDTO item : cdtoByAnuncio) {
            if (item.getClassificacao() == null
                    || item.getClassificacao().isEmpty()) {
                classificaoEmBranco = true;
                break;
            }
        }
        if (classificaoEmBranco) {
            throw new ElementoInvalidoException("Todas as candidaturas devem ser classificadas, com valores entre 1 e 20");
        }
        for (CandidaturaDTO item : cdtoByAnuncio) {
            if (Integer.parseInt(item.getClassificacao()) < 1) {
                throw new ElementoInvalidoException("Candidatura: " + item.getId().toString() + ". Deve receber valor maior que 1 em sua classificação.");
            }
            if (Integer.parseInt(item.getClassificacao()) > 20) {
                throw new ElementoInvalidoException("Candidatura: " + item.getId().toString() + ". Deve receber valor menor ou igual a 20 em sua classificação.");
            }
        }
        // FIM VALIDAÇÕES DAS CANDIDATURAS E SUAS CLASSIFICAÇOES
        ///////////////////////////////////////////////////////////////////////////////

        Iterable<Candidatura> listToSave = new ArrayList();
        for (CandidaturaDTO item : cdtoByAnuncio) {
            Candidatura cdto3 = Mapper.candidaturaDTO2Candidatura(item);
            if (cdto3 != null) {
                ((ArrayList<Candidatura>) listToSave).add(cdto3);
            }
        }
        cdao.saveAll(listToSave);

        // TODO - Criar novo registo na tabela PROCESSOSERIACAO
        ProcessoSeriacao ps = Mapper.processoSeriacaoDTO2ProcessoSeriacao(psdto);
        Optional<ProcessoSeriacao> psOptional = pdao.findByReferenciaAnuncio(ps.getReferenciaAnuncio());
        if (psOptional.isPresent()) {
            throw new ElementoInvalidoException(("Tarefa já seriada."));
        }
        ps = pdao.save(ps);

        // Tabela Classificacao
        CandidaturaDTO cdto2 = new CandidaturaDTO();
        int melhorClassificacao = 0;
        for (CandidaturaDTO item : cdtoByAnuncio) {
            int classAtual = Integer.parseInt(item.getClassificacao());
            if (classAtual > melhorClassificacao) {
                melhorClassificacao = classAtual;
                cdto2 = item;
            }
        }
        // Testar classificação != null e Colaborador != null
        Candidatura ct = Mapper.candidaturaDTO2Candidatura(cdto2);

        classdto.setIdCandidaturaVencedora(ct.getId());
        classdto.setIdProcessoSeriacao(ps.getId());
        Classificacao cl = Mapper.classificacaoDTO2Classificacao(classdto);
        cl = cldao.save(cl);

// TODO - ALTERAR QUERY PARA EXIBIR TAREFAS QUE NÃO FORAM SERIADAS (JOIN PROCESSOSERIACAO).
    }

    void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }

}
