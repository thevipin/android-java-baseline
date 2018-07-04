package arch.line.base.baseline.viewmodel.example;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import arch.line.base.baseline.model.ExampleDataModel;
import arch.line.base.baseline.repository.ImdbRespository;
import arch.line.base.baseline.utility.api.Resource;

public class SimpleApiCallViewModel extends ViewModel {
    @Inject
    private
    ImdbRespository imdbRespository;

    public  LiveData<Resource<ExampleDataModel>> getMovie(String key, String id){
        LiveData<Resource<ExampleDataModel>> t = null;
        MutableLiveData<String[]> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(new String[]{key, id});
        return Transformations.switchMap(mutableLiveData,input -> {
           return imdbRespository.loadData(input[0],input[1]);
        });
    }
}
