package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static t4j.app.converter.ColaboradorConverter.colaboradorDTO2Colaborador;
import static t4j.app.converter.ColaboradorConverter.colaboradorDTO2UserInfoDTO;
import static t4j.app.converter.ColaboradorConverter.listColaborador2ListColaboradorDTO;
import t4j.app.dao.ColaboradorDAO;
import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.UserInfoDTO;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.model.Colaborador;
import t4j.app.repo.EnumRoles;
import t4j.app.repo.UsersAPI;
import t4j.app.utils.AlgoritmoGeradorPasswords;

@Service
public class ColaboradoresService {

    /**
     *
     */
    @Autowired
    UsersService usersService;

    /**
     *
     */
    @Autowired
    ColaboradorDAO colaboradorDAO;

    /**
     *
     */
    @Autowired
    UsersAPI usersAPI;

    /**
     *
     */
    public ColaboradoresService() {
    }

    /**
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public ArrayList<ColaboradorDTO> getListaColaboradores() {
        ArrayList<ColaboradorDTO> listaColaboradoresDTO = new ArrayList<>();
        List<Colaborador> lista;
        lista = colaboradorDAO.findAll();
        ArrayList<Colaborador> listaCcolaboradores = new ArrayList<>(lista);
        listaColaboradoresDTO = listColaborador2ListColaboradorDTO(listaCcolaboradores);
        return listaColaboradoresDTO;
    }

    /**
     *
     * @param u informação do utilizador que se pretende adicionar
     * @return true se um novo utilizador foi adicionado e false se contrário
     */
    public boolean addUtilizador(UserInfoDTO u) {
        return usersAPI.registerUser(u);
    }

    /**
     *
     * @param u informação do utilizador colaborador que se pretende adicionar
     * @return true se um novo utilizador colaborador foi adicionado e false se contrário
     */
    public boolean addUtilizadorColaborador(UserInfoDTO u) {
        String rolesString = EnumRoles.COLABORADOR.toString();
        u.setRolenames(rolesString);
        return addUtilizador(u);
    }

    /**
     *
     * @param u informação do utilizador gestor que se pretende adicionar
     * @return true se um novo utilizador gestor foi adicionado e false se contrário
     */
    public boolean addUtilizadorGestor(UserInfoDTO u) {
        String rolesString = new StringBuilder()
                .append(EnumRoles.GESTOR.toString())
                .append(",")
                .append(EnumRoles.COLABORADOR.toString())
                .toString();
        u.setRolenames(rolesString);
        return addUtilizador(u);
    }

    public boolean addColaborador(ColaboradorDTO cdto) {
        boolean result = false;
        Colaborador colaborador = colaboradorDTO2Colaborador(cdto);
        if (colaborador == null) {
            throw new ElementoInvalidoException("ColaboradorDTO");
        }
        Optional<Colaborador> o = colaboradorDAO.findById(colaborador.getEmail());
        o.ifPresent(consumer -> {
            throw new ElementoDuplicadoException(
                    new StringBuilder()
                            .append(consumer.getEmail())
                            .append(": Já existe um utilizador registado para este email.")
                            .toString()
            );
        });
        colaborador = colaboradorDAO.save(colaborador);
        result = colaborador != null;

        Optional<UserInfoDTO> u = Optional.ofNullable(colaboradorDTO2UserInfoDTO(cdto));
        u.<ElementoInvalidoException>orElseThrow(() -> {
            throw new ElementoInvalidoException("colaboradorDTO2UserInfoDTO");
        }).setPassword(AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.MIX, 16));
        addUtilizadorColaborador(u.get());
        usersService.sendPassword(u.get().getEmail(), u.get().getPassword());

        return result;
    }
}
