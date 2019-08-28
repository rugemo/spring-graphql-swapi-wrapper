package swapi.model;

import lombok.*;

@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class People extends EntityList {
    @Getter
    @Setter
    private Person[] results;
}
