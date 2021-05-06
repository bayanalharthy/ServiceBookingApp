package com.znggis.sampleservicebookingapp.repo.remote.mapper

abstract class Mapper<in I, out O> {
    abstract fun from(i: I): O
}