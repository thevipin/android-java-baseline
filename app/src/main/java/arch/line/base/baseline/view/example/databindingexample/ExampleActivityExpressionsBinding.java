package arch.line.base.baseline.view.example.databindingexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import arch.line.base.baseline.R;
import arch.line.base.baseline.databinding.ActivityExampleExpressionDataBinding;
import arch.line.base.baseline.model.ExampleDataModel;
import arch.line.base.baseline.view.BaseActivity;

public class ExampleActivityExpressionsBinding extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //data binding expressions
        ActivityExampleExpressionDataBinding dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_example_expression_binding);
        ExampleDataModel exampleDataModel = new ExampleDataModel();
        exampleDataModel.Id = "hello";
        dataBinding.setExampleDataModel(exampleDataModel);
    }
}
