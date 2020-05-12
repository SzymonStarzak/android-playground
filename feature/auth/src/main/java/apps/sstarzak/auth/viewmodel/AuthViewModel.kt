package apps.sstarzak.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import apps.sstarzak.auth.domain.AuthToken
import apps.sstarzak.auth.domain.UserCredentials
import apps.sstarzak.auth.login.domain.LoginUseCase
import apps.sstarzak.core.common.Event
import apps.sstarzak.core.common.NetworkResult
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

typealias TokenEvent = Event<NetworkResult<AuthToken>>

class AuthViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _authToken = MutableLiveData<TokenEvent>()
    val login: LiveData<TokenEvent> get() = _authToken

    @InternalCoroutinesApi
    internal fun login(credentials: UserCredentials) {
        CoroutineScope(Dispatchers.IO).launch {
            loginUseCase(credentials).collect {
                withContext(Dispatchers.Main) {
                    _authToken.postValue(Event(it))
                }
            }
        }
    }
}