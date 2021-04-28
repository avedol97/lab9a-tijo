package pl.edu.pwsztar.film.dto;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(Long id) {
        super("No film of id " + id + " found", null, false, false);
    }
}
