package arch.line.base.baseline.utility.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static arch.line.base.baseline.utility.api.Status.ERROR;
import static arch.line.base.baseline.utility.api.Status.LOADING;
import static arch.line.base.baseline.utility.api.Status.SUCCESS;

//a generic class that describes a data with a status
public class Resource<T> {
    @NonNull
    public final Status status;
    @Nullable
    public final T data;
    @Nullable
    public final String message;

    private Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }
}

