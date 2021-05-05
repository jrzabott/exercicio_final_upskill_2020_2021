package t4j.app.converter;

import java.util.ArrayList;
import t4j.app.dto.ClassificacaoDTO;
import t4j.app.model.Classificacao;

public class ClassificacaoConverter {
    
    /**
     * 
     * @param classificacao
     * @return 
     */
    public static ClassificacaoDTO classificacao2ClassificacaoDTO(Classificacao classificacao) {
        ClassificacaoDTO classificacaoDTO = new ClassificacaoDTO();
        classificacaoDTO.setId(classificacao.getId());
        classificacaoDTO.setIdProcessoSeriacao(classificacao.getIdProcessoSeriacao());
        classificacaoDTO.setIdCandidaturaVencedora(classificacao.getIdCandidaturaVencedora());
        return classificacaoDTO;
    }

    /**
     * 
     * @param classificacaoDTO
     * @return 
     */
    public static Classificacao classificacaoDTO2Classificacao(ClassificacaoDTO classificacaoDTO) {
        Classificacao classificacao = new Classificacao();
        classificacao.setId(classificacaoDTO.getId());
        classificacao.setIdProcessoSeriacao(classificacaoDTO.getIdProcessoSeriacao());
        classificacao.setIdCandidaturaVencedora(classificacaoDTO.getIdCandidaturaVencedora());
        return classificacao;
    }

    /**
     * 
     * @param classificacoes
     * @return
     * @throws NullPointerException 
     */
    public static ArrayList<ClassificacaoDTO> listClassificacoes2ListClassificacoesDTO(ArrayList<Classificacao> classificacoes) throws NullPointerException {
        ArrayList<ClassificacaoDTO> classificacoesDTO = new ArrayList<>();
        for (Classificacao classificacao : classificacoes) {
            try {
                ClassificacaoDTO cdto = classificacao2ClassificacaoDTO(classificacao);
                classificacoesDTO.add(cdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return classificacoesDTO;
    }

    /**
     * 
     * @param classificacoesDTO
     * @return
     * @throws NullPointerException 
     */
    public static ArrayList<Classificacao> listClassificacoesDTODTO2ListClassificacoes(ArrayList<ClassificacaoDTO> classificacoesDTO) throws NullPointerException {
        ArrayList<Classificacao> classificacoes = new ArrayList<>();
        for (ClassificacaoDTO classificacaoDTO : classificacoesDTO) {
            try {
                Classificacao classificacao = classificacaoDTO2Classificacao(classificacaoDTO);
                classificacoes.add(classificacao);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return classificacoes;
    }
}
