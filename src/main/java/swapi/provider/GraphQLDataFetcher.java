package swapi.provider;

import swapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import graphql.schema.DataFetcher;
import swapi.model.Person;

@Component
class GraphQLDataFetcher {

    private final String REST_URL = "https://swapi.co/api";

    @Autowired
    private RestTemplate restTemplate;

    DataFetcher<Object> getById(EntityType entityType) {
        switch (entityType){
            case PEOPLE:
                return getSingle(entityType.toString(), Person.class);
            case PLANETS:
                return getSingle(entityType.toString(), Planet.class);
            case FILMS:
                return getSingle(entityType.toString(), Film.class);
            case STARSHIPS:
                return getSingle(entityType.toString(), Starship.class);
            case VEHICLES:
                return getSingle(entityType.toString(), Vehicle.class);
            case SPECIES:
                return getSingle(entityType.toString(), Species.class);
                default:
                    return null;
        }
    }

    DataFetcher<Object> getFirstTen(EntityType entityType){
        switch (entityType){
            case PEOPLE:
                return getListOf(entityType.toString(), People.class);
            case PLANETS:
                return getListOf(entityType.toString(), Planets.class);
            case FILMS:
                return getListOf(entityType.toString(), Films.class);
            case STARSHIPS:
                return getListOf(entityType.toString(), Starships.class);
            case VEHICLES:
                return getListOf(entityType.toString(), Vehicles.class);
            case SPECIES:
                return getListOf(entityType.toString(), SpeciesList.class);
            default:
                return null;
        }
    }

    private DataFetcher<Object> getSingle(String typeEndPoint, Class expectedType) {
        return dataFetchingEnvironment -> restTemplate.getForObject(REST_URL + "/" + typeEndPoint + "/" + dataFetchingEnvironment.getArgument("id"), expectedType);
    }

    private DataFetcher<Object> getListOf(String typeEndPoint, Class expectedType) {
        return dataFetchingEnvironment -> restTemplate.getForObject(REST_URL + "/" + typeEndPoint + "/" + dataFetchingEnvironment.getArgument("queryString"), expectedType);
    }
}

