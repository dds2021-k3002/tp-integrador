package com.disenio.controller.publicaciones;

import com.disenio.dto.DTOResponse;
import com.disenio.dto.publicacion.DTOPublicacionPerdida;
import com.disenio.model.publicaciones.PublicacionPerdida;
import com.disenio.services.factory.Factory;
import com.disenio.services.mascotas.MascotaFotoService;
import com.disenio.services.mascotas.MascotaRescatadaService;
import com.disenio.services.mascotas.TamanioMascotaService;
import com.disenio.services.mascotas.TipoMascotaService;
import com.disenio.services.personas.PersonaService;
import com.disenio.services.publicaciones.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/publicaciones/perdidas")
public class PublicacionPerdidasController {
    @Autowired
    private PublicacionService publicacionService;
    @Autowired
    private PersonaService personaService;

    @Autowired
    private TamanioMascotaService tamanioMascotaService;
    @Autowired
    private TipoMascotaService tipoMascotaService;
    @Autowired
    private MascotaRescatadaService mascotaService;
    @Autowired
    private MascotaFotoService mascotaFotoService;

    @Autowired
    private Factory<PublicacionPerdida, DTOPublicacionPerdida> factory;


    @PostMapping(path = "/guardar")
    public ResponseEntity<DTOResponse> guardar(HttpServletRequest request, @RequestBody DTOPublicacionPerdida dtoPublicacion) {
        DTOResponse dtoResponse = new DTOResponse();
        ResponseEntity<DTOResponse> response;
        PublicacionPerdida publicacion;
        /* TODO:
            Las publicaciones de perdida se generan apartir de un cuestionario de la vista!

          */
        //Cuestionario cuestionario = request.getSession().getAttribute("cuestionario")
        try {
            publicacion = factory.createFromDTO(dtoPublicacion);
            mascotaService.alta(publicacion.getMascota());
            publicacionService.alta(publicacion);
            //TODO Agregar en la organizacion!
            dtoResponse.setStatus(HttpStatus.CREATED);
            dtoResponse.setMsg("Se creo la publicacion satisfactoriamente");
            response = new ResponseEntity(dtoResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            dtoResponse.setMsg("No se pudo crear la publicacion");
            dtoResponse.setStatus(HttpStatus.NO_CONTENT);
            response = new ResponseEntity(dtoResponse, HttpStatus.NO_CONTENT);
        }

        return response;

    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<DTOResponse> getPublicacionesPerdidasByID(@PathVariable("id") Integer id) {
        DTOResponse dtoResponse = new DTOResponse();

        PublicacionPerdida publicacion = (PublicacionPerdida) publicacionService.getById(id).orElseGet(null);
        DTOPublicacionPerdida dtoPublicacion = new DTOPublicacionPerdida(publicacion);

        if (dtoPublicacion.getMascota() == null || dtoPublicacion.getIdPublicacion() == null || dtoPublicacion.getAutor() == null) {
            dtoResponse.setStatus(HttpStatus.NO_CONTENT);
            dtoResponse.setMsg("No existen publicacion.");
            return ResponseEntity.ok(dtoResponse);
        }
        dtoResponse.setStatus(HttpStatus.OK);
        dtoResponse.setData(dtoPublicacion);
        return ResponseEntity.ok(dtoResponse);
    }


    @GetMapping(path = "/all")
    public ResponseEntity<DTOResponse> getPublicacionesPerdidasAll() {
        DTOResponse response = new DTOResponse();
        List<PublicacionPerdida> publicaciones = publicacionService.listarPerdidas();
        List<DTOPublicacionPerdida> dtoPublicaciones;

        dtoPublicaciones = publicaciones.stream()
                .map(DTOPublicacionPerdida::new)
                .collect(Collectors.toList());

        response.setStatus(HttpStatus.OK);
        response.setData(dtoPublicaciones);


        return ResponseEntity.ok(response);
    }
}
