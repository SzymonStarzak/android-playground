package apps.sstarzak.auth.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import apps.sstarzak.core.di.AuthScope
import javax.inject.Inject
import javax.inject.Provider

@AuthScope
@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory
@Inject constructor(private val creators: Map<Class<out ViewModel>,
        @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?:
            creators.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value ?:
            throw IllegalArgumentException("Unknown ViewModel class " + modelClass)

        return try { creator.get() as T }
        catch (e: Exception) { throw RuntimeException(e) }
    }
}