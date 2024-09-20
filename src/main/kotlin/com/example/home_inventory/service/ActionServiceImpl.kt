package com.example.home_inventory.service

import com.example.home_inventory.model.Action
import com.example.home_inventory.repository.ActionRepository

class ActionServiceImpl( private val actionRepository: ActionRepository): ActionService {
    override fun findByActionType(actionType: String): Action? {
        return actionRepository.findByActionType(actionType)
    }

    override fun getAllActions(): List<Action> {
        return actionRepository.findAll()
    }

    override fun createAction(action: Action): Long? {
        val existingAction = actionRepository.findByActionType(action.actionType)
        if (existingAction != null) {
           throw IllegalArgumentException("Action with this type already exists")
        }
       val newAction =  actionRepository.save(action)
        return newAction.id
    }
}