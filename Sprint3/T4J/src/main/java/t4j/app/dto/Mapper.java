package t4j.app.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import t4j.app.model.Anuncio;
import t4j.app.model.AreaAtividade;
import t4j.app.model.Candidatura;
import t4j.app.model.CaraterCompetenciaTecnica;
import t4j.app.model.CategoriaTarefa;
import t4j.app.model.Classificacao;
import t4j.app.model.Colaborador;
import t4j.app.model.CompetenciaTecnica;
import t4j.app.model.EnderecoPostal;
import t4j.app.model.FreeLancer;
import t4j.app.model.GrauProficiencia;
import t4j.app.model.HabilitacaoAcademica;
import t4j.app.model.Organizacao;
import t4j.app.model.ProcessoSeriacao;
import t4j.app.model.ReconhecimentoCT;
import t4j.app.model.Tarefa;
import t4j.app.model.TipoRegimento;
import t4j.app.model.User;

public class Mapper {

    public static User UserInfoDTO2User(UserInfoDTO uidto) {
        User u = new User();
        u.setEmail(uidto.getEmail());
        u.setUsername(uidto.getUsername());
        u.setRoles(uidto.getRolenames());
        return u;
    }

    public static UserInfoDTO colaboradorDTO2UserInfoDTO(
            ColaboradorDTO gestorDTO, String rolesString) {
        UserInfoDTO uidto = new UserInfoDTO();
        uidto.setUsername(gestorDTO.getEmail());
        uidto.setEmail(gestorDTO.getEmail());
        uidto.setRolenames(rolesString);

        return uidto;
    }

// Organização ////////////////////////////////////////
    public static RegistoOrganizacoesDTO listOrganizacao2OrganizacaoDTO(
            ArrayList<Organizacao> organizacoes) throws NullPointerException {
        ArrayList<OrganizacaoDTO> organizacoesDTO = new ArrayList<>();
        for (Organizacao org : organizacoes) {
            try {
                OrganizacaoDTO odto = organizacao2OrganizacaoDTO(org);
                organizacoesDTO.add(odto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        RegistoOrganizacoesDTO rodto = new RegistoOrganizacoesDTO();
        rodto.setOrganizacoes(organizacoesDTO);
        return rodto;
    }

    public static Organizacao organizacaoDTO2Organizacao(OrganizacaoDTO odto) {
        /*
        private String nome;
    private long nif;
    private String website;
    private long telefone;
    private String email;
    private EnderecoPostal endereco;
    private Colaborador gestor;
    private ArrayList<Colaborador> colaboradores;
    private ListaTarefas listaTarefas;

         */

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

        // TODO RegistoDeTarefas - organizacaoDTO2Organizacao
        return org;
    }

    public static OrganizacaoDTO organizacao2OrganizacaoDTO(Organizacao org) {

//    private String nome;
//    private long nif;
//    private String website;
//    private long telefone;
//    private String email;
//    private EnderecoPostal endereco;
//    private Colaborador gestor;
//    private ArrayList<Colaborador> colaboradores;
//    private ListaTarefas listaTarefas;
        /**
         *
         */
        OrganizacaoDTO odto = new OrganizacaoDTO();
        odto.setNomeOrganizacao(org.getNome());
        odto.setNifOrganizacao(org.getNif());
        odto.setWebsiteOrganizacao(org.getWebsite());
        odto.setTelefoneOrganizacao(org.getTelefone());
        odto.setEmailOrganizacao(org.getEmail());

        // Endereço
        /**
         *
         */
        EnderecoPostalDTO epdto = new EnderecoPostalDTO();
        epdto.setCodPostal(org.getEndereco().getCodigoPostal());
        epdto.setLocalidade(org.getEndereco().getLocalidade());
        epdto.setMorada(org.getEndereco().getMorada());
        odto.setEnderecoPostalDTO(epdto);

        // Gestor
        /**
         *
         */
        ColaboradorDTO gestorDTO = new ColaboradorDTO();
        gestorDTO = colaborador2ColaboradorDTO(org.getGestor());
        odto.setGestorDTO(gestorDTO);

        // Colaboradores
        /**
         *
         */
        ArrayList<ColaboradorDTO> listaColaboradoresDTOs = new ArrayList<>();
        for (Colaborador colaborador : org.getColaboradores()) {
            ColaboradorDTO colaboradorDTO = colaborador2ColaboradorDTO(
                    colaborador);
            listaColaboradoresDTOs.add(colaboradorDTO);
        }
        odto.setColaboradores(listaColaboradoresDTOs);

        //TODO Lista de Tarefas DTO e Métodos de Conversão
        return odto;
    }

// Area de Atividade ////////////////////////////////////////
    /**
     *
     * @param atividades
     * @return
     * @throws NullPointerException
     */
    public static RegistoAreasAtividadesDTO listAtividade2AreaAtividadeDTO(
            ArrayList<AreaAtividade> atividades) throws NullPointerException {
        ArrayList<AreaAtividadeDTO> atividadesDTO = new ArrayList<>();
        for (AreaAtividade org : atividades) {
            try {
                AreaAtividadeDTO aadto = areaAtividade2AreaAtividadeDTO(org);
                atividadesDTO.add(aadto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        RegistoAreasAtividadesDTO raadto = new RegistoAreasAtividadesDTO();
        raadto.setAtividades(atividadesDTO);
        return raadto;
    }

    /**
     *
     * @param areaAtividade
     * @return
     */
    public static AreaAtividadeDTO areaAtividade2AreaAtividadeDTO(
            AreaAtividade areaAtividade) {
        AreaAtividadeDTO areaDTO = new AreaAtividadeDTO();
        areaDTO.setCodigo(areaAtividade.getCodigoAreaAtividade());
        areaDTO.setDescBreve(areaAtividade.getDescricaoBreve());
        areaDTO.setDescDetalhada(areaAtividade.getDescricaoDetalhada());
        return areaDTO;
    }

    /**
     *
     * @param areaAtividadeDTO
     * @return
     */
    public static AreaAtividade areaAtividadeDTO2AreaAtividade(
            AreaAtividadeDTO areaAtividadeDTO) {
        AreaAtividade area = new AreaAtividade();
        area.setCodigoAreaAtividade(areaAtividadeDTO.getCodigo());
        area.setDescricaoBreve(areaAtividadeDTO.getDescBreve());
        area.setDescricaoDetalhada(areaAtividadeDTO.getDescDetalhada());
        return area;
    }

// Endereço Postal  ////////////////////////////////////////
    /**
     *
     * @param enderecoPostal
     * @return
     */
    public static EnderecoPostalDTO enderecoPostal2enderecoPostalDTO(
            EnderecoPostal enderecoPostal) {
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
    public static EnderecoPostal enderecoPostalDTO2enderecoPostal(
            EnderecoPostalDTO enderecoPostalDTO) {
        EnderecoPostal ep = new EnderecoPostal();
        ep.setMorada(enderecoPostalDTO.getMorada());
        ep.setCodigoPostal(enderecoPostalDTO.getCodPostal());
        ep.setLocalidade(enderecoPostalDTO.getLocalidade());
        ep.setId(enderecoPostalDTO.getId());
        return ep;
    }

// Categoria ////////////////////////////////////////
    /**
     *
     * @param categorias
     * @return
     * @throws NullPointerException
     */
    public static RegistoCategoriasDTO listCategoria2CategoriaDTO(
            ArrayList<CategoriaTarefa> categorias) throws NullPointerException {
        ArrayList<CategoriaTarefaDTO> categoriasDTO = new ArrayList<>();
        for (CategoriaTarefa org : categorias) {
            try {
                CategoriaTarefaDTO cdto = categoria2CategoriaDTO(org);
                categoriasDTO.add(cdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        RegistoCategoriasDTO rcdto = new RegistoCategoriasDTO();
        rcdto.setCategorias(categoriasDTO);
        return rcdto;
    }

    /**
     *
     * @param categoria
     * @return
     * @throws NullPointerException
     */
    public static CategoriaTarefaDTO categoria2CategoriaDTO(
            CategoriaTarefa categoria) throws NullPointerException {
        CategoriaTarefaDTO categoriaDTO = new CategoriaTarefaDTO();
        categoriaDTO.setIdCategoria(String.valueOf(categoria.getIdCategoria()));
        categoriaDTO.setDescricao(categoria.getDescricaoCategoria());

        AreaAtividadeDTO areaAtividadeDTO = areaAtividade2AreaAtividadeDTO(
                categoria.getAreaAtividade());
        categoriaDTO.setAreaAtividade(areaAtividadeDTO);

        ArrayList<CaraterCompetenciaTecnicaDTO> cctdtos = new ArrayList<>();
        for (CaraterCompetenciaTecnica caraterCompetenciaTecnica : categoria.getListaCaraterCompetenciaTecnica()) {
            CaraterCompetenciaTecnicaDTO cctdto = caraterCT2CaraterCTDTO(caraterCompetenciaTecnica);
            cctdtos.add(cctdto);
        }
        categoriaDTO.setCaraterCompetenciaTecnica(cctdtos);
        return categoriaDTO;

    }

    public static CategoriaTarefa categoriaDTO2Categoria(
            CategoriaTarefaDTO categoriaDTO) throws NullPointerException {
        CategoriaTarefa categoria = new CategoriaTarefa();

        AreaAtividade areaAtividade = areaAtividadeDTO2AreaAtividade(
                categoriaDTO.getAreaAtividade());

//        ArrayList<CaraterCompetenciaTecnica> cts = new ArrayList<>();
        ArrayList<CaraterCompetenciaTecnica> cts
                = listCaraterCompetenciaTecnicaDTO2CaraterCompetenciaTecnica(
                        categoriaDTO.getCaraterCompetenciaTecnica());

        categoria.setAreaAtividade(areaAtividade);
        categoria.setIdCategoria(
                (categoriaDTO.getIdCategoria() != null && !categoriaDTO.getIdCategoria().isEmpty())
                ? Long.parseLong(categoriaDTO.getIdCategoria())
                : null
        );
        categoria.setDescricaoCategoria(categoriaDTO.getDescricao());
        categoria.setListaCaraterCompetenciaTecnica(cts);
        return categoria;
    }

// Competência Técnica ////////////////////////////////////////
    public static CompetenciaTecnicaDTO competenciaTecnica2CompetenciaTecnicaDTO(
            CompetenciaTecnica competenciaTecnica) throws NullPointerException {
        CompetenciaTecnicaDTO competenciaTecnicaDTO
                = new CompetenciaTecnicaDTO();
        competenciaTecnicaDTO.setCodigoCompetenciaTecnica(competenciaTecnica.
                getCodigoCompetenciaTecnica());
        competenciaTecnicaDTO.setDescricaoBreve(competenciaTecnica.
                getDescricaoBreve());
        competenciaTecnicaDTO.setDescricaoDetalhada(competenciaTecnica.
                getDescricaoDetalhada());
        AreaAtividadeDTO atDTO = areaAtividade2AreaAtividadeDTO(
                competenciaTecnica.getAreaAtividade());
        competenciaTecnicaDTO.setAreaAtividade(atDTO);
        RegistoGrausProficienciaDTO grausDTO = listGrau2GrauDTO(
                competenciaTecnica.getGrausProficiencia());
        competenciaTecnicaDTO.setGrausProficiencia(grausDTO.
                getGrausProficiencia());
        return competenciaTecnicaDTO;
    }

    /**
     *
     * @param ctDTO
     * @return
     * @throws NullPointerException
     */
    public static CompetenciaTecnica competenciaTecnicaDTO2CompetenciaTecnica(
            CompetenciaTecnicaDTO ctDTO) throws NullPointerException {
        CompetenciaTecnica ct = new CompetenciaTecnica();
        ct.setCodigoCompetenciaTecnica(ctDTO.getCodigoCompetenciaTecnica());
        ct.setDescricaoBreve(ctDTO.getDescricaoBreve());
        ct.setDescricaoDetalhada(ctDTO.getDescricaoDetalhada());
        AreaAtividade at = areaAtividadeDTO2AreaAtividade(ctDTO.
                getAreaAtividade());
        ct.setAreaAtividade(at);
        ArrayList<GrauProficiencia> graus = listGrauDTO2Grau(ctDTO.
                getGrausProficiencia());
        ct.setGrausProficiencia(graus);
        return ct;
    }

    /**
     *
     * @param listaCT
     * @return
     * @throws NullPointerException
     */
    public static RegistoCompetenciasTecnicasDTO listCompetenciasTecnicas2CompetenciasTecnicasDTO(
            ArrayList<CompetenciaTecnica> listaCT) throws NullPointerException {
        ArrayList<CompetenciaTecnicaDTO> listaCTDTO = new ArrayList<>();
        for (CompetenciaTecnica ct : listaCT)
            try {
            listaCTDTO.add(competenciaTecnica2CompetenciaTecnicaDTO(ct));
        } catch (NullPointerException e) {
            // Does nothing
        }
        RegistoCompetenciasTecnicasDTO regCTDTO
                = new RegistoCompetenciasTecnicasDTO();
        regCTDTO.setCompetenciasTecnicas(listaCTDTO);
        return regCTDTO;
    }

// Graus de Proficiência ////////////////////////////////////////
    /**
     *
     * @param grau
     * @return
     */
    public static GrauProficienciaDTO grau2GrauDTO(GrauProficiencia grau) {
        GrauProficienciaDTO grauDTO = new GrauProficienciaDTO();
        grauDTO.setId(String.valueOf(grau.getId()));
        grauDTO.setValor(grau.getValorGrauProficiencia());
        grauDTO.setDesignacao(grau.getDesignacaoGrauProficiencia());
        return grauDTO;
    }

    /**
     *
     * @param grauDTO
     * @return
     */
    public static GrauProficiencia grauDTO2Grau(GrauProficienciaDTO grauDTO) {
        GrauProficiencia grau = new GrauProficiencia();
        grau.setId((grauDTO.getId() == null) ? null : Long.parseLong(grauDTO.getId()));
        grau.setValorGrauProficiencia(grauDTO.getValor());
        grau.setDesignacaoGrauProficiencia(grauDTO.getDesignacao());
        return grau;
    }

    /**
     *
     * @param graus
     * @return
     * @throws NullPointerException
     */
    public static RegistoGrausProficienciaDTO listGrau2GrauDTO(
            List<GrauProficiencia> graus) throws NullPointerException {
        ArrayList<GrauProficienciaDTO> grausDTO = new ArrayList<>();
        for (GrauProficiencia grau : graus)
            try {
            GrauProficienciaDTO grauproficienciaDTO = grau2GrauDTO(grau);
            grausDTO.add(grauproficienciaDTO);
        } catch (NullPointerException e) {
            // Does nothing
        }
        RegistoGrausProficienciaDTO registoGrausProficienciaDTO
                = new RegistoGrausProficienciaDTO();
        registoGrausProficienciaDTO.setGrausProficiencia(grausDTO);
        return registoGrausProficienciaDTO;
    }

    /**
     *
     * @param grausDTO
     * @return
     * @throws NullPointerException
     */
    public static ArrayList<GrauProficiencia> listGrauDTO2Grau(
            ArrayList<GrauProficienciaDTO> grausDTO) throws NullPointerException {
        ArrayList<GrauProficiencia> graus = new ArrayList<>();
        for (GrauProficienciaDTO grauDTO : grausDTO)
            try {
            GrauProficiencia grauProficiencia = grauDTO2Grau(grauDTO);
            graus.add(grauProficiencia);
        } catch (NullPointerException e) {
            // Does nothing
        }
        return new ArrayList<GrauProficiencia>(graus);
    }

// Tarefa ////////////////////////////////////////
    /**
     *
     * @param tarefas
     * @return
     * @throws NullPointerException
     */
    public static RegistoTarefasDTO listTarefa2TarefaDTO(
            ArrayList<Tarefa> tarefas) throws NullPointerException {
        ArrayList<TarefaDTO> tarefasDTO = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            try {
                TarefaDTO tarefaDTO = tarefa2TarefaDTO(tarefa);
                tarefasDTO.add(tarefaDTO);
            } catch (NullPointerException e) {     //does nothing. Actually, nothing is added to arraylist
            }
        }
        RegistoTarefasDTO rtdto = new RegistoTarefasDTO();
        rtdto.setTarefas(tarefasDTO);
        return rtdto;
    }

    /**
     *
     * @param tarefa
     * @return
     * @throws NullPointerException
     */
    public static TarefaDTO tarefa2TarefaDTO(Tarefa tarefa) throws
            NullPointerException {
        TarefaDTO tdto = new TarefaDTO();
        tdto.setReferencia(tarefa.getReferencia());
        tdto.setDesignacao(tarefa.getDesignacao());
        tdto.setDescricaoInformal(tarefa.getDescricaoInformal());
        tdto.setDescricaoTecnica(tarefa.getDescricaoTecnica());
        tdto.setDuracaoEstimada(tarefa.getDuracaoEstimada());
        tdto.setCustoEstimado(tarefa.getCustoEstimado());
        CategoriaTarefaDTO categoriaDTO = categoria2CategoriaDTO(tarefa.
                getCategoria());
        tdto.setCategoria(categoriaDTO);
        tdto.setEmailColaborador(tarefa.getEmailColaborador());
        tdto.setNifOrganizacao(tarefa.getNifOrganizacao());
        return tdto;
    }

    /**
     *
     * @param tarefaDTO
     * @return
     * @throws NullPointerException
     */
    public static Tarefa tarefaDTO2Tarefa(TarefaDTO tarefaDTO) throws
            NullPointerException {
        Tarefa tarefa = null;
        CategoriaTarefa categoria = categoriaDTO2Categoria(tarefaDTO.
                getCategoria());
        Colaborador colaborador = colaboradorDTO2Colaborador(tarefaDTO.getColaborador());
        tarefa = new Tarefa();
        tarefa.setCategoria(categoria);
        tarefa.setCustoEstimado(tarefaDTO.getCustoEstimado());
        tarefa.setDescricaoInformal(tarefaDTO.getDescricaoInformal());
        tarefa.setDescricaoTecnica(tarefaDTO.getDescricaoTecnica());
        tarefa.setDesignacao(tarefaDTO.
                getDesignacao());
        tarefa.setDuracaoEstimada(tarefaDTO.
                getDuracaoEstimada());
        tarefa.setReferencia(tarefaDTO.getReferencia());
        tarefa.setEmailColaborador(tarefaDTO.getEmailColaborador());
        tarefa.setNifOrganizacao(tarefaDTO.getNifOrganizacao());

        return tarefa;
    }

// Colaborador  ////////////////////////////////////////
    /**
     *
     * @param colaboradores
     * @return
     * @throws NullPointerException
     */
    public static RegistoColaboradoresDTO listColaborador2ColaboradorDTO(
            ArrayList<Colaborador> colaboradores) throws NullPointerException {
        ArrayList<ColaboradorDTO> colaboradoresDTO = new ArrayList<>();
        for (Colaborador col : colaboradores) {
            try {
                ColaboradorDTO colaboradorDTO = colaborador2ColaboradorDTO(col);
                colaboradoresDTO.add(colaboradorDTO);
            } catch (NullPointerException e) {     //does nothing. Actually, nothing is added to arraylist
            }
        }
        RegistoColaboradoresDTO lista = new RegistoColaboradoresDTO();
        lista.setColaboradores(colaboradoresDTO);
        return lista;
    }

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
    public static ColaboradorDTO colaborador2ColaboradorDTO(
            Colaborador colaborador) throws NullPointerException {
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
    public static Colaborador colaboradorDTO2Colaborador(
            ColaboradorDTO colaboradorDTO) throws NullPointerException {
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
    public static UserInfoDTO colaboradorDTO2UserInfoDTO(
            ColaboradorDTO gestorDTO) {
        UserInfoDTO u = new UserInfoDTO();
        u.setEmail(gestorDTO.getEmail());
        u.setUsername(gestorDTO.getEmail());
        u.setNifOrganizacao(gestorDTO.getNifOrganizacao());
        return u;
    }

// Carater Competencia Tecnica ////////////////////////////////////////
    private static CaraterCompetenciaTecnica caraterCTDTO2CaraterCT(CaraterCompetenciaTecnicaDTO caraterCompetenciaTecnicaDTO) {
        CaraterCompetenciaTecnica cct = new CaraterCompetenciaTecnica();
        cct.setObrigatorio(caraterCompetenciaTecnicaDTO.isObrigatorio());
        GrauProficiencia gp = grauDTO2Grau(caraterCompetenciaTecnicaDTO.getGrauProficiencia());
        cct.setGrauProficiencia(gp);
        CompetenciaTecnica ct = competenciaTecnicaDTO2CompetenciaTecnica(caraterCompetenciaTecnicaDTO.getCompetenciaTecnica());
        cct.setCompetenciaTecnica(ct);
        return cct;
    }

    private static ArrayList<CaraterCompetenciaTecnica> listCaraterCompetenciaTecnicaDTO2CaraterCompetenciaTecnica(ArrayList<CaraterCompetenciaTecnicaDTO> caraterCompetenciaTecnicaDTOs) {
        ArrayList<CaraterCompetenciaTecnica> cts = new ArrayList<>();
        for (CaraterCompetenciaTecnicaDTO caraterCompetenciaTecnicaDTO : caraterCompetenciaTecnicaDTOs) {
            try {
                CaraterCompetenciaTecnica ct = caraterCTDTO2CaraterCT(caraterCompetenciaTecnicaDTO);
                cts.add(ct);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return cts;
    }

    private static CaraterCompetenciaTecnicaDTO caraterCT2CaraterCTDTO(
            CaraterCompetenciaTecnica caraterCompetenciaTecnica) {
        CaraterCompetenciaTecnicaDTO cctdto = new CaraterCompetenciaTecnicaDTO();
        CompetenciaTecnicaDTO ctdto = competenciaTecnica2CompetenciaTecnicaDTO(
                caraterCompetenciaTecnica.getCompetenciaTecnica());
        cctdto.setCompetenciaTecnica(ctdto);

        Optional<GrauProficiencia> optGP = Optional.ofNullable(caraterCompetenciaTecnica.getGrauProficiencia());
        if (optGP.isPresent()) {
            cctdto.setGrauProficiencia(Mapper.grau2GrauDTO(optGP.get()));
        }
        GrauProficienciaDTO gpdto;

        cctdto.setObrigatorio(caraterCompetenciaTecnica.isObrigatorio());

        return cctdto;
    }

    // Candidatura ////////////////////////////////////////
    public static CandidaturaDTO candidatura2CandidaturaDTO(Candidatura cd) {
        CandidaturaDTO cddto = new CandidaturaDTO();
        LocalDateDTO dataCandidaturaDTO = data2DataDTO(cd.getDataCandidatura());
        cddto.setId(cd.getId());
        cddto.setDataCandidatura(dataCandidaturaDTO);
        cddto.setValorPretendido((cd.getValorPretendido() == null) ? null : String.valueOf(cd.getValorPretendido()));
        cddto.setNrDias(cd.getNrDias());
        cddto.setTxtApresentacao(cd.getTxtApresentacao());
        cddto.setTxtMotivacao(cd.getTxtMotivacao());
        cddto.setRefAnuncio(cd.getRefAnuncio());
        cddto.setEmailFreelancer(cd.getEmailFreelancer());
        cddto.setClassificacao((cd.getClassificacao() == null) ? null : String.valueOf(cd.getClassificacao()));
        cddto.setEmailColaboradorClassificou(cd.getEmailColaboradorClassificou());
        return cddto;
    }

    public static Candidatura candidaturaDTO2Candidatura(CandidaturaDTO cddto) {
        Candidatura cd = new Candidatura();
        LocalDate dataCandidatura = dataDTO2Data(cddto.getDataCandidatura());
        cd.setId(cddto.getId());
        cd.setDataCandidatura(dataCandidatura);
        cd.setValorPretendido((cddto.getValorPretendido() == null) ? null : String.valueOf(cddto.getValorPretendido()));
        cd.setNrDias(cddto.getNrDias());
        cd.setTxtApresentacao(cddto.getTxtApresentacao());
        cd.setTxtMotivacao(cddto.getTxtMotivacao());
        cd.setRefAnuncio(cddto.getRefAnuncio());
        cd.setEmailFreelancer(cddto.getEmailFreelancer());
        cd.setClassificacao((cddto.getClassificacao()==null ? null : Integer.parseInt(cddto.getClassificacao())));
        cd.setEmailColaboradorClassificou(cddto.getEmailColaboradorClassificou());
        return cd;
    }

    public static ArrayList<CandidaturaDTO> listCandidaturas2ListCandidaturasDTO(ArrayList<Candidatura> candidaturas) throws NullPointerException {
        ArrayList<CandidaturaDTO> candidaturasDTO = new ArrayList<>();
        for (Candidatura candidatura : candidaturas) {
            try {
                CandidaturaDTO cdto = candidatura2CandidaturaDTO(candidatura);
                candidaturasDTO.add(cdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return candidaturasDTO;
    }

    // Data ////////////////////////////////////////
    public static LocalDateDTO data2DataDTO(LocalDate data) throws NullPointerException {
        LocalDateDTO datadto = new LocalDateDTO();
        datadto.setLocalDate(data);
        return datadto;
    }

    public static LocalDate dataDTO2Data(LocalDateDTO datadto) throws NullPointerException {
        LocalDate data = datadto.getLocalDate();
        return data;
    }

    // Anúncio ////////////////////////////////////////
    public static AnuncioDTO anuncio2AnuncioDTO(Anuncio anuncio) throws NullPointerException {
        AnuncioDTO anunciodto = new AnuncioDTO();
        anunciodto.setReferenciaTarefa(anuncio.getReferencia());
        LocalDateDTO datadtoRa = data2DataDTO(anuncio.getDataRegistoAnuncio());
        LocalDateDTO datadtoIp = data2DataDTO(anuncio.getDataInicioPublicitacao());
        LocalDateDTO datadtoFp = data2DataDTO(anuncio.getDataFimPublicitacao());
        LocalDateDTO datadtoIc = data2DataDTO(anuncio.getDataInicioCandidatura());
        LocalDateDTO datadtoFc = data2DataDTO(anuncio.getDataFimCandidatura());
        LocalDateDTO datadtoIs = data2DataDTO(anuncio.getDataInicioSeriacao());
        LocalDateDTO datadtoFs = data2DataDTO(anuncio.getDataFimSeriacao());
        anunciodto.setDataRegistoAnuncio(datadtoRa);
        anunciodto.setDataInicioPublicitacao(datadtoIp);
        anunciodto.setDataFimPublicitacao(datadtoFp);
        anunciodto.setDataInicioCandidatura(datadtoIc);
        anunciodto.setDataFimCandidatura(datadtoFc);
        anunciodto.setDataInicioSeriacao(datadtoIs);
        anunciodto.setDataFimSeriacao(datadtoFs);
        anunciodto.setIdTipoRegimento(anuncio.getIdTipoRegimento());
        return anunciodto;
    }

    public static Anuncio anuncioDTO2Anuncio(AnuncioDTO anuncioDTO) throws NullPointerException {
        Anuncio anuncio = new Anuncio();
        anuncio.setReferencia(anuncioDTO.getReferenciaTarefa());
        LocalDate dataRa = dataDTO2Data(anuncioDTO.getDataRegistoAnuncio());
        LocalDate dataIp = dataDTO2Data(anuncioDTO.getDataInicioPublicitacao());
        LocalDate dataFp = dataDTO2Data(anuncioDTO.getDataFimPublicitacao());
        LocalDate dataIc = dataDTO2Data(anuncioDTO.getDataInicioCandidatura());
        LocalDate dataFc = dataDTO2Data(anuncioDTO.getDataFimCandidatura());
        LocalDate dataIs = dataDTO2Data(anuncioDTO.getDataInicioSeriacao());
        LocalDate dataFs = dataDTO2Data(anuncioDTO.getDataFimSeriacao());
        anuncio.setDataRegistoAnuncio(dataRa);
        anuncio.setDataInicioPublicitacao(dataIp);
        anuncio.setDataFimPublicitacao(dataFp);
        anuncio.setDataInicioCandidatura(dataIc);
        anuncio.setDataFimCandidatura(dataFc);
        anuncio.setDataInicioSeriacao(dataIs);
        anuncio.setDataFimSeriacao(dataFs);
        anuncio.setIdTipoRegimento(anuncioDTO.getIdTipoRegimento());
        return anuncio;
    }

    public static ArrayList<AnuncioDTO> listAnuncios2ListAnunciosDTO(ArrayList<Anuncio> anuncios) throws NullPointerException {
        ArrayList<AnuncioDTO> anunciosDTO = new ArrayList<>();
        for (Anuncio anuncio : anuncios) {
            try {
                AnuncioDTO adto = anuncio2AnuncioDTO(anuncio);
                anunciosDTO.add(adto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return anunciosDTO;
    }

    public static ArrayList<Anuncio> listAnunciosDTO2ListAnuncios(ArrayList<AnuncioDTO> anunciosDTO) throws NullPointerException {
        ArrayList<Anuncio> anuncios = new ArrayList<>();
        for (AnuncioDTO anuncioDTO : anunciosDTO) {
            try {
                Anuncio anuncio = anuncioDTO2Anuncio(anuncioDTO);
                anuncios.add(anuncio);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return anuncios;
    }

// Tipo Regimento ////////////////////////////////////////
    public static TipoRegimentoDTO tipoRegimento2TipoRegimentoDTO(TipoRegimento tipoRegimento) {
        TipoRegimentoDTO tipoRegimentodto = new TipoRegimentoDTO();
        tipoRegimentodto.setId(tipoRegimento.getId());
        tipoRegimentodto.setDesignacao(tipoRegimento.getDesignacao());
        tipoRegimentodto.setDescricaoRegras(tipoRegimento.getDescricaoRegras());
        return tipoRegimentodto;
    }

    public static TipoRegimento tipoRegimentoDTO2TipoRegimento(TipoRegimentoDTO tipoRegimentoDTO) {
        TipoRegimento tipoRegimento = new TipoRegimento();
        tipoRegimento.setId(tipoRegimentoDTO.getId());
        tipoRegimento.setDesignacao(tipoRegimentoDTO.getDesignacao());
        tipoRegimento.setDescricaoRegras(tipoRegimentoDTO.getDescricaoRegras());
        return tipoRegimento;
    }

    public static RegistoTiposRegimentoDTO registoTiposRegimento2RegistoTiposRegimentoDTO(ArrayList<TipoRegimento> tiposRegimento) throws NullPointerException {
        ArrayList<TipoRegimentoDTO> tiposRegimentoDTO = new ArrayList<>();
        for (TipoRegimento tipoRegimento : tiposRegimento) {
            try {
                TipoRegimentoDTO trdto = tipoRegimento2TipoRegimentoDTO(tipoRegimento);
                tiposRegimentoDTO.add(trdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        RegistoTiposRegimentoDTO rtrdto = new RegistoTiposRegimentoDTO();
        rtrdto.setTiposRegimento(tiposRegimentoDTO);
        return rtrdto;
    }

    public static ArrayList<TipoRegimento> registoTiposRegimentoDTO2RegistoTipoRegimento(ArrayList<TipoRegimentoDTO> tiposRegimentoDTO) throws NullPointerException {
        ArrayList<TipoRegimento> tiposRegimento = new ArrayList<>();
        for (TipoRegimentoDTO tipoRegimentoDTO : tiposRegimentoDTO) {
            try {
                TipoRegimento tipoRegimento = tipoRegimentoDTO2TipoRegimento(tipoRegimentoDTO);
                tiposRegimento.add(tipoRegimento);

            } catch (NullPointerException e) {

            }
        }
        return tiposRegimento;
    }

    // Classificação ////////////////////////////////////////
    public static ClassificacaoDTO classificacao2ClassificacaoDTO(Classificacao classificacao) {
        ClassificacaoDTO classificacaoDTO = new ClassificacaoDTO();
        classificacaoDTO.setId(classificacao.getId());
        classificacaoDTO.setIdProcessoSeriacao(classificacao.getIdProcessoSeriacao());
        classificacaoDTO.setIdCandidaturaVencedora(classificacao.getIdCandidaturaVencedora());
        return classificacaoDTO;
    }

    public static Classificacao classificacaoDTO2Classificacao(ClassificacaoDTO classificacaoDTO) {
        Classificacao classificacao = new Classificacao();
        classificacao.setId(classificacaoDTO.getId());
        classificacao.setIdProcessoSeriacao(classificacaoDTO.getIdProcessoSeriacao());
        classificacao.setIdCandidaturaVencedora(classificacaoDTO.getIdCandidaturaVencedora());
        return classificacao;
    }

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

    // Processo Seriação ////////////////////////////////////////
    public static ProcessoSeriacaoDTO processoSeriacao2ProcessoSeriacaoDTO(ProcessoSeriacao processoSeriacao) {
        ProcessoSeriacaoDTO processoSeriacaoDTO = new ProcessoSeriacaoDTO();
        processoSeriacaoDTO.setId(processoSeriacao.getId());
        processoSeriacaoDTO.setReferenciaAnuncio(processoSeriacao.getReferenciaAnuncio());
        LocalDateDTO dataDTO = data2DataDTO(processoSeriacao.getDataRealizacao());
        processoSeriacaoDTO.setDataRealizacao(dataDTO);
        return processoSeriacaoDTO;
    }

    public static ProcessoSeriacao processoSeriacaoDTO2ProcessoSeriacao(ProcessoSeriacaoDTO processoSeriacaoDTO) {
        ProcessoSeriacao processoSeriacao = new ProcessoSeriacao();
        processoSeriacao.setId(processoSeriacaoDTO.getId());
        processoSeriacao.setReferenciaAnuncio(processoSeriacaoDTO.getReferenciaAnuncio());
        LocalDate data = dataDTO2Data(processoSeriacaoDTO.getDataRealizacao());
        processoSeriacao.setDataRealizacao(data);
        return processoSeriacao;
    }

    public static ArrayList<ProcessoSeriacaoDTO> listProcessoSeriacao2ListProcessoSeriacaoDTO(ArrayList<ProcessoSeriacao> processosSeriacao) throws NullPointerException {
        ArrayList<ProcessoSeriacaoDTO> processosSeriacaoDTO = new ArrayList<>();
        for (ProcessoSeriacao processoSeriacao : processosSeriacao) {
            try {
                ProcessoSeriacaoDTO psdto = processoSeriacao2ProcessoSeriacaoDTO(processoSeriacao);
                processosSeriacaoDTO.add(psdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return processosSeriacaoDTO;
    }

    public static ArrayList<ProcessoSeriacao> listProcessoSeriacaoDTODTO2ListProcessoSeriacao(ArrayList<ProcessoSeriacaoDTO> processosSeriacaoDTO) throws NullPointerException {
        ArrayList<ProcessoSeriacao> processosSeriacao = new ArrayList<>();
        for (ProcessoSeriacaoDTO processoSeriacaoDTO : processosSeriacaoDTO) {
            try {
                ProcessoSeriacao processoSeriacao = processoSeriacaoDTO2ProcessoSeriacao(processoSeriacaoDTO);
                processosSeriacao.add(processoSeriacao);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return processosSeriacao;
    }




    public static RegistoFreeLancersDTO listFreeLancer2FreeLancerDTO(
            ArrayList<FreeLancer> freeLancers) throws NullPointerException {
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
    public static FreeLancerDTO freeLancer2FreeLancerDTO(
            FreeLancer freeLancer) throws NullPointerException {
        FreeLancerDTO flto = new FreeLancerDTO();
        flto.setNome(freeLancer.getNome());
        flto.setNif(freeLancer.getNif());
        flto.setEmail(freeLancer.getEmail());
        flto.setTelefone(freeLancer.getTelefone());
        flto.setEndereco(Mapper.enderecoPostal2enderecoPostalDTO(freeLancer.getEndereco()));
        List<HabilitacaoAcademicaDTO> habilitacoesDTO = new ArrayList();
        for (HabilitacaoAcademica habilitacoe : freeLancer.getHabilitacoes()) {
            habilitacoesDTO.add(Mapper.habilitacaoAcademica2HabilitacaoAcademicaDTO(habilitacoe));
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
    public static FreeLancer freeLancerDTO2FreeLancer(
            FreeLancerDTO freeLancerDto) throws NullPointerException {
        FreeLancer freeLancer = null;
        freeLancer = new FreeLancer();
        freeLancer.setNome(freeLancerDto.getNome());
        freeLancer.setNif(freeLancerDto.getNif());
        freeLancer.setEmail(freeLancerDto.getEmail());
        freeLancer.setTelefone(freeLancerDto.getTelefone());
        freeLancer.setEndereco(Mapper.enderecoPostalDTO2enderecoPostal(freeLancerDto.getEndereco()));
        return freeLancer;
    }

    public static UserInfoDTO freeLancerDTO2UserInfoDTO(
            FreeLancerDTO freeLancerDTO) {
        UserInfoDTO u = new UserInfoDTO();
        u.setEmail(freeLancerDTO.getEmail());
        u.setUsername(freeLancerDTO.getEmail());
        return u;
    }


    // HabilitacaoAcademica ////////////////////////////////////////
    public static HabilitacaoAcademicaDTO habilitacaoAcademica2HabilitacaoAcademicaDTO(
            HabilitacaoAcademica habilitacaoAcademica) throws NullPointerException {
        HabilitacaoAcademicaDTO habilitacaoAcademicaDTO
                = new HabilitacaoAcademicaDTO();
                habilitacaoAcademicaDTO.setId(Long.toString(habilitacaoAcademica.getId()));
        habilitacaoAcademicaDTO.setGrau(habilitacaoAcademica.
                getGrau());
        habilitacaoAcademicaDTO.setDesignacaocurso(habilitacaoAcademica.
                getDesignacaocurso());
         habilitacaoAcademicaDTO.setNomeinstituicao(habilitacaoAcademica.
                getNomeinstituicao());
            habilitacaoAcademicaDTO.setMediacurso(habilitacaoAcademica.
                getMediacurso());

            ;
        return habilitacaoAcademicaDTO;
    }

    /**
     *
     * @param haDTO
     * @return
     * @throws NullPointerException
     */
    public static HabilitacaoAcademica habilitacaoAcademicaDTO2HabilitacaoAcademica(
            HabilitacaoAcademicaDTO haDTO) throws NullPointerException {
        HabilitacaoAcademica ha = new HabilitacaoAcademica();
        ha.setDesignacaoCurso(haDTO.getDesignacaocurso());
        ha.setGrau(haDTO.getGrau());
        ha.setMediaCurso(haDTO.getMediacurso());
        ha.setNomeInstituicao(haDTO.getNomeinstituicao());
        ha.setNomeInstituicao(haDTO.getNomeinstituicao());
        ha.setId((haDTO.getId() == null) ? null : Long.parseLong(haDTO.getId()));
        return ha;
    }

     // ReconhecimentoCT////////////////////////////////////////
    public static ReconhecimentoCTDTO reconhecimentoCT2ReconhecimentoCTDTO(
            ReconhecimentoCT reconhecimentoCT) throws NullPointerException {
        ReconhecimentoCTDTO reconhecimentoCTDTO
                = new ReconhecimentoCTDTO();
                reconhecimentoCTDTO.setId(Long.toString(reconhecimentoCT.getId()));
        reconhecimentoCTDTO.setCodigocompetenciatecnica(reconhecimentoCT.
                getCodigocompetenciatecnica());
        reconhecimentoCTDTO.setEmailfreelancer(reconhecimentoCT.
                getEmailfreelancer());
         reconhecimentoCTDTO.setIdgrauproficiencia(reconhecimentoCT.
                getIdgrauproficiencia());
            reconhecimentoCTDTO.setDatareconhecimento(reconhecimentoCT.
                getDatareconhecimento());

        return reconhecimentoCTDTO;
    }

    /**
     *
     * @param rctDTO
     * @return
     * @throws NullPointerException
     */
    public static ReconhecimentoCT reconhecimentoCTDTO2ReconhecimentoCT(
            ReconhecimentoCTDTO rctDTO) throws NullPointerException {
        ReconhecimentoCT rct = new ReconhecimentoCT();
        rct.setCodigoCompetenciaTecnica(rctDTO.getCodigocompetenciatecnica());
        rct.setDataReconhecimento(rctDTO.getDatareconhecimento());
        rct.setEmailFreelancer(rctDTO.getEmailfreelancer());
        rct.setIdGrauProficiencia(rctDTO.getIdgrauproficiencia());
        rct.setId(Long.parseLong(rctDTO.getId()));
        return rct;
    }

}

