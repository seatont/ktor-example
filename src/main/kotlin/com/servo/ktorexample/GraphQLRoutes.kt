package com.servo.ktorexample

import com.servo.ktorexample.graphql.VersionDataFetcher
import com.google.gson.Gson
import graphql.ExecutionResult
import graphql.GraphQL
import io.ktor.application.call
import io.ktor.locations.Location
import io.ktor.locations.post
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import org.koin.ktor.ext.inject
import org.slf4j.Logger

@Location("/graphql")
data class GraphQLRequest(val query: String = "", val variables: Map<String, Any> = emptyMap())


fun Route.graphql(log: Logger, gson: Gson, graph: GraphQL) {
    val graph: GraphQL by inject()

    post<GraphQLRequest> {
        val request = call.receive<GraphQLRequest>()
        val executionResult = graph.execute(request.query)
        call.respond(executionResult)
    }
}