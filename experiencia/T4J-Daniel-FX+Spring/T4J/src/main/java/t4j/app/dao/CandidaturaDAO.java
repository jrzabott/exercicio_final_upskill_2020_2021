package t4j.app.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import t4j.app.model.Candidatura;

public interface CandidaturaDAO extends JpaRepository<Candidatura, Long> {

    /**
     *
     * @param emailColaborador
     * @return
     */
    @Query(value = "SELECT a.DATAREGISTOANUNCIO, a.DATAINICIOPUBLICACAO, "
            + "a.DATAFIMPUBLICACAO, a.DATAINICIOCANDIDATURA, a.DATAFIMCANDIDATURA, "
            + "a.DATAINICIOSERIACAO, a.DATAFIMSERIACAO, a.REFERENCIA_TAREFA, "
            + "a.ID_TIPO_REGIMENTO "
            + "FROM anuncio a LEFT JOIN tarefa t on a.REFERENCIA_TAREFA = t.REFERENCIA "
            + "WHERE SYSDATE BETWEEN a.DATAINICIOSERIACAO AND a.DATAFIMSERIACAO "
            + "AND t.EMAIL_COLABORADOR = :email", nativeQuery = true)
    public List<Object> anunciosEmPeriodoSeriacao(@Param("email") String emailColaborador);

    /**
     *
     * @param referencia
     * @return
     */
    @Query(value = "SELECT c.ID "
            + "FROM candidatura c JOIN anuncio a on a.REFERENCIA_TAREFA = c.REFERENCIA_ANUNCIO "
            + "WHERE a.REFERENCIA_TAREFA = :referenciaanuncio", nativeQuery = true)
    public List<Long> candidaturasEmPeriodoSeriacao(@Param("referenciaanuncio") String referencia);

    /**
     *
     * @param referencia
     * @return
     */
    @Query(value = "SELECT a.ID_TIPO_REGIMENTO "
            + "FROM anuncio a "
            + "WHERE a.REFERENCIA_TAREFA = :referenciaanuncio", nativeQuery = true)
    public Long idTipoRegimentoByCandidatura(@Param("referenciaanuncio") String referencia);

    /**
     *
     * @param emailFreelancer
     * @param classificacao
     * @param emailcolaborador
     * @return
     */
    @Query(value = "UPDATE candidatura "
            + "set CLASSIFICACAO_SERIACAO = :classificacao, EMAIL_COLABORADOR_CLASSIFICOU = :emailcolaborador "
            + "WHERE EMAIL_FREELANCER = :emailfreelancer", nativeQuery = true)
    public boolean updateTabelaCandidatura(@Param("emailfreelancer") String emailFreelancer, @Param("classificacao") Long classificacao, @Param("emailcolaborador") String emailcolaborador);
    
    @Query(value = "SELECT c.ID, c.DATACANDIDATURA, c.VALORPRETENDIDO, c.NRDIAS, c.TXTAPRESENTACAO, "
            + "c.TXTMOTIVACAO, c.REFERENCIA_ANUNCIO, c.EMAIL_FREELANCER, c.CLASSIFICACAO_SERIACAO, c.EMAIL_COLABORADOR_CLASSIFICOU "
            + "FROM candidatura c "
            + "WHERE c.EMAIL_FREELANCER = :email", nativeQuery = true)
    public List<Candidatura> findAllByFreelancer(@Param("email") String emailFreelancer);

}
