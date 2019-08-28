package swapi.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Films extends EntityList {
    @Getter
    @Setter
    private Film[] results;
}
