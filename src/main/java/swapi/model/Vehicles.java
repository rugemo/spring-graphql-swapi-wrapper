package swapi.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Vehicles extends EntityList {
    @Getter
    @Setter
    private Vehicle[] results;
}
