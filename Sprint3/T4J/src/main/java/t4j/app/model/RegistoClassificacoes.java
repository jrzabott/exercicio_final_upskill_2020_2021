package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoNaoExistenteException;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class RegistoClassificacoes implements Serializable {
    
    /**
     * 
     */
    private ArrayList<Classificacao> classificacoes;
    
    /**
     * 
     * @param classificacoes 
     */
    public RegistoClassificacoes(ArrayList<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }
    
    /**
     * 
     */
    public RegistoClassificacoes() {
        this.classificacoes = new ArrayList<>();
    }
    
    /**
     * 
     * @param outroRegistoClassificacoes 
     */
    public RegistoClassificacoes(RegistoClassificacoes outroRegistoClassificacoes) {
        this.classificacoes = new ArrayList<>(outroRegistoClassificacoes.classificacoes);
    }

    /**
     * 
     * @return 
     */
    public ArrayList<Classificacao> getClassificacoes() {
        return classificacoes;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registo de classificações:\n");
        for (int i = 0; i < classificacoes.size(); i++) {
            classificacoes.get(i).toString();
            sb.append(classificacoes.get(i).toString());
        }
        return sb.toString();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Classificacao getClassificacaoById(Long id) {
        for (Classificacao classificacao : classificacoes) {
            if (classificacao.getId().equals(id)) {
                return classificacao;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param classificacao
     * @return 
     */
    public boolean addClassificacao(Classificacao classificacao) {
        return (validaClassificacao(classificacao) != null) ? classificacoes.add(classificacao) : false;
    }
    
    /**
     * 
     * @param id
     * @throws ElementoNaoExistenteException 
     */
    public void removeClassificacao(Long id) throws ElementoNaoExistenteException {
        Classificacao classificacao = null;
        for (int i = 0; i < this.classificacoes.size(); i++) {
            classificacao = this.classificacoes.get(i);
            if (classificacao.getId().equals(id)) {
                this.classificacoes.remove(i);
                return;
            } else {
                throw new ElementoNaoExistenteException(classificacao + ": Não existe esta classificação!!");
            }
        }
    }
    
    /**
     * 
     * @param id
     * @param c
     * @throws ElementoNaoExistenteException 
     */
    public void updateClassificacao(Long id, Classificacao c) throws ElementoNaoExistenteException {
        Classificacao classificacao = null;
        boolean updated = false;
        for (int i = 0; i < this.classificacoes.size(); i++) {
            classificacao = this.classificacoes.get(i);
            if (classificacao.getId().equals(id)) {
                this.classificacoes.set(i, c);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(id + ": Não existe esta classificação!!");
        }
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.classificacoes);
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
        RegistoClassificacoes outroRegistoClassificacoes = (RegistoClassificacoes) outroObjeto;
        return classificacoes.equals(outroRegistoClassificacoes.classificacoes);
    }
    
    /**
     * 
     * @param classificacao
     * @return 
     */
    private Classificacao validaClassificacao(Classificacao classificacao) {
        if (getClassificacaoById(classificacao.getId()) == null) {
            return classificacao;
        } else {
            throw new ElementoDuplicadoException("Já existe uma classificação com esse id!");
        }
    }
}
