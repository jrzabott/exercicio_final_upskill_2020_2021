package t4j.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t4j.app.dto.UserInfoDTO;
import t4j.app.repo.Roles;
import t4j.app.repo.UsersAPI;
import t4j.app.utils.AlgoritmoGeradorPasswords;

@Service
public class UsersService {

    /**
     *
     */
    @Autowired
    UsersAPI uapi;

    /**
     *
     */
    @Autowired
    OrganizacoesService organizacoesService;

    /**
     *
     */
    public UsersService() {
    }

    /**
     *
     * @param u informação do utlizador a ser adicionado
     * @return true se adicionou um novo utilizador e false se contrário
     */
    public boolean addUtilizador(UserInfoDTO u) {
        boolean result;
        result = uapi.registerUser(u);
        if (result) {
            result = sendPassword(u.getEmail(), u.getPassword());
        }
        return result;
    }

    /**
     *
     * @param u informação do utilizador do qual se pretende conhecer o papel
     * @return o papel do utilizador passado por parâmetro
     */
    public String getRoles(UserInfoDTO u) {
        return uapi.getRoles(u);
    }

    /**
     *
     * @param u informação do utilizador do qual se pretende obter a sessão
     */
    public void getSession(UserInfoDTO u) {
        uapi.getSession(u);
    }

    /**
     *
     * @param u informação do utilizador do qual se pretende fazer logout
     * @return true se efetuou o logout do utilizador passado por parâmetro
     */
    public boolean logout(UserInfoDTO u) {
        return uapi.logout(u);
    }

    /**
     *
     * @param u informação do utilizador do qual se pretende fazer login
     * @return true se efetuou o login do utilizador passado por parâmetro
     */
    public boolean login(UserInfoDTO u) {
//        Plataforma p = Dados.carregarDados();
//        UsersAPI uapi = p.getUsersAPI();
        boolean result = this.uapi.login(u);
        uapi.getSession(u);
        if (u.getRolenames() != null) {
            if (u.getRolenames().toUpperCase().contains(Roles.COLABORADOR.name())) {
                organizacoesService.setOrgInfoInSessionByUserEmail(u);
            }
        }
        return result;
    }

    /**
     *
     * @param email email do utilizador para quem se pretende enviar o email
     * @return true se enviou o email com a nova password e false se contrário
     */
    public boolean sendNewPassword(String email) {
        String rndPass = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.MIX, 16);
        System.out.println(rndPass);
        System.out.println("Enviar email: " + email + "\nPassword: " + rndPass);
        return true;
    }

    /**
     *
     * @param email    email para onde se pretende enviar a password
     * @param password password a ser enviada por email
     * @return envia a password para o email passado por parâmetro
     */
    public boolean sendPassword(String email, String password) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n//////////////////////////////////////////////////////////");
        sb.append("\n// MAIL BODY /////////////////////////////////////////////");
        sb.append("\nusername: ").append(email);
        sb.append("\npassword: ").append(password);
        sb.append("\n// FIM MAIL BODY /////////////////////////////////////////");
        System.out.println(sb.toString());
        return true;
    }
}
