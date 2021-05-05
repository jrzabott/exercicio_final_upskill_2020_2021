package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
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
import org.springframework.lang.Nullable;

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
    /**
     *
     */
    private boolean obrigatorio;

    /**
     *
     */
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

    /**
     *
     */
    private static final String OBRIGATORIO_STRING_POR_OMISSAO = "0";

    /**
     * Construtor completo do caráter da competência técnica
     *
     * @param obrigatorio caráter obrigatório da competência técnica
     * @param competenciaTecnica competência técnica
     * @param grauProficiencia grauProficiencia de proficiência
     */
    public CaraterCompetenciaTecnica(boolean obrigatorio, CompetenciaTecnica competenciaTecnica, GrauProficiencia grauProficiencia) {
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
     * @param outroCaraterCompetenciaTecnica instancia de caráter obrigatório da competência técnica a ser copiado
     */
    public CaraterCompetenciaTecnica(CaraterCompetenciaTecnica outroCaraterCompetenciaTecnica) {
        this.id = outroCaraterCompetenciaTecnica.id;
        this.obrigatorio = outroCaraterCompetenciaTecnica.obrigatorio;
        this.obrigatorioAsString = outroCaraterCompetenciaTecnica.getObrigatorioAsString();
        this.competenciaTecnica = new CompetenciaTecnica(
                outroCaraterCompetenciaTecnica.competenciaTecnica);
        this.grauProficiencia
                = new GrauProficiencia(outroCaraterCompetenciaTecnica.grauProficiencia);
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
     * @return
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long getId() {
        return id;
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
    @OneToOne
    @Nullable
    @JoinColumn(name = "CODIGO_COMPETENCIA_TECNICA", foreignKey = @ForeignKey(name = "FK_CARATERCOMPETENCIATECNICA_COMPETENCIATECNICA"))
    public CompetenciaTecnica getCompetenciaTecnica() {
        return competenciaTecnica;
    }

    /**
     *
     * @return grauProficiencia de proficiência
     */
    @OneToOne
    @Nullable
    @JoinColumn(name = "ID_GRAU_PROFICIENCIA", foreignKey = @ForeignKey(name = "FK_CARATERCOMPETENCIATECNICA_GRAUPROFICIENCIA"))
    public GrauProficiencia getGrauProficiencia() {
        return grauProficiencia;
    }

    /**
     *
     * @return
     */
    @Column(name = "obrigatoria")
    public String getObrigatorioAsString() {
        return (this.obrigatorio) ? "1" : "0";
    }

    /**
     *
     * @param obrigatorio especifica um novo caráter obrigatório da competência técnica
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
     * @param grauProficiencia especifica um novo grauProficiencia de proficiência
     */
    public void setGrauProficiencia(GrauProficiencia grauProficiencia) {
        this.grauProficiencia = grauProficiencia;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param obrigatorioAsString
     */
    public void setObrigatorioAsString(String obrigatorioAsString) {
        this.obrigatorioAsString = obrigatorioAsString;
    }

    /**
     *
     * @return retorna uma String com a descrição do carácter da competência técnica (obrigatório, competência técnica, grauProficiencia de proficiência)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CaraterCompetenciaTecnica{id=").append(id);
        sb.append(", obrigatorio=").append(obrigatorio);
        sb.append(", obrigatorioAsString=").append(obrigatorioAsString);
        sb.append(", competenciaTecnica=").append(competenciaTecnica);
        sb.append(", grauProficiencia=").append(grauProficiencia);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + (this.obrigatorio ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.obrigatorioAsString);
        hash = 53 * hash + Objects.hashCode(this.competenciaTecnica);
        hash = 53 * hash + Objects.hashCode(this.grauProficiencia);
        return hash;
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CaraterCompetenciaTecnica other = (CaraterCompetenciaTecnica) obj;
        if (this.obrigatorio != other.obrigatorio) {
            return false;
        }
        if (!Objects.equals(this.obrigatorioAsString, other.obrigatorioAsString)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.competenciaTecnica, other.competenciaTecnica)) {
            return false;
        }
        if (!Objects.equals(this.grauProficiencia, other.grauProficiencia)) {
            return false;
        }
        return true;
    }
}
