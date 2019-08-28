package swapi.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class SpeciesList extends EntityList {
    @Getter
    @Setter
    private Species[] results;
}
