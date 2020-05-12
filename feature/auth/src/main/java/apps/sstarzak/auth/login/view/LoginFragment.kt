package apps.sstarzak.auth.login.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import apps.sstarzak.auth.R
import apps.sstarzak.auth.di.AuthComponentProvider
import apps.sstarzak.auth.domain.AuthToken
import apps.sstarzak.auth.domain.UserCredentials
import apps.sstarzak.auth.ext.saveAuthToken
import apps.sstarzak.auth.ui.BaseAuthFragment
import apps.sstarzak.auth.viewmodel.AuthViewModel
import apps.sstarzak.auth.viewmodel.TokenEvent
import apps.sstarzak.core.common.NetworkResultProcessor
import apps.sstarzak.core.session.SessionManager
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

class LoginFragment : BaseAuthFragment(R.layout.fragment_login) {

    @Inject
    lateinit var sessionManager: SessionManager

    private val authViewModel: AuthViewModel by viewModels { authViewModelFactory }

    private val loginObserver = Observer<TokenEvent> { event ->
        event.getContentIfNotHandled()?.let {
            NetworkResultProcessor.processNetworkResult(
                it,
                data = ::processTokenSuccess,
                showError = ::processTokenError
            )
        }
    }

    override fun inject() {
        authComponentProvider.provideAuthComponent().inject(this)
    }

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewModel.login.observe(viewLifecycleOwner, loginObserver)

        login_button.setOnClickListener {
            authViewModel.login(
                UserCredentials(
                    login_edit.text.toString(),
                    password_edit.text.toString()
                )
            )
        }
    }

    private fun processTokenSuccess(authToken: AuthToken) {
        sessionManager.saveAuthToken(authToken)

        (requireActivity().application as AuthComponentProvider).releaseAuthComponent()

        coreNavigation.navigateToNotes(requireContext())
    }

    private fun processTokenError(throwable: Throwable) {
        Toast.makeText(requireContext(), throwable.message, Toast.LENGTH_SHORT).show()
    }
}