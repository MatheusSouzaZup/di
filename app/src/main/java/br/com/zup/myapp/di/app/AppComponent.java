package br.com.zup.myapp.di.app;

import android.app.Application;



import javax.inject.Singleton;

import br.com.zup.myapp.LiveDataViewModelInjector;
import br.com.zup.myapp.di.builder.ActivityBuilder;
import br.com.zup.myapp.di.builder.FragmentBuilder;
import br.com.zup.myapp.di.builder.ViewModelBuilder;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AppModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        FragmentBuilder.class,
        ViewModelBuilder.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(LiveDataViewModelInjector application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
