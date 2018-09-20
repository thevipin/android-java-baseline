package arch.line.base.baseline.view.example.apicallexample;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import arch.line.base.baseline.repository.ImdbRespository;
import arch.line.base.baseline.view.BaseActivity;
import arch.line.base.baseline.viewmodel.example.SimpleApiCallViewModel;

public class SimpleApiCallActivity extends BaseActivity {
    SimpleApiCallViewModel simpleApiCallViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simpleApiCallViewModel = ViewModelProviders.of(this).get(SimpleApiCallViewModel.class);


    }

    private void loadData(){
        /*simpleApiCallViewModel.("","").observe(this, exampleDataModelResource -> {
            switch (exampleDataModelResource.status)
            {
                case LOADING: //show loading
                    //exampleDataModelResource.data
                    break;
                case SUCCESS: // display value
                    break;
                case ERROR: //error
                    break;
            }
        });*/
        ImdbRespository imdbRespository = new ImdbRespository();
        imdbRespository.loadData()
    }
}
