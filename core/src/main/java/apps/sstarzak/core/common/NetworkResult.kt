package apps.sstarzak.core.common

import android.util.Log

/** Simple wrapper class to handle states. Consider using [kotlin.Result] in future*/

sealed class NetworkResult<out R> {
    data class Data<out T>(val data: T) : NetworkResult<T>()
    data class Error(val throwable: Throwable) : NetworkResult<Nothing>()
    object Empty : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Data<*> -> "Data[data=$data]"
            is Error -> "Error[exception=$throwable]"
            Empty -> "Empty"
            Loading -> "Loading"
        }
    }
}

object NetworkResultProcessor {
    private const val TAG = "Result"

    fun <T> processNetworkResult(
        networkResult: NetworkResult<T>,
        showProgress: () -> Unit = {},
        hideProgress: () -> Unit = {},
        data: (T) -> Unit = {},
        noData: () -> Unit = {},
        showError: (Throwable) -> Unit = {Log.e(TAG, "showGenericError: ", it)}
    ) {
        when (networkResult) {
            is NetworkResult.Loading -> showProgress()
            is NetworkResult.Data -> {
                hideProgress()
                data(networkResult.data)
            }
            is NetworkResult.Empty -> {
                hideProgress()
                noData()
            }
            is NetworkResult.Error -> {
                hideProgress()
                showError(networkResult.throwable)
            }
        }
    }
}
