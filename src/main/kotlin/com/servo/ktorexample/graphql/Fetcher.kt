package com.servo.ktorexample.graphql

import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.slf4j.LoggerFactory




class VersionDataFetcher : DataFetcher<String> {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun get(environment: DataFetchingEnvironment?): String {
        log.info("Lets look at the environment eh? ${environment.toString()}")
        return "1.0.0"
    }
}