package arch.line.base.baseline.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;


import arch.line.base.baseline.injection.AppComponent;
import arch.line.base.baseline.model.ExampleDataModel;
import arch.line.base.baseline.repository.api.ImdbApi;
import arch.line.base.baseline.repository.db.DaoInterfaceClass;
import arch.line.base.baseline.utility.api.ApiResponse;
import arch.line.base.baseline.utility.api.AppExecutors;
import arch.line.base.baseline.utility.api.NetworkBoundResource;
import arch.line.base.baseline.utility.api.Resource;



public class ImdbRespository {
    private AppComponent appComponent;

    private ImdbApi mImdbApi;
    private DaoInterfaceClass.ExampleModuleDao mExampleModuleDao;

    public ImdbRespository(ImdbApi mImdbAp, DaoInterfaceClass.ExampleModuleDao mExampleModuleDao) {
        this.mImdbApi = mImdbAp;
        this.mExampleModuleDao = mExampleModuleDao;
    }

    public LiveData<Resource<ExampleDataModel>> loadData(final String key, final String id) {
        return new NetworkBoundResource<ExampleDataModel, ExampleDataModel>(new AppExecutors()) {

            @Override
            protected void saveCallResult(@NonNull ExampleDataModel item) {
                mExampleModuleDao.insert(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable ExampleDataModel data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<ExampleDataModel> loadFromDb() {
                return mExampleModuleDao.getSampleDataModel(id);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<ExampleDataModel>> createCall() {
                return mImdbApi.getUser(key, id);
            }
        }.asLiveData();
    }

}
