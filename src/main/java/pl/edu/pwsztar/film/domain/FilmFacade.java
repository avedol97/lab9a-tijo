package pl.edu.pwsztar.film.domain;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwsztar.film.dto.FilmDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Transactional
public class FilmFacade {
    private final FilmRepository filmRepository;
    private final FilmCreator filmCreator;

    public FilmFacade(FilmRepository filmRepository, FilmCreator filmCreator) {
        this.filmRepository = filmRepository;
        this.filmCreator = filmCreator;
    }

    public FilmDto add(FilmDto filmDto) {
        requireNonNull(filmDto);
        Film film = filmCreator.from(filmDto);
        film =  filmRepository.save(film);
        return film.dto();
    }

    public FilmDto update(FilmDto filmDto) {
        requireNonNull(filmDto);
        Film film = filmRepository.findOneOrThrow(filmDto.getId());
        film =  filmRepository.save(film.toBuilder().title(filmDto.getTitle()).build());
        return film.dto();
    }

    public FilmDto show(Long id) {
        requireNonNull(id);
        Film film = filmRepository.findOneOrThrow(id);
        return film.dto();
    }

    public void delete(Long... ids) {
        requireNonNull(ids);
        Arrays.stream(ids).forEach(filmRepository::deleteById);
    }

    public List<FilmDto> findAll() {

        return filmRepository
                .findAll().stream()
                .map(Film::dto)
                .collect(Collectors.toList());
    }
}
