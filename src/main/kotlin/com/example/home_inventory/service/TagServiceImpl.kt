package com.example.home_inventory.service

import com.example.home_inventory.model.Tag
import com.example.home_inventory.repository.TagRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class TagServiceImpl(private val tagRepository: TagRepository) : TagService {

    override fun getAllTags(): List<Tag> = tagRepository.findAll()

    override fun createTag(tag: Tag): Tag {
        return try {
            tagRepository.save(tag)
        } catch (e: DataIntegrityViolationException){
            throw IllegalArgumentException("Tag name must be unique", e)
        }
    }
}