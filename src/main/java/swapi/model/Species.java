package swapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Species {
    @Getter
    @Setter
    private String name, classification, designation, language, homeworld, url;

    @Getter
    @Setter
    @JsonProperty("average_height")
    private String averageHeight;
    @Getter
    @Setter
    @JsonProperty("average_lifespan")
    private String averageLifespan;
    @Getter
    @Setter
    @JsonProperty("eye_colors")
    private String eyeColors;
    @Getter
    @Setter
    @JsonProperty("hair_colors")
    private String hairColors;
    @Getter
    @Setter
    @JsonProperty("skin_colors")
    private String skinColors;

    @Getter
    @Setter
    private String[] people, films;

}
