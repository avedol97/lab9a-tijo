package pl.edu.pwsztar.film.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.edu.pwsztar.film.dto.FilmDto;
import javax.persistence.*;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "films")
class Film {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;

    FilmDto dto() {
        return FilmDto.builder()
                .id(this.id)
                .title(this.title)
                .build();
    }
}
