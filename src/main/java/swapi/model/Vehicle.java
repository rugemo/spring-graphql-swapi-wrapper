package swapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Getter
    @Setter
    private String name, model, manufacturer, length, crew, passengers, consumables, url, created, edited;

    @Getter
    @Setter
    @JsonProperty("vehicle_class")
    private String vehicleClass;
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
    @JsonProperty("cargo_capacity")
    private String cargoCapacity;


    @Getter
    @Setter
    private String[] films, pilots;

}
