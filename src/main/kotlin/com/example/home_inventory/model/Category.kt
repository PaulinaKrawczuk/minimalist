package com.example.home_inventory.model

import jakarta.persistence.*

@Entity
class Category(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(unique = true, nullable = false)
        val categoryName: String
)