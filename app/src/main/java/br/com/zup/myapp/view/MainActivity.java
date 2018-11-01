package br.com.zup.myapp.view;

import br.com.zup.myapp.R;
import br.com.zup.myapp.databinding.ActivityMainBinding;
import br.com.zup.myapp.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {
    ActivityMainBinding bind;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    protected void initView() {
        bind = getBinding();
        bind.setViewModel(getViewModel());
        getViewModel().initScreen();
    }

}
