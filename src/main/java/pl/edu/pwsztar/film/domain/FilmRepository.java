package pl.edu.pwsztar.film.domain;

import org.springframework.data.repository.Repository;
import pl.edu.pwsztar.film.dto.FilmNotFoundException;
import java.util.List;

interface FilmRepository extends Repository<Film, Long> {

    Film save(Film film);
    Film findById(Long id);
    void deleteById(Long id);
    List<Film> findAll();

    default Film findOneOrThrow(Long id) {
        Film film = findById(id);
        if(film == null) {
            throw new FilmNotFoundException(id);
        }
        return film;
    }
}
