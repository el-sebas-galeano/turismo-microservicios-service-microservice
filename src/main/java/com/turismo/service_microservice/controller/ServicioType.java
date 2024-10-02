package com.turismo.service_microservice.controller;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import static graphql.Scalars.GraphQLString;
import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLFloat;

public class ServicioType {

    public static final GraphQLObjectType type = newObject()
            .name("Servicio")
            .field(GraphQLFieldDefinition.newFieldDefinition().name("id").type(GraphQLInt))
            .field(GraphQLFieldDefinition.newFieldDefinition().name("nombre").type(GraphQLString))
            .field(GraphQLFieldDefinition.newFieldDefinition().name("descripcion").type(GraphQLString))
            .field(GraphQLFieldDefinition.newFieldDefinition().name("precio").type(GraphQLFloat))
            .field(GraphQLFieldDefinition.newFieldDefinition().name("ubicacion").type(GraphQLString))
            .field(GraphQLFieldDefinition.newFieldDefinition().name("fechaInicio").type(GraphQLString))
            .field(GraphQLFieldDefinition.newFieldDefinition().name("fechaFin").type(GraphQLString))
            .field(GraphQLFieldDefinition.newFieldDefinition().name("categoria").type(CategoriaType.type))
            .build();
}