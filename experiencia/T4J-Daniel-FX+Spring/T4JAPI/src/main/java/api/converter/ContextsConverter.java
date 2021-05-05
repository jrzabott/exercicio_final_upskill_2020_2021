package api.converter;

import api.DTO.ContextsDTO;
import api.DTO.LocalDateTimeDTO;
import static api.converter.LocalDateTimeConverter.data2DataDTO;
import static api.converter.LocalDateTimeConverter.dataDTO2Data;
import api.model.Contexts;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ContextsConverter {
    
    public static ContextsDTO contexts2ContextsDTO(Contexts contexts) throws NullPointerException {
        ContextsDTO contextsDTO = new ContextsDTO();
        contextsDTO.setId(contexts.getId());
        LocalDateTimeDTO ldtdto = data2DataDTO(contexts.getDataCriacao());
        contextsDTO.setDataCriacao(ldtdto);
        contextsDTO.setContext(contexts.getContext());
        contextsDTO.setValido(contexts.getValido());
        return contextsDTO;
    }

    public static Contexts contextsDTO2Contexts(ContextsDTO contextsDTO) throws NullPointerException {
        Contexts contexts = new Contexts();
        contexts.setId(contextsDTO.getId());
        LocalDateTime ldt = dataDTO2Data(contextsDTO.getDataCriacao());
        contexts.setDataCriacao(ldt);
        contexts.setContext(contextsDTO.getContext());
        contexts.setValido(contextsDTO.getValido());
        return contexts;
    }
    
    public static ArrayList<ContextsDTO> listContexts2ListContextsDTO(ArrayList<Contexts> contexts) throws NullPointerException {
        ArrayList<ContextsDTO> contextsDTO = new ArrayList<>();
        for (Contexts context : contexts) {
            try {
                ContextsDTO cdto = contexts2ContextsDTO(context);
                contextsDTO.add(cdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return contextsDTO;
    }

    public static ArrayList<Contexts> listContextsDTO2ListContexts(ArrayList<ContextsDTO> contextsDTO) throws NullPointerException {
        ArrayList<Contexts> contexts = new ArrayList<>();
        for (ContextsDTO contextDTO : contextsDTO) {
            try {
                Contexts c = contextsDTO2Contexts(contextDTO);
                contexts.add(c);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return contexts;
    }
}
