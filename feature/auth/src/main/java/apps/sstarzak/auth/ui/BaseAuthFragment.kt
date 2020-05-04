package apps.sstarzak.auth.ui

import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import apps.sstarzak.auth.di.AuthComponentProvider
import apps.sstarzak.core.ui.BaseFragment
import javax.inject.Inject

abstract class BaseAuthFragment(@LayoutRes contentLayoutId: Int) : BaseFragment(contentLayoutId) {

    @Inject
    lateinit var authViewModelFactory: ViewModelProvider.Factory

    val authComponentProvider: AuthComponentProvider by lazy {
        (requireActivity().application as AuthComponentProvider)
    }
}