package com.example.home_inventory.repository

import com.example.home_inventory.model.Action
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ActionRepository: JpaRepository<Action, Long> {
    @Query("SELECT a FROM Action a WHERE a.actionType = :actionType")
    fun findByActionType(@Param("actionType") actionType: String): Action?

}