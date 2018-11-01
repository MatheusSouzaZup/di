package br.com.zup.myapp.di.builder;

import br.com.zup.myapp.di.Activity;
import br.com.zup.myapp.view.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @Activity
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
