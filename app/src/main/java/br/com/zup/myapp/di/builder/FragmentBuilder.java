package br.com.zup.myapp.di.builder;

import br.com.zup.myapp.di.Fragment;
import br.com.zup.myapp.view.MainFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilder {
    @Fragment
    @ContributesAndroidInjector
    abstract MainFragment bindMainFragment();
}
