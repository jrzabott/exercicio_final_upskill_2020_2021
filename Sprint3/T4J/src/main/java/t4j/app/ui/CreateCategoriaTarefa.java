package t4j.app.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UICategoriaTarefaController;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.CaraterCompetenciaTecnicaDTO;
import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.dto.RegistoAreasAtividadesDTO;
import t4j.app.dto.RegistoCompetenciasTecnicasDTO;
import t4j.app.utils.AlgoritmoGeradorPasswords;

@Controller
public class CreateCategoriaTarefa implements Initializable {

    @Autowired
    private MainSceneController mainSceneController;
    @Autowired
    private UICategoriaTarefaController uidctc;

    private RegistoCompetenciasTecnicasDTO rctdto;
    private ArrayList<CaraterCompetenciaTecnicaDTO> cctdtos;
    private ObservableList<CaraterCompetenciaTecnicaDTO> cctdtosByAreaAtividade;

    @FXML
    private TextField txtFieldCodCategoria;
    @FXML
    private TextArea txtAreaDescCategoria;
    @FXML
    private ComboBox<AreaAtividadeDTO> cmbAreaAtividadeCategoria;
    @FXML
    private TableView<CaraterCompetenciaTecnicaDTO> tableViewGrausCompTec;
    @FXML
    private TableColumn<CaraterCompetenciaTecnicaDTO, String> tbColCodigo;
    @FXML
    private TableColumn<CaraterCompetenciaTecnicaDTO, String> tbColNome;
    @FXML
    private TableColumn tbColGrau;
    @FXML
    private TableColumn tbColObrigatorio;
    @FXML
    private Label lblWarning;

    private final String TEXTO_LABEL_WARNING
            = "Ao selecionar uma CT como Obrigatória, deve selecionar um Grau de Proficiência Mínimo.";

    /////////////////////////////////////////////////////////
    // As per: https://stackoverflow.com/questions/49930449/javafx-combobox-is-calling-listcell-updateitem-infinitely
    /////////////////////////////////////////////////////////
    private static final String COMBO_BOX_ROWS_TO_MEASURE_WIDTH_KEY = "comboBoxRowsToMeasureWidth";

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // ----------------------------------------------------------------
        // Daniel Junior - 20210219 14:28
        // Este array irá armazenar todos os CaraterCompetenciaTecnicaDTO.
        // Esses CCTDTO serão gerados a partir da lista de competências
        // obtidas ao selecionar uma área de Atividade.
        // ----------------------------------------------------------------
        this.cctdtos = new ArrayList<>();
        this.rctdto = uidctc.getRegistoCompetenciasTecnicas();

        for (CompetenciaTecnicaDTO ct : rctdto.getCompetenciasTecnicas()) {
            CaraterCompetenciaTecnicaDTO cctdto = new CaraterCompetenciaTecnicaDTO();
            cctdto.setCompetenciaTecnica(ct);
            cctdtos.add(cctdto);
        }
        Platform.runLater(() -> {
            // Preencher Combobox da Area de Atividades e Listener (o que irá despoletar a atualização do itens na TableView)
            preencherComboBoxAreaAtividade();
            configurarComboBoxAreaAtividadeETableView();
        });
    }

    @FXML
    private void btnRegistarCategoria(ActionEvent event) {
        try {
            ArrayList<CaraterCompetenciaTecnicaDTO> cctdtos = new ArrayList<>(
                    tableViewGrausCompTec.getItems());

            CategoriaTarefaDTO ctdto = new CategoriaTarefaDTO();
            ctdto.setCaraterCompetenciaTecnica(cctdtos);
            ctdto.setAreaAtividade(cmbAreaAtividadeCategoria.getValue());
            ctdto.setDescricao(txtAreaDescCategoria.getText().trim());
            ctdto.setIdCategoria(txtFieldCodCategoria.getText().trim());

            boolean result = uidctc.addCategoriaTarefa(ctdto);
            if (result) {

                String mensagem = String.format(
                        "Codigo: %s%n%nDescricao: %s%n%nArea de Atividade: %s - %s",
                        uidctc.getIdGerado().toString(),
                        ctdto.getDescricao(),
                        ctdto.getAreaAtividade().getCodigo(),
                        ctdto.getAreaAtividade().getDescBreve()
                );

                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Adicionar Categoria de Tarefas",
                        "Categoria de Tarefa adicionada com sucesso.",
                        mensagem);
                a.show();
                limparCampos();
            }

        } catch (Exception e) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.ERROR,
                    "Adicionar Categoria de Tarefas",
                    "Erro ao adicionar categoria de tarefa",
                    e.getMessage());
            a.show();
        }
    }

    @FXML
    private void btnLimparRegistarCategoria(ActionEvent event) {
        limparCampos();
    }

    @FXML
    private void btnCancelarRegistarCategoria(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    private void preencherComboBoxAreaAtividade() {
        Callback<ListView<AreaAtividadeDTO>, ListCell<AreaAtividadeDTO>> cellFactory
                = new Callback<ListView<AreaAtividadeDTO>, ListCell<AreaAtividadeDTO>>() {
            @Override
            public ListCell<AreaAtividadeDTO> call(ListView<AreaAtividadeDTO> listView) {
                return new ListCell<AreaAtividadeDTO>() {
                    @Override
                    protected void updateItem(AreaAtividadeDTO item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(String.format(
                                    "%s - %s",
                                    item.getCodigo(),
                                    item.getDescBreve()));
                        }
                    }
                };
            }
        };
        cmbAreaAtividadeCategoria.setButtonCell(cellFactory.call(null));
        cmbAreaAtividadeCategoria.setCellFactory(cellFactory);

        RegistoAreasAtividadesDTO raadto = uidctc.getRegistoAreasAtividadeDTO();
        cmbAreaAtividadeCategoria.getItems().addAll(raadto.getAtividades());

    }

    @FXML
    private void btnPopAction(ActionEvent event) {

        String codigo = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.NUMEROS, 6);
        String desc = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.MIX,
                300);

        this.txtFieldCodCategoria.setText(codigo);
        this.txtAreaDescCategoria.setText(desc);
    }

    private void limparCampos() {
        this.txtFieldCodCategoria.clear();
        this.txtAreaDescCategoria.clear();
        cmbAreaAtividadeCategoria.setValue(null);
        tableViewGrausCompTec.getItems().clear();
        lblWarning.setVisible(false);
        configurarComboBoxAreaAtividadeETableView();
    }

    private void configurarComboBoxAreaAtividadeETableView() {
        // Esta combobox implement dois listeners:
        // 1.   Na própria Combobox para que as competências técnicas alterem-se consoante ao valor selecionado.
        // 2.   Para cada novo elemento da combobox, é added um novo listener, para que possa se valer
        //      da Boolean Property e seus listeners para atualizar o valor não-observável "obrigatorio"
        cmbAreaAtividadeCategoria.valueProperty().addListener(new ChangeListener<AreaAtividadeDTO>() {
            @Override
            public void changed(ObservableValue<? extends AreaAtividadeDTO> observable, AreaAtividadeDTO oldValue, AreaAtividadeDTO newValue) {
                if (newValue != null && rctdto != null && rctdto.getCompetenciasTecnicas() != null) {
                    cctdtosByAreaAtividade = FXCollections.observableArrayList();
                    for (CaraterCompetenciaTecnicaDTO cctdto : cctdtos) {
                        if (cctdto.getCompetenciaTecnica().getAreaAtividade().getCodigo().equalsIgnoreCase(newValue.getCodigo())) {
                            cctdtosByAreaAtividade.add(cctdto);
                        }
                    }
                }
                for (CaraterCompetenciaTecnicaDTO caraterCompetenciaTecnicaDTO : cctdtosByAreaAtividade) {
                    caraterCompetenciaTecnicaDTO.getObrigatorioProp().addListener(new ChangeListener<Boolean>() {
                        @Override
                        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                            caraterCompetenciaTecnicaDTO.setObrigatorio(newValue);
                            if (newValue) {
                                if (!lblWarning.isVisible()) {
                                    lblWarning.setVisible(true);
                                }
                                lblWarning.setText(TEXTO_LABEL_WARNING);
                            } else {
                                int count = 0;
                                for (CaraterCompetenciaTecnicaDTO competenciaTecnicaDTO : cctdtosByAreaAtividade) {
                                    if (competenciaTecnicaDTO.isObrigatorio()) {
                                        count++;
                                    }
                                }
                                if (count == 0) {
                                    lblWarning.setVisible(false);
                                }
                            }
                        }

                    });
                }
                preencherTableView2();
            }
        });
    }

    void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }

    void preencherTableView2() {

        /////////////////////////////////////////////
        // Customizar opções da tabela "on-the-fly"
        /////////////////////////////////////////////
        tbColCodigo.setPrefWidth(75);
        tbColNome.setPrefWidth(280);
        tbColGrau.setPrefWidth(105);
        tbColObrigatorio.setPrefWidth(100);

        /////////////////////////////////////////////
        // Coluna Cod Competencia Tecnica
        /////////////////////////////////////////////
        tbColCodigo.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<CaraterCompetenciaTecnicaDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(
                    TableColumn.CellDataFeatures<CaraterCompetenciaTecnicaDTO, String> param
            ) {
                return new SimpleStringProperty(param.getValue()
                        .getCompetenciaTecnica().getCodigoCompetenciaTecnica());
            }
        });
        tbColCodigo.setCellFactory(TextFieldTableCell.forTableColumn());

        /////////////////////////////////////////////
        // Coluna Desc Breve Competencia Tecnica
        /////////////////////////////////////////////
        tbColNome.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CaraterCompetenciaTecnicaDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(
                    TableColumn.CellDataFeatures<CaraterCompetenciaTecnicaDTO, String> param) {
                return new SimpleStringProperty(param.getValue().
                        getCompetenciaTecnica().getDescricaoBreve());
            }
        });
        tbColNome.setCellFactory(TextFieldTableCell.forTableColumn());

        /////////////////////////////////////////////
        // Coluna Grau Proficiencia
        // ------------------------------------------
        // !!! -> NÃO MEXER <- !!!
        // Daniel Junior - 20210220 02:10
        // Daniel Junior - 20210220 13:30
        //   - atualizado para versões mais simples e funcionais com observable properties
        /////////////////////////////////////////////
        tbColGrau.setCellFactory(t -> {
            ComboBoxTableCell cbtc = new ComboBoxTableCell() {

                @Override
                public void startEdit() {
                    CaraterCompetenciaTecnicaDTO currentCCDTO = (CaraterCompetenciaTecnicaDTO) getTableRow().getItem();
                    CaraterCompetenciaTecnicaDTO c = getEmptyCcdto();
                    getItems().clear();
                    getItems().add(c.getGrauProficiencia());
                    getItems().addAll(currentCCDTO.getCompetenciaTecnica().getGrausProficiencia());
                    super.startEdit();
                }

                @Override
                public void updateItem(Object item, boolean empty) {
                    CaraterCompetenciaTecnicaDTO currentCCDTO = (CaraterCompetenciaTecnicaDTO) getTableRow().getItem();
                    if (item != null && currentCCDTO != null) {
                        currentCCDTO.setGrauProficiencia((GrauProficienciaDTO) item);
                    }
                    if (currentCCDTO != null) {
                        System.out.println("getGrauProficiencia(): " + currentCCDTO.getGrauProficiencia() + "\ngetGrauProficienciaProp(): " + currentCCDTO.getGrauProficienciaProp().getValue());
                    }
                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                }
            };
            return cbtc;
        });
        tbColGrau.setCellValueFactory(new Callback<CellDataFeatures<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO>, ObservableValue<GrauProficienciaDTO>>() {
            @Override
            public ObservableValue<GrauProficienciaDTO> call(CellDataFeatures<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO> param) {
                return param.getValue().getGrauProficienciaProp();
            }

        });
        tbColGrau.setEditable(true);

        /////////////////////////////////////////////
        // Coluna Obrigatorio
        /////////////////////////////////////////////
        tbColObrigatorio.setCellValueFactory(new Callback<CellDataFeatures<CaraterCompetenciaTecnicaDTO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<CaraterCompetenciaTecnicaDTO, Boolean> param) {
                return param.getValue().getObrigatorioProp();
            }

        });
        tbColObrigatorio.setCellFactory(CheckBoxTableCell.forTableColumn(tbColObrigatorio));

        /////////////////////////////////////////////
        // Preencher TABELA
        /////////////////////////////////////////////
        tableViewGrausCompTec.setEditable(true);
        tableViewGrausCompTec.getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE);
        tableViewGrausCompTec.getItems().clear();
        tableViewGrausCompTec.getItems().addAll(cctdtosByAreaAtividade);
    }

    private CaraterCompetenciaTecnicaDTO getEmptyCcdto() {
        CaraterCompetenciaTecnicaDTO c = new CaraterCompetenciaTecnicaDTO() {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                return sb.toString();
            }

        };
        c.setCompetenciaTecnica(new CompetenciaTecnicaDTO());
        c.setGrauProficiencia(new GrauProficienciaDTO());
        c.setObrigatorio(false);
        return c;
    }
}
