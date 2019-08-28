package swapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    @Getter
    @Setter
    private String name, diameter, climate, gravity, terrain, population, created, edited, url;

    @Getter
    @Setter
    @JsonProperty("rotation_period")
    private String rotationPeriod;
    @Getter
    @Setter
    @JsonProperty("orbital_period")
    private String orbitalPeriod;
    @Getter
    @Setter
    @JsonProperty("surface_water")
    private String surfaceWater;

    @Getter
    @Setter
    private String[] residents, films;
}
