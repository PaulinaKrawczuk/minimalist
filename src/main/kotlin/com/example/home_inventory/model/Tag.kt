package com.example.home_inventory.model

import jakarta.persistence.*

@Entity
class Tag(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(unique = true, nullable = false)
        val tagName: String
)