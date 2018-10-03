package arch.line.base.baseline.repository.api;

import android.arch.lifecycle.LiveData;

import arch.line.base.baseline.model.ExampleDataModel;
import arch.line.base.baseline.utility.api.ApiResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImdbApi {
    @GET(".")
    public LiveData<ApiResponse<ExampleDataModel>> getUser(@Query("apikey") String apiKey, @Query("i") String id);
}
