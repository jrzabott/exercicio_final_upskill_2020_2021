package api.converter;

import api.DTO.LocalDateTimeDTO;
import api.DTO.SessionsDTO;
import static api.converter.LocalDateTimeConverter.data2DataDTO;
import static api.converter.LocalDateTimeConverter.dataDTO2Data;
import api.model.Sessions;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SessionsConverter {

    public static SessionsDTO sessions2SessionsDTO(Sessions sessions) throws NullPointerException {
        SessionsDTO sessionsDTO = new SessionsDTO();
        sessionsDTO.setId(sessions.getId());
        LocalDateTimeDTO ldtdto = data2DataDTO(sessions.getLoginDate());
        sessionsDTO.setLogin_date(ldtdto);
        sessionsDTO.setContext_id(sessions.getIdContext());
        sessionsDTO.setUser_id(sessions.getIdUser());
        return sessionsDTO;
    }

    public static Sessions sessionsDTO2Sessions(SessionsDTO sessionsDTO) throws NullPointerException {
        Sessions sessions = new Sessions();
        sessions.setId(sessionsDTO.getId());
        LocalDateTime ldt = dataDTO2Data(sessionsDTO.getLogin_date());
        sessions.setLoginDate(ldt);
        sessions.setIdContext(sessionsDTO.getContext_id());
        sessions.setIdUser(sessionsDTO.getUser_id());
        return sessions;
    }
    
    public static ArrayList<SessionsDTO> listSessions2ListSessionsDTO(ArrayList<Sessions> sessions) throws NullPointerException {
        ArrayList<SessionsDTO> sessionsDTO = new ArrayList<>();
        for (Sessions session : sessions) {
            try {
                SessionsDTO sdto = sessions2SessionsDTO(session);
                sessionsDTO.add(sdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return sessionsDTO;
    }

    public static ArrayList<Sessions> listSessionsDTO2ListSessions(ArrayList<SessionsDTO> sessionsDTO) throws NullPointerException {
        ArrayList<Sessions> sessions = new ArrayList<>();
        for (SessionsDTO sessionDTO : sessionsDTO) {
            try {
                Sessions s = sessionsDTO2Sessions(sessionDTO);
                sessions.add(s);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return sessions;
    }
}
