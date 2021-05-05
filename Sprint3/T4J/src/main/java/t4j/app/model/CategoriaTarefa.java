package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

@Entity
@Table(name = "CATEGORIATAREFA")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class CategoriaTarefa implements Serializable {

    /**
     * Variável de instância - ID da categoria
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    /**
     * Variável de instância - descrição da categoria
     */
    @Column(name = "descricao")
    private String descricaoCategoria;

    /**
     * Variável de instância - área de atividade na qual a categoria de enquadra
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CODIGO_AREA_ATIVIDADE", foreignKey = @ForeignKey(name = "FK_CATEGORIATAREFA_AREAATIVIDADE"))
//    @Column(name = "CODIGO_AREA_ATIVIDADE")
    private AreaAtividade areaAtividade;

    /**
     * Variável de instância - contentor do tipo ArrayList onde é guardado o
     * carácter da competência técnica requerida pela categoria
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CATEGORIA", foreignKey = @ForeignKey(foreignKeyDefinition = "FK_CARATERCOMPETENCIATECNICA_CATEGORIATAREFA"))
    private List<CaraterCompetenciaTecnica> listaCaraterCompetenciaTecnica;

    /**
     * Construtor completo de categoria
     *
     * @param descricao descrição da categoria
     * @param areaAtividade área de atividade na qual a categoria de enquadra
     * @param listaCaraterCompetenciaTecnica contentor do tipo ArrayList onde é
     * guardado o carácter da competência técnica requerida pela categoria
     */
    public CategoriaTarefa(String descricao, AreaAtividade areaAtividade,
            List<CaraterCompetenciaTecnica> listaCaraterCompetenciaTecnica) {
        setDescricaoCategoria(descricao);
        this.areaAtividade = new AreaAtividade(areaAtividade);
        this.listaCaraterCompetenciaTecnica = new ArrayList<>(listaCaraterCompetenciaTecnica);
        this.idCategoria = 0L;
    }

    /**
     * Construtor vazio de categoria
     */
    public CategoriaTarefa() {
        areaAtividade = new AreaAtividade();
        listaCaraterCompetenciaTecnica = new ArrayList<>();
        this.idCategoria = 0L;
    }

    /**
     * Construtor cópia de categoria
     *
     * @param outraCategoria instância de categoria a ser copiada
     */
    public CategoriaTarefa(CategoriaTarefa outraCategoria) {
        setDescricaoCategoria(outraCategoria.descricaoCategoria);
        this.areaAtividade = new AreaAtividade(outraCategoria.areaAtividade);
        this.listaCaraterCompetenciaTecnica = new ArrayList<>(outraCategoria.listaCaraterCompetenciaTecnica);
        this.idCategoria = 0L;
    }

    /**
     *
     * @return ID da categoria
     */
    public Long getIdCategoria() {
        return idCategoria;
    }

    /**
     *
     * @return descrição da categoria
     */
    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    /**
     *
     * @return lista de carácter de competências técnicas
     */
    public List<CaraterCompetenciaTecnica> getListaCaraterCompetenciaTecnica() {
        return listaCaraterCompetenciaTecnica;
    }

    /**
     *
     * @return área de atividade em qual a categoria de enquadra
     */
    public AreaAtividade getAreaAtividade() {
        return areaAtividade;
    }

    /**
     *
     * @param descricaoCategoria especifica uma nova descrição da categoria
     */
    public void setDescricaoCategoria(String descricaoCategoria) throws ElementoInvalidoException {
        descricaoCategoria = descricaoCategoria.trim();
        if (Validacao.validaDescricaoCategoria(descricaoCategoria)) {
            this.descricaoCategoria = descricaoCategoria;
        } else {
            throw new ElementoInvalidoException("Descrição inválida.");
        }
    }

    /**
     *
     * @param areaAtividadeAtividade especifica uma nova área de atividade na
     * qual a categoria se enquadra
     */
    public void setAreaAtividade(AreaAtividade areaAtividadeAtividade) {
        this.areaAtividade = areaAtividadeAtividade;
    }

    /**
     *
     * @return retorna uma String com a descrição da categoria
     */
    @Override
    public String toString() {
        return String.format("Categoria:\n ID de Categoria = %s\n descrição = %s\n área de atividade = %s\n lista de competências técnicas = %s", getIdCategoria(), getDescricaoCategoria(), getAreaAtividade().toString(), getListaCaraterCompetenciaTecnica().toString());
    }

    /**
     *
     * @param caraterCompetenciaTecnica carácter de competência técnica
     * @return retorna verdadeiro se for adicionado um novo carácter de
     * competência técnica e falso se contrário
     */
    public boolean addCaraterCompetenciaTecnica(CaraterCompetenciaTecnica caraterCompetenciaTecnica) {
        return (validaCaraterCompetenciaTecnica(caraterCompetenciaTecnica) != null) ? listaCaraterCompetenciaTecnica.add(caraterCompetenciaTecnica) : false;
    }

    /**
     *
     * @param outroObjeto instancia de categoria a ser comparada
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
        CategoriaTarefa outraCategoria = (CategoriaTarefa) outroObjeto;
        return descricaoCategoria.equalsIgnoreCase(outraCategoria.descricaoCategoria)
                && areaAtividade.equals(outraCategoria.areaAtividade)
                && listaCaraterCompetenciaTecnica.equals(outraCategoria.listaCaraterCompetenciaTecnica);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.descricaoCategoria);
        hash = 13 * hash + Objects.hashCode(this.areaAtividade);
        hash = 13 * hash + Objects.hashCode(this.listaCaraterCompetenciaTecnica);
        return hash;
    }

    public void setIdCategoria(Long idCategoria) {
        // Daniel Junior 20210208 16:29
        // Falta validação do ID.
        this.idCategoria = idCategoria;
    }

    public void setListaCaraterCompetenciaTecnica(ArrayList<CaraterCompetenciaTecnica> listaCaraterCompetenciaTecnica) {
        this.listaCaraterCompetenciaTecnica = new ArrayList<>(listaCaraterCompetenciaTecnica);
    }

    /**
     *
     * @param caraterCompetenciaTecnica
     * @return valida carácter de competência técnica
     * @throws ElementoDuplicadoException
     */
    private CaraterCompetenciaTecnica validaCaraterCompetenciaTecnica(CaraterCompetenciaTecnica caraterCompetenciaTecnica) throws ElementoDuplicadoException {
        if (getCaraterCompetenciaTecnica(caraterCompetenciaTecnica) == null) {
            return caraterCompetenciaTecnica;
        } else {
            throw new ElementoDuplicadoException("Já existe um CCT com essa competência e grau!");
        }
    }

    /**
     *
     * @param cct instância de carácter de competência técnica e ser devolvida
     * @return devolve o carácter de competência técnica
     */
    private CaraterCompetenciaTecnica getCaraterCompetenciaTecnica(CaraterCompetenciaTecnica cct) {
        for (CaraterCompetenciaTecnica caraterCT : listaCaraterCompetenciaTecnica) {
            if (caraterCT.equals(cct)) {
                return caraterCT;
            }
        }
        return null;
    }
}
