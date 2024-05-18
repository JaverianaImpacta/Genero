package edu.javeriana.ingenieria.social.genero.servicio;

import edu.javeriana.ingenieria.social.genero.dominio.Genero;
import edu.javeriana.ingenieria.social.genero.repositorio.RepositorioGenero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioGenero {
    @Autowired
    private RepositorioGenero repositorio;

    public List<Genero> obtenerGeneros() {
        return repositorio.findAll();
    }

    public Genero obtenerGenero(String sigla){
        return repositorio.findOneBySigla(sigla);
    }

    public boolean generoExiste(String sigla){
        return repositorio.existsBySigla(sigla);
    }
}
