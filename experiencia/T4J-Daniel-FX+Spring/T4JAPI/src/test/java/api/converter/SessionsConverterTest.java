package api.converter;

import api.DTO.SessionsDTO;
import api.model.Sessions;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SessionsConverterTest {
    
    private Sessions s;
    private SessionsDTO sdto;
    private ArrayList<Sessions> sessions;
    private ArrayList<SessionsDTO> sessionsDTO;
    
    public SessionsConverterTest() {
        sessions = new ArrayList<>();
        sessionsDTO = new ArrayList<>();
        s = new Sessions(1L, LocalDateTime.MIN, 1L, 1L);
        sdto = new SessionsDTO();
        LocalDateTime ldt = LocalDateTime.MIN;
        sdto.setId(1L);
        sdto.setLogin_date(LocalDateTimeConverter.data2DataDTO(ldt));
        sdto.setUser_id(1L);
        sdto.setContext_id(1L);
        sessions.add(s);
        sessionsDTO.add(sdto);
    }

    /**
     * Test of sessions2SessionsDTO method, of class SessionsConverter.
     */
    @Test
    public void testSessions2SessionsDTO() {
        System.out.println("users2UsersDTO");
        SessionsDTO result = SessionsConverter.sessions2SessionsDTO(s);
        assertEquals(sdto.toString(), result.toString());
    }

    /**
     * Test of sessionsDTO2Sessions method, of class SessionsConverter.
     */
    @Test
    public void testSessionsDTO2Sessions() {
        System.out.println("usersDTO2Users");
        Sessions result = SessionsConverter.sessionsDTO2Sessions(sdto);
        assertEquals(s.toString(), result.toString());
    }

    /**
     * Test of listSessions2ListSessionsDTO method, of class SessionsConverter.
     */
    @Test
    public void testListSessions2ListSessionsDTO() {
        System.out.println("listSessions2ListSessionsDTO");
        ArrayList<SessionsDTO> result = SessionsConverter.listSessions2ListSessionsDTO(sessions);
        assertEquals(sessionsDTO.contains(sdto.toString()), result.contains(sdto.toString()));
    }

    /**
     * Test of listSessionsDTO2ListSessions method, of class SessionsConverter.
     */
    @Test
    public void testListSessionsDTO2ListSessions() {
        System.out.println("listSessionsDTO2ListSessions");
        ArrayList<Sessions> result = SessionsConverter.listSessionsDTO2ListSessions(sessionsDTO);
        assertEquals(sessions.contains(s.toString()), result.contains(s.toString()));
    }
}
