package t4j.app.converter;

import java.util.ArrayList;
import java.util.List;
import static t4j.app.converter.EnderecoPostalConverter.enderecoPostal2enderecoPostalDTO;
import static t4j.app.converter.EnderecoPostalConverter.enderecoPostalDTO2enderecoPostal;
import t4j.app.dto.FreeLancerDTO;
import t4j.app.dto.HabilitacaoAcademicaDTO;
import t4j.app.dto.RegistoFreeLancersDTO;
import t4j.app.dto.UserInfoDTO;
import t4j.app.model.FreeLancer;
import t4j.app.model.HabilitacaoAcademica;

public class FreeLancerConverter {

    /**
     * 
     * @param freeLancers
     * @return
     * @throws NullPointerException 
     */
    public static RegistoFreeLancersDTO listFreeLancer2ListFreeLancerDTO(ArrayList<FreeLancer> freeLancers) throws NullPointerException {
        ArrayList<FreeLancerDTO> freeLancersDTO = new ArrayList<>();
        for (FreeLancer fl : freeLancers) {
            try {
                FreeLancerDTO freeLancerDTO = freeLancer2FreeLancerDTO(fl);
                freeLancersDTO.add(freeLancerDTO);
            } catch (NullPointerException e) {     //does nothing. Actually, nothing is added to arraylist
            }
        }
        RegistoFreeLancersDTO lista = new RegistoFreeLancersDTO();
        lista.setFreeLancers(freeLancersDTO);
        return lista;
    }

    /**
     *
     * @param freeLancer
     * @return
     * @throws NullPointerException
     */
    public static FreeLancerDTO freeLancer2FreeLancerDTO(FreeLancer freeLancer) throws NullPointerException {
        FreeLancerDTO flto = new FreeLancerDTO();
        flto.setNome(freeLancer.getNome());
        flto.setNif(freeLancer.getNif());
        flto.setEmail(freeLancer.getEmail());
        flto.setTelefone(freeLancer.getTelefone());
        flto.setEndereco(enderecoPostal2enderecoPostalDTO(freeLancer.getEndereco()));
        List<HabilitacaoAcademicaDTO> habilitacoesDTO = new ArrayList();
        for (HabilitacaoAcademica habilitacoe : freeLancer.getHabilitacoes()) {
            habilitacoesDTO.add(HabilitacaoAcademicaConverter.habilitacaoAcademica2HabilitacaoAcademicaDTO(habilitacoe));
        }
        flto.setHabilitacoes(habilitacoesDTO);
        return flto;
    }

    /**
     *
     * @param freeLancerDto
     * @return
     * @throws NullPointerException
     */
    public static FreeLancer freeLancerDTO2FreeLancer(FreeLancerDTO freeLancerDto) throws NullPointerException {
        FreeLancer freeLancer = null;
        freeLancer = new FreeLancer();
        freeLancer.setNome(freeLancerDto.getNome());
        freeLancer.setNif(freeLancerDto.getNif());
        freeLancer.setEmail(freeLancerDto.getEmail());
        freeLancer.setTelefone(freeLancerDto.getTelefone());
        freeLancer.setEndereco(enderecoPostalDTO2enderecoPostal(freeLancerDto.getEndereco()));
        return freeLancer;
    }

    /**
     * 
     * @param freeLancerDTO
     * @return 
     */
    public static UserInfoDTO freeLancerDTO2UserInfoDTO(FreeLancerDTO freeLancerDTO) {
        UserInfoDTO u = new UserInfoDTO();
        u.setEmail(freeLancerDTO.getEmail());
        u.setUsername(freeLancerDTO.getEmail());
        return u;
    }
}
