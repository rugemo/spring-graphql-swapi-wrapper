package swapi.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Starships extends EntityList {
    @Getter
    @Setter
    private Starship[] results;
}
