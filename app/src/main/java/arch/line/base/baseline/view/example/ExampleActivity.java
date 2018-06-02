package arch.line.base.baseline.view.example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import arch.line.base.baseline.R;
import arch.line.base.baseline.databinding.ActivityExampleExpressionDataBinding;
import arch.line.base.baseline.model.ExampleDataModel;
import arch.line.base.baseline.view.BaseActivity;

public class ExampleActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityExampleExpressionDataBinding dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_example_expression_binding);
        ExampleDataModel exampleDataModel = new ExampleDataModel();
        exampleDataModel.Id = "hello";
        dataBinding.setExampleDataModel(exampleDataModel);
    }
}
