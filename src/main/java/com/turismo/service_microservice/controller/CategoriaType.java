package com.turismo.service_microservice.controller;

import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLFieldDefinition;

import static graphql.schema.GraphQLObjectType.newObject;
import static graphql.Scalars.GraphQLString;
import static graphql.Scalars.GraphQLInt;

public class CategoriaType {

    public static final GraphQLObjectType type = newObject()
            .name("Categoria")
            .field(GraphQLFieldDefinition.newFieldDefinition().name("id").type(GraphQLInt))
            .field(GraphQLFieldDefinition.newFieldDefinition().name("nombre").type(GraphQLString))
            .field(GraphQLFieldDefinition.newFieldDefinition().name("descripcion").type(GraphQLString))
            .build();
}
