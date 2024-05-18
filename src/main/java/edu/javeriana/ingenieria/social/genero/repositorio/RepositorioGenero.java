package edu.javeriana.ingenieria.social.genero.repositorio;

import edu.javeriana.ingenieria.social.genero.dominio.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioGenero extends JpaRepository<Genero, Integer> {
    Genero findOneBySigla(String sigla);

    boolean existsBySigla(String sigla);
}
