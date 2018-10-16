package com.servo.ktorexample

import com.servo.ktorexample.graphql.VersionDataFetcher
import com.google.gson.Gson
import graphql.GraphQL
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.log
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.default
import io.ktor.http.content.static
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import org.koin.ktor.ext.inject

@Suppress("unused")
fun Application.routes() {
    routing {
        val gson: Gson by inject()
        val graph: GraphQL by inject()

        graphql(log, gson, graph)

        static("/") {
            default("index.html")
        }

    }
}