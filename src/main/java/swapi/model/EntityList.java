package swapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
abstract class EntityList {
    @Getter
    @Setter
    private int count;
    @Getter
    @Setter
    private String next, previous;
}
