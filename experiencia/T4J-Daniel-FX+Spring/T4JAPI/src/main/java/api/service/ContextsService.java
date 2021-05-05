package api.service;

import api.DTO.ContextsDTO;
import api.converter.ContextsConverter;
import api.dao.AppKeyDAO;
import api.dao.ContextsDAO;
import api.dao.SessionsDAO;
import api.model.Contexts;
import exception.ContextoInvalidoException;
import exception.ConversaoException;
import exception.ElementoInvalidoException;
import exception.NoRollbackException;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContextsService {

    @Autowired
    ContextsDAO cdao;
    @Autowired
    AppKeyDAO akdao;
    @Autowired
    SessionsDAO sdao;

    public ContextsService() {
    }

    @Transactional
    public ContextsDTO getContext(String app_key) {
        if (akdao.countAppKeyByAppKey(app_key) == 0) {
            throw new ElementoInvalidoException("AppKey inválida.");
        }
        Contexts context = new Contexts();
        context.setDataCriacao(LocalDateTime.now());
        context.setContext(cdao.createContext());
        context.setValido("Y");
        context = cdao.save(context);
        ContextsDTO contextDTO = ContextsConverter.contexts2ContextsDTO(context);
        if (contextDTO == null) {
            throw new ConversaoException("ContextsDTO");
        }
        return contextDTO;
    }

    @Transactional(noRollbackFor = NoRollbackException.class)
    public boolean validaContextAndSession(String app_context) {
        if (cdao.checkIfContextIsValid(app_context) == null || "N".equals(cdao.checkIfContextIsValid(app_context))) {
            throw new ContextoInvalidoException("Contexto inválido");
        }
        if (sdao.checkIfSessionIsValid(cdao.getIdByContext(app_context)) != 1) {
            cdao.invalidateContext(cdao.getIdByContext(app_context));
            throw new NoRollbackException("Não existe sessão válida para este contexto");
        }
        return true;
    }
}
