package com.turismo.service_microservice.controller;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLList.list;
import static graphql.schema.GraphQLNonNull.nonNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turismo.service_microservice.entity.Servicio;
import com.turismo.service_microservice.service.ServicioService;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;

@Controller
@RequestMapping(path = "/graphql")

public class ServicioGQLController {

        @Autowired
        private ServicioService servicioService;

        @Bean
        public GraphQLSchema schema() {
                DataFetcher<List<Servicio>> buscarServiciosFetcher = dataFetchingEnvironment -> {
                        String keyword = dataFetchingEnvironment.getArgument("keyword");
                        return servicioService.buscarPorPalabrasClave(keyword);
                };

                return GraphQLSchema.newSchema()
                                .query(GraphQLObjectType.newObject()
                                                .name("Query")
                                                .field(GraphQLFieldDefinition.newFieldDefinition()
                                                                .name("buscarServicios")
                                                                .type(list(ServicioType.type))
                                                                .argument(arg -> arg
                                                                                .name("keyword")
                                                                                .type(nonNull(GraphQLString)))
                                                                .dataFetcher(buscarServiciosFetcher))
                                                .build())
                                .build();
        }

        // Si tu aplicación requiere wiring, puedes agregarlo como se muestra aquí
        private RuntimeWiring buildWiring(DataFetcher<List<Servicio>> buscarServiciosFetcher) {
                return RuntimeWiring.newRuntimeWiring()
                                .type(TypeRuntimeWiring.newTypeWiring("Query")
                                                .dataFetcher("buscarServicios", buscarServiciosFetcher))
                                .build();
        }
}
