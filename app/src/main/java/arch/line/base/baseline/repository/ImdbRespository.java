package arch.line.base.baseline.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;



import arch.line.base.baseline.model.ExampleDataModel;
import arch.line.base.baseline.repository.api.ImdbApi;
import arch.line.base.baseline.utility.api.ApiResponse;
import arch.line.base.baseline.utility.api.AppExecutors;
import arch.line.base.baseline.utility.api.NetworkBoundResource;
import arch.line.base.baseline.utility.api.Resource;



public class ImdbRespository {
    private AppComponent appComponent;

    private ImdbApi mImdbApi;

    public ImdbRespository(ImdbApi mImdbAp) {
        this.mImdbApi = mImdbAp;
    }

    public LiveData<Resource<ExampleDataModel>> loadData(final String key, final String id) {
        return new NetworkBoundResource<ExampleDataModel, ExampleDataModel>(new AppExecutors()) {

            @Override
            protected void saveCallResult(@NonNull ExampleDataModel item) {

            }

            @Override
            protected boolean shouldFetch(@Nullable ExampleDataModel data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<ExampleDataModel> loadFromDb() {
                ExampleDataModel exampleDataModel = new ExampleDataModel();
                exampleDataModel.Title = "db";
                MutableLiveData<ExampleDataModel> lv = new MutableLiveData<>();
                lv.setValue(exampleDataModel);
                return lv;
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<ExampleDataModel>> createCall() {
                return mImdbApi.getUser(key, id);
            }
        }.asLiveData();
    }

}
