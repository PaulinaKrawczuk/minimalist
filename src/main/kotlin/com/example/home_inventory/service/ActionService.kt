package com.example.home_inventory.service

import com.example.home_inventory.model.Action

interface ActionService {

    fun getAllActions(): List<Action>

    fun createAction(action: Action): Long?

    fun findByActionType(actionType: String): Action?
}