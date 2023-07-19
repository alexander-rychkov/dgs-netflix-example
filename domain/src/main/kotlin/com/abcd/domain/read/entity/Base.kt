package com.abcd.domain.read.entity

enum class OrderDirection(val direction: String) {
    ASC("ASC"),
    DESC("DESC")
    ;

    companion object {
        fun fromString(str: String): com.abcd.domain.read.entity.OrderDirection {
            return when (str) {
                "ASC" -> com.abcd.domain.read.entity.OrderDirection.ASC
                "DESC" -> com.abcd.domain.read.entity.OrderDirection.DESC
                else -> throw NotImplementedError(str)
            }
        }
    }
}