package t4j.app.controller.ws;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t4j.app.dto.AnuncioDTO;
import t4j.app.dto.ErroDTO;
import t4j.app.service.AnunciosService;

@RestController
@RequestMapping("/api")
public class AnunciosController {

    private AnunciosService as;
    
//    /**
//     * 
//     * @return o registo de anúncios
//     */
//    @RequestMapping(value = "/anuncios",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getAnuncios() {
//        try {
//            RegistoAnunciosDTO registoTarefasDTO = as.getRegistoAnuncios();
//            if (registoTarefasDTO != null) {
//                return new ResponseEntity<>(registoTarefasDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }

    /**
     * 
     * @param referencia referência do anúncio que se pretende obter
     * @return o anúncio identificado pela sua referência
     */
    @RequestMapping(value = "/anuncios/{referencia}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAnuncio(@PathVariable("referencia") String referencia) {
        try {
            AnuncioDTO anuncioDTO = as.getAnuncio(referencia);
            if (anuncioDTO != null) {
                return new ResponseEntity<>(anuncioDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param anuncioDTO anúncio que se petende adicionar ao registo de anúncios
     * @return adiciona um novo anúncio ao registo de anúncios
     */
    @RequestMapping(value = "/anuncios",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addAnuncio(@RequestBody AnuncioDTO anuncioDTO) {
        try {
            as.addAnuncio(anuncioDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param referencia referência do anúuncio a ser atualizado no registo de anúncios
     * @param anuncioDTO anúncios que vai ser atualizado
     * @return atualizada um determinado anúncio no registo de anúncios identifico pela sua referência de anúncio
     */
    @RequestMapping(value = "/anuncios/{referencia}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateAnuncio(@PathVariable("referencia") String referencia, @RequestBody AnuncioDTO anuncioDTO) {
        try {
            as.updateAnuncio(referencia, anuncioDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param referencia referência do anúncio que se pretende remover do registo de anúncios
     * @return remove um determinado anúncio do registo de anúncios identifico pela sua referência de anúncio
     */
    @RequestMapping(value = "/anuncio/{referencia}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeAnuncio(@PathVariable("referencia") String referencia) {
        try {
            as.removeAnuncio(referencia);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
