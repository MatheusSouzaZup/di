package br.com.zup.myapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import br.com.zup.myapp.R;
import br.com.zup.myapp.databinding.FragmentMainBinding;
import br.com.zup.myapp.viewmodel.MainViewModel;

public class MainFragment extends BaseFragment<FragmentMainBinding, MainViewModel> {

    public static final String TAG = MainFragment.class.getSimpleName();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Inject
    MainViewModel mMainViewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mMainViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainViewModel.setNavigator(this);
    }
}
