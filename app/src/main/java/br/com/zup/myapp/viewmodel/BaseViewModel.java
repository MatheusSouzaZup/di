package br.com.zup.myapp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;


public abstract class BaseViewModel<N> extends ViewModel {

    public ObservableBoolean showLoading = new ObservableBoolean(false);

    private N mNavigator;

    protected BaseViewModel() {
    }

    public N getNavigator() {
        return mNavigator;
    }

    public void setNavigator(N mNavigator) {
        this.mNavigator = mNavigator;
    }

    public void showLoading() {
        showLoading.set(true);
    }

    public void hideLoading() {
        showLoading.set(false);
    }
}
