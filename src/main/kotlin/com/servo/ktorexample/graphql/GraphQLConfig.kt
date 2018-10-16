package com.servo.ktorexample.graphql

import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import graphql.GraphQL
import java.nio.file.Paths


class GraphQLConfig

fun initializeGraphQL() : GraphQL {
    val schemaParser = SchemaParser()
    val schemaGenerator = SchemaGenerator()

    val schemaFile = Paths.get(GraphQLConfig::class.java.classLoader.getResource("graphql/query.graphqls").toURI()).toFile()
    val typeRegistry = schemaParser.parse(schemaFile)
    val wiring = buildRuntimeWiring()
    val graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, wiring)
    return GraphQL.newGraphQL(graphQLSchema).build()

}

fun buildRuntimeWiring(): RuntimeWiring {

    val versionDataFetcher = VersionDataFetcher()

    return RuntimeWiring.newRuntimeWiring()
        .type("QueryType") { typeWiring -> typeWiring.dataFetcher("version", versionDataFetcher) }
        .build()
}
