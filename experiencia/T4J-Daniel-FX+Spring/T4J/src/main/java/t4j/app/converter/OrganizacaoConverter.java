package t4j.app.converter;

import java.util.ArrayList;
import java.util.List;
import static t4j.app.converter.ColaboradorConverter.colaborador2ColaboradorDTO;
import static t4j.app.converter.ColaboradorConverter.colaboradorDTO2Colaborador;
import static t4j.app.converter.EnderecoPostalConverter.enderecoPostalDTO2enderecoPostal;
import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.EnderecoPostalDTO;
import t4j.app.dto.OrganizacaoDTO;
import t4j.app.dto.RegistoOrganizacoesDTO;
import t4j.app.model.Colaborador;
import t4j.app.model.EnderecoPostal;
import t4j.app.model.Organizacao;

public class OrganizacaoConverter {

    /**
     * 
     * @param organizacoes
     * @return
     * @throws NullPointerException 
     */
    public static List<OrganizacaoDTO> listOrganizacao2OrganizacaoDTO(List<Organizacao> organizacoes) throws NullPointerException {
        List<OrganizacaoDTO> organizacoesDTO = new ArrayList<>();
        for (Organizacao org : organizacoes) {
            try {
                OrganizacaoDTO odto = organizacao2OrganizacaoDTO(org);
                organizacoesDTO.add(odto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return organizacoesDTO;
    }

    /**
     * 
     * @param odto
     * @return 
     */
    public static Organizacao organizacaoDTO2Organizacao(OrganizacaoDTO odto) {
        Organizacao org = new Organizacao();
        org.setNome(odto.getNomeOrganizacao());
        org.setNif(odto.getNifOrganizacao());
        org.setTelefone(odto.getTelefoneOrganizacao());
        org.setEmail(odto.getEmailOrganizacao());
        org.setWebsite(odto.getWebsiteOrganizacao());

        // Endereço
        EnderecoPostal ep = new EnderecoPostal();
        ep = enderecoPostalDTO2enderecoPostal(odto.getEnderecoPostalDTO());
        org.setEndereco(ep);

        // Gestor
        Colaborador gestor = new Colaborador();
        gestor = colaboradorDTO2Colaborador(odto.getGestorDTO());
        org.setGestor(gestor);

        // Colaboradores
        if (odto.getColaboradores() != null && odto.getColaboradores().size()
                > 0) {
            ArrayList<Colaborador> colaboradoresList = new ArrayList<>();
            for (ColaboradorDTO colDTO : odto.getColaboradores()) {
                Colaborador col = new Colaborador();
                col = colaboradorDTO2Colaborador(colDTO);
                colaboradoresList.add(col);
            }
            org.setColaboradores(colaboradoresList);
        }
        return org;
    }

    /**
     * 
     * @param org
     * @return 
     */
    public static OrganizacaoDTO organizacao2OrganizacaoDTO(Organizacao org) {
        OrganizacaoDTO odto = new OrganizacaoDTO();
        odto.setNomeOrganizacao(org.getNome());
        odto.setNifOrganizacao(org.getNif());
        odto.setWebsiteOrganizacao(org.getWebsite());
        odto.setTelefoneOrganizacao(org.getTelefone());
        odto.setEmailOrganizacao(org.getEmail());

        // Endereço
        EnderecoPostalDTO epdto = new EnderecoPostalDTO();
        epdto.setCodPostal(org.getEndereco().getCodigoPostal());
        epdto.setLocalidade(org.getEndereco().getLocalidade());
        epdto.setMorada(org.getEndereco().getMorada());
        odto.setEnderecoPostalDTO(epdto);

        // Gestor
        ColaboradorDTO gestorDTO = new ColaboradorDTO();
        gestorDTO = colaborador2ColaboradorDTO(org.getGestor());
        odto.setGestorDTO(gestorDTO);

        // Colaboradores
        ArrayList<ColaboradorDTO> listaColaboradoresDTOs = new ArrayList<>();
        for (Colaborador colaborador : org.getColaboradores()) {
            ColaboradorDTO colaboradorDTO = colaborador2ColaboradorDTO(colaborador);
            listaColaboradoresDTOs.add(colaboradorDTO);
        }
        odto.setColaboradores(listaColaboradoresDTOs);
        return odto;
    }
}
