package apps.sstarzak.playground.session

import apps.sstarzak.core.session.TokenStore
import com.orhanobut.hawk.Hawk
import javax.inject.Inject

class TokenStoreImpl @Inject constructor() : TokenStore {
    override var accessToken: String
        get() = Hawk.get(KEY_ACCESS_TOKEN, VALUE_INITIAL)
        set(value) {
            Hawk.put(KEY_ACCESS_TOKEN, value)
        }

    override var refreshToken: String
        get() = Hawk.get(KEY_REFRESH_TOKEN, VALUE_INITIAL)
        set(value) {
            Hawk.put(KEY_REFRESH_TOKEN, value)
        }

    override fun clear() {
        accessToken = VALUE_INITIAL
        refreshToken = VALUE_INITIAL
    }

    override fun isValid(): Boolean = accessToken != VALUE_INITIAL && refreshToken != VALUE_INITIAL

    companion object {
        const val KEY_ACCESS_TOKEN = "TokenStore:Token"
        const val KEY_REFRESH_TOKEN = "TokenStore:Refresh"
        const val VALUE_INITIAL = ""
    }
}