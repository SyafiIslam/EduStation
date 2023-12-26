package com.syafi.edustation.domain.usecase.auth

import com.syafi.edustation.data.UserRepository
import com.syafi.edustation.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(email: String, password: String): Flow<Resource<String>> {
        return repository.login(email, password)
    }
}