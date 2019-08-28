package swapi.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Planets extends EntityList {
    @Getter
    @Setter
    private Planet[] results;
}
