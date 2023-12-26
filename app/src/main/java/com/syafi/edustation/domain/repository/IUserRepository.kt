package com.syafi.edustation.domain.repository

import com.syafi.edustation.util.Resource
import kotlinx.coroutines.flow.Flow

interface IUserRepository {

    suspend fun login(email: String, password: String): Flow<Resource<String>>
}