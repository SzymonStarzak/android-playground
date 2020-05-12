package apps.sstarzak.core.env

sealed class Environment(val loginBaseUrl: String, val notesApiBaseUrl: String) {

    class LocalHost : Environment(
        loginBaseUrl = DEV_MACHINE_LOCAL_HOST_BASE_URL,
        notesApiBaseUrl = DEV_MACHINE_LOCAL_HOST_BASE_URL
    ) {
        companion object {
            private const val DEV_MACHINE_LOCAL_HOST_ADDRESS = "10.0.2.2"
            private const val DEV_MACHINE_LOCAL_HOST_PORT = "8000"
            const val DEV_MACHINE_LOCAL_HOST_BASE_URL =
                "http://$DEV_MACHINE_LOCAL_HOST_ADDRESS:$DEV_MACHINE_LOCAL_HOST_PORT/"
        }
    }
}