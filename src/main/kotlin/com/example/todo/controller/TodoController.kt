package com.example.todo.controller

import com.example.todo.domain.Todo
import com.example.todo.repository.TodoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
// 本当はServiceからRepositoryを使う方が良いけど面倒なのでここから
class TodoController(private val repository : TodoRepository) {

    @GetMapping
    fun index() = ResponseEntity.ok(repository.findAll())

    @PostMapping
    fun create(@RequestBody todo: Todo) = ResponseEntity.ok(repository.save(todo))

    @PutMapping("{id}")
    fun done(@PathVariable(value = "id") id: Int) : ResponseEntity<String> {
        val todo : Todo = repository.findById(id).get()
        todo.finished = true
        repository.save(todo)
        return ResponseEntity.ok("success")
    }

    @DeleteMapping("{id}")
    fun destroy(@PathVariable(value = "id") id: Int) : ResponseEntity<String> {
        repository.deleteById(id)
        return ResponseEntity.ok("success")
    }
}