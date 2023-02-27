package com.example.dontgetbored.domain.usecases

import com.example.dontgetbored.domain.model.BoredActivityModel
import com.example.dontgetbored.domain.repository.BoredActivityRepository
import com.example.dontgetbored.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBoredActivityUseCase @Inject constructor(
    private val repository: BoredActivityRepository
) {
    operator fun invoke(): Flow<Resource<BoredActivityModel>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(
                data = repository.getRandomActivity()
            ))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(e.message ?: "An Error occurred while making the request."))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(e.message ?: "An unknown error occurred."))
        }
    }
}