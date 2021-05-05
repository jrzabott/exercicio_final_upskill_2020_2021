package t4j.app.converter;

import java.util.ArrayList;
import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.RegistoColaboradoresDTO;
import t4j.app.dto.UserInfoDTO;
import t4j.app.model.Colaborador;

public class ColaboradorConverter {

    /**
     *
     * @param colaboradores
     * @return
     * @throws NullPointerException
     */
    public static RegistoColaboradoresDTO listColaborador2ColaboradorDTO(ArrayList<Colaborador> colaboradores) throws NullPointerException {
        ArrayList<ColaboradorDTO> colaboradoresDTO = new ArrayList<>();
        for (Colaborador col : colaboradores) {
            try {
                ColaboradorDTO colaboradorDTO = colaborador2ColaboradorDTO(col);
                colaboradoresDTO.add(colaboradorDTO);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        RegistoColaboradoresDTO lista = new RegistoColaboradoresDTO();
        lista.setColaboradores(colaboradoresDTO);
        return lista;
    }

    /**
     *
     * @param colaboradores
     * @return
     * @throws NullPointerException
     */
    public static ArrayList<ColaboradorDTO> listColaborador2ListColaboradorDTO(ArrayList<Colaborador> colaboradores) throws NullPointerException {
        ArrayList<ColaboradorDTO> colaboradoresDTO = new ArrayList<>();
        for (Colaborador colaborador : colaboradores) {
            try {
                ColaboradorDTO cdto = colaborador2ColaboradorDTO(colaborador);
                colaboradoresDTO.add(cdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return colaboradoresDTO;
    }

    /**
     *
     * @param colaborador
     * @return
     * @throws NullPointerException
     */
    public static ColaboradorDTO colaborador2ColaboradorDTO(Colaborador colaborador) throws NullPointerException {
        ColaboradorDTO cdto = new ColaboradorDTO();
        cdto.setNome(colaborador.getNome());
        cdto.setFuncao(colaborador.getFuncao());
        cdto.setEmail(colaborador.getEmail());
        cdto.setTelefone(colaborador.getTelefone());
        cdto.setNifOrganizacao(colaborador.getNifOrganizacao());
        cdto.setGestor(colaborador.getGestor());
        return cdto;
    }

    /**
     *
     * @param colaboradorDTO
     * @return
     * @throws NullPointerException
     */
    public static Colaborador colaboradorDTO2Colaborador(ColaboradorDTO colaboradorDTO) throws NullPointerException {
        Colaborador colaborador = null;
        colaborador = new Colaborador();
        colaborador.setNome(colaboradorDTO.getNome());
        colaborador.setFuncao(colaboradorDTO.getFuncao());
        colaborador.setEmail(colaboradorDTO.getEmail());
        colaborador.setTelefone(colaboradorDTO.getTelefone());
        colaborador.setNifOrganizacao(colaboradorDTO.getNifOrganizacao());
        colaborador.setGestor(colaboradorDTO.getGestor());
        return colaborador;
    }

    /**
     *
     * @param gestorDTO
     * @return
     */
    public static UserInfoDTO colaboradorDTO2UserInfoDTO(ColaboradorDTO gestorDTO) {
        UserInfoDTO u = new UserInfoDTO();
        u.setEmail(gestorDTO.getEmail());
        u.setUsername(gestorDTO.getEmail());
        u.setNifOrganizacao(gestorDTO.getNifOrganizacao());
        return u;
    }

    /**
     * 
     * @param gestorDTO
     * @param rolesString
     * @return 
     */
    public static UserInfoDTO colaboradorDTO2UserInfoDTO(ColaboradorDTO gestorDTO, String rolesString) {
        UserInfoDTO uidto = new UserInfoDTO();
        uidto.setUsername(gestorDTO.getEmail());
        uidto.setEmail(gestorDTO.getEmail());
        uidto.setRolenames(rolesString);
        return uidto;
    }
}
