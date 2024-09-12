package com.example.home_inventory.controller

import com.example.home_inventory.model.Category
import com.example.home_inventory.repository.CategoryRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categories")
class CategoryController(private val categoryRepository: CategoryRepository) {

    @GetMapping
    fun getAllCategories(): List<Category> = categoryRepository.findAll()

    @PostMapping
    fun createCategory(@RequestBody category: Category): ResponseEntity<Category>{
        val savedCategory = categoryRepository.save(category)
        return ResponseEntity(savedCategory, HttpStatus.CREATED)
    }
}