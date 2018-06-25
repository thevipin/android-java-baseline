package arch.line.base.baseline.utility.api;

/**
 * Status of a resource that is provided to the UI.
 * <p>
 * <p>
 * These are usually created by the Repository classes where they return
 * `LiveData<Resource<T>>` to pass back the latest data to the UI with its fetch status.
 */

public enum Status {
    SUCCESS,
    ERROR,
    LOADING
}
