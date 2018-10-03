package arch.line.base.baseline.view.example.apicallexample;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import javax.inject.Inject;

import arch.line.base.baseline.MyApplication;
import arch.line.base.baseline.R;
import arch.line.base.baseline.databinding.ActivityExampleObservableDataObjectsBinding;
import arch.line.base.baseline.model.ExampleDataModel;
import arch.line.base.baseline.repository.ImdbRespository;
import arch.line.base.baseline.repository.api.ImdbApi;
import arch.line.base.baseline.repository.db.AppDataBase;
import arch.line.base.baseline.repository.db.DaoInterfaceClass;
import arch.line.base.baseline.view.BaseActivity;

public class SimpleApiCallActivity extends BaseActivity {
    ActivityExampleObservableDataObjectsBinding dataBinding;

    @Inject
    ImdbApi mImdbApi;
    @Inject
    AppDataBase mAppDataBase;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_example_observable_data_objects);
        ExampleDataModel exampleDataModel = new ExampleDataModel();
        exampleDataModel.Id = "test";
        exampleDataModel.Title = "";
        dataBinding.setExampleDataModel(exampleDataModel);
        ((MyApplication) getApplication()).getAppComponent().inject(this);
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
        ImdbRespository imdbRespository = new ImdbRespository(mImdbApi, mAppDataBase.getExampleModuleDao());
        imdbRespository.loadData("22e16c99", "tt3896198").observe(this, exampleDataModelResource -> {
            final AlertDialog progressDialog = new ProgressDialog.Builder(this).setMessage("Loading..").create();
            if (exampleDataModelResource != null) {
                progressDialog.show();
                switch (exampleDataModelResource.status) {
                    case LOADING:
                        break;
                    case SUCCESS:
                        progressDialog.dismiss();
                        ExampleDataModel exampleDataModel = new ExampleDataModel();
                        exampleDataModel.Id = exampleDataModelResource.data.Title != null ? exampleDataModelResource.data.Title : "api";
                        dataBinding.setExampleDataModel(exampleDataModel);
                        break;
                    case ERROR:
                        progressDialog.dismiss();
                        Toast.makeText(SimpleApiCallActivity.this, "Error ", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
