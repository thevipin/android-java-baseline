package arch.line.base.baseline.view.example.apicallexample;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;

import arch.line.base.baseline.view.BaseActivity;
import arch.line.base.baseline.viewmodel.example.SimpleApiCallViewModel;

public class SimpleApiCallActivity extends BaseActivity {
    SimpleApiCallViewModel simpleApiCallViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simpleApiCallViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

    }

    private void loadData(){

    }
}
