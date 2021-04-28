package pl.edu.pwsztar.film.domain;

import pl.edu.pwsztar.film.dto.FilmDto;
import static java.util.Objects.requireNonNull;

class FilmCreator {

    Film from(FilmDto filmDto) {
        requireNonNull(filmDto);
        return Film.builder()
                .title(filmDto.getTitle())
                .id(filmDto.getId())
                .build();
    }
}
