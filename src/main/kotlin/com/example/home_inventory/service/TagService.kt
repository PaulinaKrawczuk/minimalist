package com.example.home_inventory.service

import com.example.home_inventory.model.Tag

interface TagService {

    fun getAllTags(): List<Tag>
    fun createTag(tag: Tag): Tag
}