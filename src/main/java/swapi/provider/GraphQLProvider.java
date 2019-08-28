package swapi.provider;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;
import swapi.model.EntityType;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    private GraphQLDataFetcher dataFetcher;

    @PostConstruct
    public void init() throws IOException {
        final Resource resource = new ClassPathResource("schema.graphql");
        String sdl = null;
        try {
            sdl = new String(Files.readAllBytes(resource.getFile().toPath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("person", dataFetcher.getById(EntityType.PEOPLE)))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("planet", dataFetcher.getById(EntityType.PLANETS)))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("film", dataFetcher.getById(EntityType.FILMS)))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("starship", dataFetcher.getById(EntityType.STARSHIPS)))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("vehicle", dataFetcher.getById(EntityType.VEHICLES)))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("species", dataFetcher.getById(EntityType.SPECIES)))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("people", dataFetcher.getFirstTen(EntityType.PEOPLE)))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("planets", dataFetcher.getFirstTen(EntityType.PLANETS)))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("films", dataFetcher.getFirstTen(EntityType.FILMS)))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("starships", dataFetcher.getFirstTen(EntityType.STARSHIPS)))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("vehicles", dataFetcher.getFirstTen(EntityType.VEHICLES)))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("speciesList", dataFetcher.getFirstTen(EntityType.SPECIES)))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}
