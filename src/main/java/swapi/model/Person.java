package swapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Getter
    @Setter
    private String name, height, mass, gender, created, edited, homeworld, url;

    @Getter
    @Setter
    @JsonProperty("hair_color")
    private String hairColor;
    @Getter
    @Setter
    @JsonProperty("skin_color")
    private String skinColor;
    @Getter
    @Setter
    @JsonProperty("eye_color")
    private String eyeColor;
    @Getter
    @Setter
    @JsonProperty("birth_year")
    private String birthYear;

    @Getter
    @Setter
    private String[] films, species, vehicles, starships;

}
