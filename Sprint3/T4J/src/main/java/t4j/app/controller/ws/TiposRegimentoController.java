package t4j.app.controller.ws;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t4j.app.dto.ErroDTO;
import t4j.app.dto.RegistoTiposRegimentoDTO;
import t4j.app.dto.TipoRegimentoDTO;
import t4j.app.service.TiposRegimentoService;

@RestController
@RequestMapping("/api")
public class TiposRegimentoController {
    
    private TiposRegimentoService trs;
    
    /**
     * 
     * @return o registo de tipos de regimento
     */
    @RequestMapping(value = "/tiposregimento",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTiposRegimento() {
        try {
            RegistoTiposRegimentoDTO registoTiposRegimentoDTO = trs.getRegistoTiposRegimento();
            if (registoTiposRegimentoDTO != null) {
                return new ResponseEntity<>(registoTiposRegimentoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param designacao designação do tipo de regimento que se pretende obter
     * @return o tipo de regimento identificado pela sua designação
     */
    @RequestMapping(value = "/tiposregimento/{designacao}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTipoRegimento(@PathVariable("designacao") String designacao) {
        try {
            TipoRegimentoDTO tipoRegimentoDTO = trs.getTipoRegimento(designacao);
            if (tipoRegimentoDTO != null) {
                return new ResponseEntity<>(tipoRegimentoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param tipoRegimentoDTO tipo de regimento que se pretende adicionar ao registo de tipos de regimento
     * @return adiciona um novo tipo de regimento ao registo de tipos de regimento
     */
    @RequestMapping(value = "/tiposregimento",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTipoRegimento(@RequestBody TipoRegimentoDTO tipoRegimentoDTO) {
        try {
            trs.addTipoRegimento(tipoRegimentoDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param designacao designação do tipo de regimento a ser atualizado no registo de tipos de regimento
     * @param tipoRegimentoDTO tipo de regimento que vai ser atualizado
     * @return atualizada um determinado tipo de regimento no registo de tipos de regimento identifico pela sua designação de tipo de regimento
     */
    @RequestMapping(value = "/tiposregimento/{designacao}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateTipoRegimento(@PathVariable("designacao") String designacao, @RequestBody TipoRegimentoDTO tipoRegimentoDTO) {
        try {
            trs.updateTipoRegimento(designacao, tipoRegimentoDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param designacao designação do tipo de regimento a ser removido no registo de tipos de regimento
     * @return remove um determinado tipo de regimento do registo de tipos de regimento identifico pela sua designação de tipo de regimento
     */
    @RequestMapping(value = "/anuncio/{designacao}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeTipoRegimento(@PathVariable("designacao") String designacao) {
        try {
            trs.removeTipoRegimento(designacao);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
