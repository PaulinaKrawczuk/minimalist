package com.example.home_inventory.model

import jakarta.persistence.*

@Entity
class Action (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true, nullable = false)
    val actionType: String
)