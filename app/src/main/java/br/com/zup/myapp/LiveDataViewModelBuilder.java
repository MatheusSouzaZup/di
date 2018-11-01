package br.com.zup.myapp;

import android.app.Application;

public class LiveDataViewModelBuilder {
    private Application application;
    private String baseUrl;

    public LiveDataViewModelBuilder setApplication(Application application) {
        this.application = application;
        return this;
    }

    public LiveDataViewModelBuilder setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public LiveDataViewModelInjector build() {
        return new LiveDataViewModelInjector(application, baseUrl);
    }
}
