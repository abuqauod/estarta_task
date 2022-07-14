package com.estarta.task.domain.util

interface DomainMapper<T, model> {
    fun mapToModel(dto: T): model
}