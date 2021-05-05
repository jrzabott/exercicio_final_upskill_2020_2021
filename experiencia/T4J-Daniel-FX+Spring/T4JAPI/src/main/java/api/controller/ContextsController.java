package api.controller;

import api.DTO.ContextsDTO;
import api.service.ContextsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ContextsController {
    
    @Autowired
    private ContextsService contextsService;

    public ContextsDTO getContext(String app_key) {
        return contextsService.getContext(app_key);
    }
}
