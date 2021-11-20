package id.buaja.team

data class UiState<T>(
    val data: T? = null,
    val loading: Boolean = false,
    val error: String = ""
) {
    val failedLoading: Boolean
        get() = !loading && data == null
}
