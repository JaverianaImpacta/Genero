package edu.javeriana.ingenieria.social.genero.controlador;

import edu.javeriana.ingenieria.social.genero.dominio.Genero;
import edu.javeriana.ingenieria.social.genero.servicio.ServicioGenero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorGenero {
    @Autowired
    private ServicioGenero servicio;

    @GetMapping("listar")
    public List<Genero> obtenerGeneros() {
        return servicio.obtenerGeneros();
    }

    @GetMapping("obtener")
    public ResponseEntity<Genero> obtenerGenero(@RequestParam String sigla) {
        if(sigla == null || sigla.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.generoExiste(sigla)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerGenero(sigla), HttpStatus.OK);
    }
}
