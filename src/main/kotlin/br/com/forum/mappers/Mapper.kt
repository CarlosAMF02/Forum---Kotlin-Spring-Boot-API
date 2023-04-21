package br.com.forum.mappers

interface Mapper<T, U> {
    fun map(t: T): U
}
