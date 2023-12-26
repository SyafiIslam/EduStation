package com.syafi.edustation.data

import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.syafi.edustation.domain.repository.IUserRepository
import com.syafi.edustation.util.Resource
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class UserRepository : IUserRepository {

    val user: FirebaseUser? = null
    val userAuth = FirebaseAuth.getInstance()
    val userDb = FirebaseDatabase
        .getInstance("https://edustation-a834d-default-rtdb.asia-southeast1.firebasedatabase.app/")
        .getReference("Users")

    override suspend fun login(email: String, password: String): Flow<Resource<String>> =
        callbackFlow {
            trySend(Resource.Loading())

            userAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    trySend(Resource.Success("Login Berhasil"))
                }
                .addOnFailureListener {
                    trySend(Resource.Error("Login Gagal/n${it}"))
                }

            awaitClose {
                close()
            }
        }
}