package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.lang.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

//////////////////////////////////////////////
// !!!!!!! NÃO CORRIGIR ESTE ""ERRO"" !!!!!!
// ---- > LER O COMMENT ABAIXO < -----------
@Entity
@Table(name = "caratercompetenciatecnica")
public class CaraterCompetenciaTecnica implements Serializable {

    private Long id;

    /**
     * Variável de instância - caráter obrigatório da competência técnica
     */
////////////////////////////////////////////////////////////////////////////////////
// Daniel Junior - 20211902 - 12:19
// ------------------------------------------
// ATENÇÃO AO FACTO DE QUE A COLUNA "OBRIGATORIO" (@Column name = "obrigatoria")
// ESTÁ ASSOCIADA AO MÉTODO getObrigatorioAsString();  PARA QUE SEJA POSSÍVEL
// REALIZAR A CONVERSÃO DO VALOR BOOLEAN PARA STRING - COMO FOI CONVENCIONADO UMA
// VEZ QUE A DB ORACLE NÃO ACEITA VALORES BOOLEAN.
//
// P.S.:    O warning acima é esperado: Sobre a forma de acesso: field OR property.
//          Devemos ignorar, pois a property below converts the value.
// ------------------------------------------
// Daniel Junior - 20210221 - 10:38
// Removida associação.
////////////////////////////////////////////////////////////////////////////////////
    private boolean obrigatorio;

    private String obrigatorioAsString;
////////////////////////////////////////////////////////////////////////////////////

    /**
     * Variável de instância - competência técnica
     */
    private CompetenciaTecnica competenciaTecnica;

    /**
     * Variável de instância - grauProficiencia de proficiência
     */
    private GrauProficiencia grauProficiencia;

    /**
     * Valor por omissão - caráter obrigatório da competência técnica
     */
    private static final boolean OBRIGATORIO_POR_OMISSAO = false;
    private static final String OBRIGATORIO_STRING_POR_OMISSAO = "0";

    /**
     * Construtor completo do caráter da competência técnica
     *
     * @param obrigatorio caráter obrigatório da competência técnica
     * @param competenciaTecnica competência técnica
     * @param grauProficiencia grauProficiencia de proficiência
     */
    public CaraterCompetenciaTecnica(boolean obrigatorio, CompetenciaTecnica competenciaTecnica,
            GrauProficiencia grauProficiencia) {
        this.obrigatorio = obrigatorio;
        this.competenciaTecnica = new CompetenciaTecnica(competenciaTecnica);
        this.grauProficiencia = new GrauProficiencia(grauProficiencia);
        this.obrigatorioAsString = OBRIGATORIO_STRING_POR_OMISSAO;
    }

    /**
     * Construtor vazio do caráter da competência técnica
     */
    public CaraterCompetenciaTecnica() {
        this.obrigatorio = OBRIGATORIO_POR_OMISSAO;
        this.competenciaTecnica = new CompetenciaTecnica();
        this.grauProficiencia = new GrauProficiencia();
        this.obrigatorioAsString = OBRIGATORIO_STRING_POR_OMISSAO;
    }

    /**
     * Construtor cópia do caráter obrigatório da competência técnica
     *
     * @param outroCaraterCompetenciaTecnica instancia de caráter obrigatório da
     * competência técnica a ser copiado
     */
    public CaraterCompetenciaTecnica(CaraterCompetenciaTecnica outroCaraterCompetenciaTecnica) {
        this.obrigatorio = outroCaraterCompetenciaTecnica.obrigatorio;
        this.competenciaTecnica = new CompetenciaTecnica(
                outroCaraterCompetenciaTecnica.competenciaTecnica);
        this.grauProficiencia
                = new GrauProficiencia(outroCaraterCompetenciaTecnica.grauProficiencia);
        this.obrigatorioAsString = OBRIGATORIO_STRING_POR_OMISSAO;
    }

    public CaraterCompetenciaTecnica(Long id, boolean obrigatorio, String obrigatorioAsString, CompetenciaTecnica competenciaTecnica, GrauProficiencia grauProficiencia) {
        this.id = id;
        this.obrigatorio = obrigatorio;
        this.obrigatorioAsString = getObrigatorioAsString();
        this.competenciaTecnica = competenciaTecnica;
        this.grauProficiencia = grauProficiencia;
    }

    /**
     *
     * @return caráter obrigatório da competência técnica
     */
    @Transient
    public boolean isObrigatorio() {
        return obrigatorio;
    }

    /**
     *
     * @return competência técnica
     */
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) @Nullable
    @OneToOne
    @Nullable
    @JoinColumn(name = "CODIGO_COMPETENCIA_TECNICA", foreignKey = @ForeignKey(name
            = "FK_CARATERCOMPETENCIATECNICA_COMPETENCIATECNICA"))
//    @Column(name = "CODIGO_COMPETENCIA_TECNICA")
    public CompetenciaTecnica getCompetenciaTecnica() {
        return competenciaTecnica;
    }

    /**
     *
     * @return grauProficiencia de proficiência
     */
//    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.ALL} ) @Nullable
    @OneToOne
    @Nullable
    @JoinColumn(name = "ID_GRAU_PROFICIENCIA", foreignKey = @ForeignKey(name
            = "FK_CARATERCOMPETENCIATECNICA_GRAUPROFICIENCIA"))
    public GrauProficiencia getGrauProficiencia() {
        return grauProficiencia;
    }

    /**
     *
     * @param obrigatorio especifica um novo caráter obrigatório da competência
     * técnica
     */
    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
        setObrigatorioAsString(getObrigatorioAsString());
    }

    /**
     *
     * @param competenciaTecnica especifica uma nova competência técnica
     */
    public void setCompetenciaTecnica(CompetenciaTecnica competenciaTecnica) {
        this.competenciaTecnica = competenciaTecnica;
    }

    /**
     *
     * @param grauProficiencia especifica um novo grauProficiencia de
     * proficiência
     */
    public void setGrauProficiencia(GrauProficiencia grauProficiencia) {
        this.grauProficiencia = grauProficiencia;
    }

    /**
     *
     * @return retorna uma String com a descrição do carácter da competência
     * técnica (obrigatório, competência técnica, grauProficiencia de
     * proficiência)
     */
    @Override
    public String toString() {
        return String.format(
                "Carater competência técnica:\n  "
                + "obrigatório = %s\n "
                + "competência técnica = %s\n "
                + "grau = %s",
                isObrigatorio(),
                (getCompetenciaTecnica() == null) ? "" : getCompetenciaTecnica().toString(),
                (getGrauProficiencia() == null) ? "" : getGrauProficiencia().toString());
    }

    /**
     *
     * @param outroObjeto instancia de caráter de competência técnica a ser
     * comparada
     * @return reescrita do método equals e retorna um booleano
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        CaraterCompetenciaTecnica outroCaraterCompetenciaTecnica
                = (CaraterCompetenciaTecnica) outroObjeto;
        return competenciaTecnica.equals(outroCaraterCompetenciaTecnica.competenciaTecnica)
                && grauProficiencia.equals(outroCaraterCompetenciaTecnica.grauProficiencia);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.competenciaTecnica);
        hash = 67 * hash + Objects.hashCode(this.grauProficiencia);
        return hash;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "obrigatoria")
    public String getObrigatorioAsString() {
        return (this.obrigatorio) ? "1" : "0";
    }

    public void setObrigatorioAsString(String obrigatorioAsString) {
        this.obrigatorioAsString = obrigatorioAsString;
    }
}
