package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoNaoExistenteException;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class RegistoTiposRegimento implements Serializable {

    /**
     * 
     */
    private ArrayList<TipoRegimento> tiposRegimento;

    /**
     * 
     * @param tiposRegimento 
     */
    public RegistoTiposRegimento(ArrayList<TipoRegimento> tiposRegimento) {
        this.tiposRegimento = tiposRegimento;
    }

    /**
     * 
     */
    public RegistoTiposRegimento() {
        this.tiposRegimento = new ArrayList<>();
    }

    /**
     * 
     * @param outroRegistoTiposRegimento 
     */
    public RegistoTiposRegimento(RegistoTiposRegimento outroRegistoTiposRegimento) {
        this.tiposRegimento = new ArrayList<>(outroRegistoTiposRegimento.tiposRegimento);
    }

    /**
     * 
     * @return 
     */
    public ArrayList<TipoRegimento> getTiposRegimento() {
        return tiposRegimento;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registo de tipos de regimento:\n");
        for (int i = 0; i < tiposRegimento.size(); i++) {
            tiposRegimento.get(i).toString();
            sb.append(tiposRegimento.get(i).toString());
        }
        return sb.toString();
    }

    /**
     * 
     * @param designacao
     * @return 
     */
    public TipoRegimento getTipoRegimentoByDesignacao(String designacao) {
        for (TipoRegimento tipoRegimento : tiposRegimento) {
            if (tipoRegimento.getDesignacao().equalsIgnoreCase(designacao)) {
                return tipoRegimento;
            }
        }
        return null;
    }

    /**
     * 
     * @param tipoRegimento
     * @return 
     */
    public boolean addTipoRegimento(TipoRegimento tipoRegimento) {
        return (validaTipoRegimento(tipoRegimento) != null) ? tiposRegimento.add(tipoRegimento) : false;
    }

    /**
     * 
     * @param designacao
     * @throws ElementoNaoExistenteException 
     */
    public void removeTipoRegimento(String designacao) throws ElementoNaoExistenteException {
        TipoRegimento tipoRegimento = null;
        for (int i = 0; i < this.tiposRegimento.size(); i++) {
            tipoRegimento = this.tiposRegimento.get(i);
            if (tipoRegimento.getDesignacao().equals(designacao)) {
                this.tiposRegimento.remove(i);
                return;
            } else {
                throw new ElementoNaoExistenteException(designacao + ": Não existe este tipo de regimento!!");
            }
        }
    }

    /**
     * 
     * @param designacao
     * @param tr
     * @throws ElementoNaoExistenteException 
     */
    public void updateTipoRegimento(String designacao, TipoRegimento tr) throws ElementoNaoExistenteException {
        TipoRegimento tipoRegimento = null;
        boolean updated = false;
        for (int i = 0; i < this.tiposRegimento.size(); i++) {
            tipoRegimento = this.tiposRegimento.get(i);
            if (tipoRegimento.getDesignacao().equals(designacao)) {
                this.tiposRegimento.set(i, tr);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(designacao + ": Não existe este tipo de regimento!!");
        }
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.tiposRegimento);
        return hash;
    }

    /**
     * 
     * @param outroObjeto
     * @return 
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        final RegistoTiposRegimento outroTiposRegimento = (RegistoTiposRegimento) outroObjeto;
        return tiposRegimento.equals(outroTiposRegimento.tiposRegimento);
    }

    /**
     * 
     * @param tipoRegimento
     * @return
     * @throws ElementoDuplicadoException 
     */
    private TipoRegimento validaTipoRegimento(TipoRegimento tipoRegimento) throws ElementoDuplicadoException {
        if (getTipoRegimentoByDesignacao(tipoRegimento.getDesignacao()) == null) {
            return tipoRegimento;
        } else {
            throw new ElementoDuplicadoException("Já existe um tipo de regimento com essa descrição!");
        }
    }
}
