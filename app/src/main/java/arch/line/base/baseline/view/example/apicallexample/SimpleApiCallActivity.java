package arch.line.base.baseline.view.example.apicallexample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import javax.inject.Inject;

import arch.line.base.baseline.R;
import arch.line.base.baseline.databinding.ActivityExampleExpressionBindingBinding;
import arch.line.base.baseline.model.ExampleDataModel;
import arch.line.base.baseline.repository.ImdbRespository;
import arch.line.base.baseline.repository.api.ImdbApi;
import arch.line.base.baseline.utility.api.Resource;
import arch.line.base.baseline.view.BaseActivity;
import arch.line.base.baseline.viewmodel.example.SimpleApiCallViewModel;

public class SimpleApiCallActivity extends BaseActivity {
    ActivityExampleExpressionBindingBinding dataBinding;

    @Inject
    ImdbApi mImdbApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_example_expression_binding);
        ((BaseApplication)getApplication()).getAppComponent().inject(this);
        loadData();
    }

    private void loadData() {
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
        ImdbRespository imdbRespository= new ImdbRespository(mImdbApi);
        imdbRespository.loadData("22e16c99", "tt3896198").observe(this, exampleDataModelResource -> {
            if (exampleDataModelResource != null) {
                switch (exampleDataModelResource.status) {
                    case SUCCESS:
                        ExampleDataModel exampleDataModel = new ExampleDataModel();
                        assert exampleDataModelResource.data != null;
                        exampleDataModel.Id = exampleDataModelResource.data.Title!=null?exampleDataModelResource.data.Title:"api";
                        dataBinding.setExampleDataModel(exampleDataModel);
                        break;
                    case ERROR:
                        Toast.makeText(SimpleApiCallActivity.this, "Error ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
