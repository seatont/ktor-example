package com.servo.ktorexample.di

import com.servo.ktorexample.graphql.VersionDataFetcher
import com.servo.ktorexample.graphql.initializeGraphQL
import com.google.gson.Gson
import org.koin.dsl.module.module

val ktorContextModule = module {
    single { Gson() }
    single { VersionDataFetcher() }
    single { initializeGraphQL() }
    
}