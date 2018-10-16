package com.servo.ktorexample

import com.servo.ktorexample.di.ktorContextModule
import com.servo.ktorexample.graphql.VersionDataFetcher
import graphql.schema.idl.RuntimeWiring
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.application.log
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.locations.Locations
import org.koin.core.Koin
import org.koin.core.Koin.Companion.logger
import org.koin.log.Logger.SLF4JLogger
import org.koin.log.PrintLogger
import org.koin.standalone.StandAloneContext.startKoin
import org.slf4j.Logger
import graphql.schema.StaticDataFetcher




@Suppress("unused")
fun Application.main() {

    Koin.logger = SLF4JLogger()
    startKoin(listOf(ktorContextModule))

    install(DefaultHeaders)
    install(CallLogging)
    install(Locations)
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    log.info("Application setup Complete!")
}

