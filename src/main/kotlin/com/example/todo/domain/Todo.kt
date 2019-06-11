package com.example.todo.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Todo {
    @Id
    @GeneratedValue
    val id: Int? = null
    var title: String? = null
    var description: String? = null
    var finished: Boolean? = false
}