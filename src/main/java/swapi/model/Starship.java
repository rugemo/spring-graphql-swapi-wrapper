package swapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Starship {
    @Getter
    @Setter
    private String name, model, manufacturer, length, crew, passengers, consumables, url, created, edited;

    @Getter
    @Setter
    @JsonProperty("starship_class")
    private String starshipClass;
    @Getter
    @Setter
    @JsonProperty("cost_in_credits")
    private String costInCredits;
    @Getter
    @Setter
    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    @Getter
    @Setter
    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;
    @Getter
    @Setter
    @JsonProperty("MGLT")
    private String mglt;
    @Getter
    @Setter
    @JsonProperty("cargo_capacity")
    private String cargoCapacity;


    @Getter
    @Setter
    private String[] films, pilots;

}
