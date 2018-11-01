package br.com.zup.myapp.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;


import javax.inject.Inject;

import br.com.zup.myapp.R;
import br.com.zup.myapp.viewmodel.BaseViewModel;
import br.com.zup.myapp.LiveDataViewModelInjector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity implements HasSupportFragmentInjector, BaseFragment.Callback {

    private T mViewDataBinding;
    private V mViewModel;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract Class<V> getViewModelClass();

    protected abstract void initView();

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LiveDataViewModelInjector.getInstance().activityInjector().inject(this);

        super.onCreate(savedInstanceState);

        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());

        if (getViewModelClass() != null)
            mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(getViewModelClass());

        initView();
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    protected T getBinding() {
        return mViewDataBinding;
    }

    public V getViewModel() {
        return mViewModel;
    }

    public void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment, tag)
                .commit();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
