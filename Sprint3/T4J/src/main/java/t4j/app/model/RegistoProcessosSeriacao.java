package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoNaoExistenteException;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class RegistoProcessosSeriacao implements Serializable {
    
    /**
     * 
     */
    private ArrayList<ProcessoSeriacao> processosSeriacao;

    /**
     * 
     * @param processosSeriacao 
     */
    public RegistoProcessosSeriacao(ArrayList<ProcessoSeriacao> processosSeriacao) {
        this.processosSeriacao = processosSeriacao;
    }

    /**
     * 
     */
    public RegistoProcessosSeriacao() {
    }
    
    /**
     * 
     * @param outroProcessosSeriacao 
     */
    public RegistoProcessosSeriacao(RegistoProcessosSeriacao outroProcessosSeriacao) {
        this.processosSeriacao = new ArrayList<>(outroProcessosSeriacao.processosSeriacao);
    }

    /**
     * 
     * @return 
     */
    public ArrayList<ProcessoSeriacao> getProcessosSeriacao() {
        return processosSeriacao;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registo de processos de seriação:\n");
        for (int i = 0; i < processosSeriacao.size(); i++) {
            processosSeriacao.get(i).toString();
            sb.append(processosSeriacao.get(i).toString());
        }
        return sb.toString();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public ProcessoSeriacao getProcessoClassificacaoById(Long id) {
        for (ProcessoSeriacao processoSeriacao : processosSeriacao) {
            if (processoSeriacao.getId().equals(id)) {
                return processoSeriacao;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param processoSeriacao
     * @return 
     */
    public boolean addProcessoSeriacao(ProcessoSeriacao processoSeriacao) {
        return (validaProcessoSeriacao(processoSeriacao) != null) ? processosSeriacao.add(processoSeriacao) : false;
    }
    
    /**
     * 
     * @param id
     * @throws ElementoNaoExistenteException 
     */
    public void removeProcessoSeriacao(Long id) throws ElementoNaoExistenteException {
        ProcessoSeriacao processoSeriacao = null;
        for (int i = 0; i < this.processosSeriacao.size(); i++) {
            processoSeriacao = this.processosSeriacao.get(i);
            if (processoSeriacao.getId().equals(id)) {
                this.processosSeriacao.remove(i);
                return;
            } else {
                throw new ElementoNaoExistenteException(processoSeriacao + ": Não existe esta classificação!!");
            }
        }
    }
    
    /**
     * 
     * @param id
     * @param ps
     * @throws ElementoNaoExistenteException 
     */
    public void updateProcessoSeriacao(Long id, ProcessoSeriacao ps) throws ElementoNaoExistenteException {
        ProcessoSeriacao processoSeriacao = null;
        boolean updated = false;
        for (int i = 0; i < this.processosSeriacao.size(); i++) {
            processoSeriacao = this.processosSeriacao.get(i);
            if (processoSeriacao.getId().equals(id)) {
                this.processosSeriacao.set(i, ps);
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
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.processosSeriacao);
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
        RegistoProcessosSeriacao outroRegistoProcessosSeriacao = (RegistoProcessosSeriacao) outroObjeto;
        return processosSeriacao.equals(outroRegistoProcessosSeriacao.processosSeriacao);
    }

    /**
     * 
     * @param processoSeriacao
     * @return 
     */
    private ProcessoSeriacao validaProcessoSeriacao(ProcessoSeriacao processoSeriacao) {
        if (getProcessoClassificacaoById(processoSeriacao.getId()) == null) {
            return processoSeriacao;
        } else {
            throw new ElementoDuplicadoException("Já existe um processo de seriação com esse id!");
        }
    }
}
