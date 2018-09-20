package arch.line.base.baseline.viewmodel.example;

import android.arch.lifecycle.ViewModel;

public class SimpleApiCallViewModel extends ViewModel {
    /*//@Inject
    private ImdbRespository imdbRespository = new ImdbRespository();

    public  LiveData<Resource<ExampleDataModel>> getMovie(String key, String id){
        LiveData<Resource<ExampleDataModel>> t = null;
        MutableLiveData<String[]> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(new String[]{key, id});
        return Transformations.switchMap(mutableLiveData,input -> imdbRespository.loadData(input[0],input[1]));
    }*/
}
