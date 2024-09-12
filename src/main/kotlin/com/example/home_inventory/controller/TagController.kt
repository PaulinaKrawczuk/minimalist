package com.example.home_inventory.controller

import com.example.home_inventory.model.Tag
import com.example.home_inventory.service.TagService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tags")
class TagController(private val tagService: TagService) {
    @GetMapping
    fun getAllTags(): ResponseEntity<List<Tag>> {
        return ResponseEntity.ok(tagService.getAllTags())
    }

    @PostMapping
    fun createTag(@RequestBody tag: Tag): ResponseEntity<Tag> {
        val savedTag = tagService.createTag(tag)
        return ResponseEntity(savedTag, HttpStatus.CREATED)
    }
}