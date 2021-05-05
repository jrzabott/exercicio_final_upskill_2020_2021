package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoNaoExistenteException;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class RegistoAnuncios implements Serializable {

    /**
     * 
     */
    private ArrayList<Anuncio> anuncios;

    /**
     * 
     * @param anuncios 
     */
    public RegistoAnuncios(ArrayList<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    /**
     * 
     */
    public RegistoAnuncios() {
        this.anuncios = new ArrayList<>();
    }

    /**
     * 
     * @param outroRegistoAnuncios 
     */
    public RegistoAnuncios(RegistoAnuncios outroRegistoAnuncios) {
        this.anuncios = new ArrayList<>(outroRegistoAnuncios.anuncios);
    }

    /**
     * 
     * @return 
     */
    public ArrayList<Anuncio> getAnuncios() {
        return anuncios;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registo de anúncios:\n");
        for (int i = 0; i < anuncios.size(); i++) {
            anuncios.get(i).toString();
            sb.append(anuncios.get(i).toString());
        }
        return sb.toString();
    }

    /**
     * 
     * @param referencia
     * @return 
     */
    public Anuncio getAnuncioByReferencia(String referencia) {
        for (Anuncio anuncio : anuncios) {
            if (anuncio.getReferencia().equalsIgnoreCase(referencia)) {
                return anuncio;
            }
        }
        return null;
    }

    /**
     * 
     * @param anuncio
     * @return 
     */
    public boolean addAnuncio(Anuncio anuncio) {
        return (validaAnuncio(anuncio) != null) ? anuncios.add(anuncio) : false;
    }

    /**
     * 
     * @param referencia
     * @throws ElementoNaoExistenteException 
     */
    public void removeAnuncio(String referencia) throws ElementoNaoExistenteException {
        Anuncio anuncio = null;
        for (int i = 0; i < this.anuncios.size(); i++) {
            anuncio = this.anuncios.get(i);
            if (anuncio.getReferencia().equals(referencia)) {
                this.anuncios.remove(i);
                return;
            } else {
                throw new ElementoNaoExistenteException(referencia + ": Não existe este anúncio!!");
            }
        }
    }

    /**
     * 
     * @param referencia
     * @param a
     * @throws ElementoNaoExistenteException 
     */
    public void updateAnuncio(String referencia, Anuncio a) throws ElementoNaoExistenteException {
        Anuncio anuncio = null;
        boolean updated = false;
        for (int i = 0; i < this.anuncios.size(); i++) {
            anuncio = this.anuncios.get(i);
            if (anuncio.getReferencia().equals(referencia)) {
                this.anuncios.set(i, a);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(referencia + ": Não existe este anúncio!!");
        }
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.anuncios);
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
        final RegistoAnuncios outroRegistoAnuncios = (RegistoAnuncios) outroObjeto;
        return anuncios.equals(outroRegistoAnuncios.anuncios);
    }

    /**
     * 
     * @param anuncio
     * @return
     * @throws ElementoDuplicadoException 
     */
    private Anuncio validaAnuncio(Anuncio anuncio) throws ElementoDuplicadoException {
        if (getAnuncioByReferencia(anuncio.getReferencia()) == null) {
            return anuncio;
        } else {
            throw new ElementoDuplicadoException("Já existe um anúncio com essa referência!");
        }
    }
}
