package t4j.app.converter;

import t4j.app.dto.EnderecoPostalDTO;
import t4j.app.model.EnderecoPostal;

public class EnderecoPostalConverter {

    /**
     *
     * @param enderecoPostal
     * @return
     */
    public static EnderecoPostalDTO enderecoPostal2enderecoPostalDTO(EnderecoPostal enderecoPostal) {
        EnderecoPostalDTO enderecoPostalDTO = new EnderecoPostalDTO();
        enderecoPostalDTO.setMorada(enderecoPostal.getMorada());
        enderecoPostalDTO.setCodPostal(enderecoPostal.getCodigoPostal());
        enderecoPostalDTO.setLocalidade(enderecoPostal.getLocalidade());
        enderecoPostalDTO.setId(enderecoPostal.getId());
        return enderecoPostalDTO;
    }

    /**
     *
     * @param enderecoPostalDTO
     * @return
     */
    public static EnderecoPostal enderecoPostalDTO2enderecoPostal(EnderecoPostalDTO enderecoPostalDTO) {
        EnderecoPostal ep = new EnderecoPostal();
        ep.setMorada(enderecoPostalDTO.getMorada());
        ep.setCodigoPostal(enderecoPostalDTO.getCodPostal());
        ep.setLocalidade(enderecoPostalDTO.getLocalidade());
        ep.setId(enderecoPostalDTO.getId());
        return ep;
    }
}
