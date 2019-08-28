package swapi.model;

public enum EntityType {
    PEOPLE,
    PLANETS,
    FILMS,
    STARSHIPS,
    VEHICLES,
    SPECIES;

    @Override
    public String toString() {
        switch(this) {
            case PEOPLE: return "people";
            case PLANETS: return "planets";
            case FILMS: return "films";
            case STARSHIPS: return "starships";
            case VEHICLES: return "vehicles";
            case SPECIES: return "species";
            default: throw new IllegalArgumentException();
        }
    }
}
