package swapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Getter
    @Setter
    private String title, director, producer, url, created, edited;

    @Getter
    @Setter
    private String[] species, starships, vehicles, characters, planets;

    @Getter
    @Setter
    @JsonProperty("opening_crawl")
    private String openingCrawl;

    @Getter
    @Setter
    @JsonProperty("episode_id")
    private int episodeId;

    @Getter
    @Setter
    @JsonProperty("release_date")
    private String releaseDate;

}
