package br.com.zup.myapp;

import br.com.zup.myapp.di.app.AppComponent;
import br.com.zup.myapp.di.app.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class AppController extends DaggerApplication {

    private String BASE_URL = "http://www.omdbapi.com";

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();
        appComponent.inject(this);
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        new LiveDataViewModelBuilder()
                .setApplication(this)
                .setBaseUrl(BASE_URL)
                .build();
    }
}
