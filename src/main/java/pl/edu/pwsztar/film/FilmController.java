package pl.edu.pwsztar.film;

import org.springframework.web.bind.annotation.*;
import pl.edu.pwsztar.film.domain.FilmFacade;
import pl.edu.pwsztar.film.dto.FilmDto;

import java.util.List;

@RestController
class FilmController {

    private final FilmFacade filmFacade;

    FilmController(FilmFacade filmFacade) {
        this.filmFacade = filmFacade;
    }

    @GetMapping("/api/films")
    List<FilmDto> getFilms() {
        return filmFacade.findAll();
    }

    @GetMapping("/api/films/{id}")
    FilmDto getFilm(@PathVariable Long id) {
        return filmFacade.show(id);
    }

    @DeleteMapping("/api/films/{ids}")
    void deleteFilm(@PathVariable Long[] ids) {
        filmFacade.delete(ids);
    }

    @PostMapping("/api/films")
    FilmDto addFilm(@RequestBody FilmDto filmDto) {
        return filmFacade.add(filmDto);
    }

    @PutMapping("/api/films/{id}")
    FilmDto updateFilm(@RequestBody FilmDto filmDto, @PathVariable Long id) {
        return filmFacade.update(filmDto.toBuilder().id(id).build());
    }
}
