package arch.line.base.baseline.injection;

import javax.inject.Singleton;

import arch.line.base.baseline.repository.ImdbRespository;
import arch.line.base.baseline.view.example.apicallexample.SimpleApiCallActivity;
import dagger.Component;

@Singleton
@Component(modules = RestModule.class)
public interface AppComponent {
 public void inject(SimpleApiCallActivity activity);
}
