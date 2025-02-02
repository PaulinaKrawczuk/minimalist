package com.example.home_inventory

import com.example.home_inventory.model.Action
import com.example.home_inventory.model.Tag
import com.example.home_inventory.repository.ActionRepository
import com.example.home_inventory.repository.TagRepository
import com.example.home_inventory.service.ActionServiceImpl
import com.example.home_inventory.service.TagServiceImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.test.context.ActiveProfiles

@ExtendWith(MockitoExtension::class)
@ActiveProfiles("test")
class TagsTest {

	@Mock
	lateinit var tagRepository: TagRepository

	@InjectMocks
	lateinit var tagService: TagServiceImpl

	@Test
	fun `should return list of tags`() {
		// Arrange
		val tagList = listOf(
				Tag(1L, "Tag1"),
				Tag(2L, "Tag2")
		)
		`when`(tagRepository.findAll()).thenReturn(tagList)

		// Act
		val result = tagService.getAllTags()

		// Assert
		assertEquals(2, result.size)
		assertEquals("Tag1", result[0].tagName)
	}

	@Test
	fun `should create a new action and return its autogenerated id`() {
		// Arrange
		val tagToSave = Tag(null, "ActionType1")
		val savedTag= Tag(1L, "ActionType1")
		`when`(tagRepository.save(any(Tag::class.java))).thenReturn(savedTag)

		// Act
		val resultId = tagService.createTag(tagToSave)

		// Assert
		assertEquals(1L, resultId)
	}

}
