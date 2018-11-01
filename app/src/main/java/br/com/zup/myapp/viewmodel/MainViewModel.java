package br.com.zup.myapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableArrayList;

import javax.inject.Inject;

import br.com.zup.myapp.model.SearchRequest;
import br.com.zup.myapp.model.SearchResponse;
import br.com.zup.myapp.repository.SearchRepository;
import br.com.zup.myapp.service.GenericResponse;


public class MainViewModel extends BaseViewModel {
    private SearchRepository mSearchRepository;
    private MediatorLiveData<GenericResponse<SearchResponse>> mediatorLiveData = new MediatorLiveData<>();
    private ObservableArrayList<SearchResponse> mSearchList = new ObservableArrayList<>();
    public SearchRequest searchRequest;

    @Inject
    public MainViewModel(SearchRepository mSearchRepository) {
        this.mSearchRepository = mSearchRepository;
    }

    public void initScreen() {
        mediatorLiveData.addSource(getSearchDefault(), (GenericResponse<SearchResponse> input) -> {
            if (input != null && input.getContent() != null) {
                mediatorLiveData.setValue(input);
            }
        });
    }

    public LiveData<GenericResponse<SearchResponse>> getSearchDefault() {
        return Transformations.map(mSearchRepository.getSearch("21"), (GenericResponse<SearchResponse> input) -> {
            if (input.getContent() == null) {
                GenericResponse<SearchResponse> error = new GenericResponse<>();
                error.setMessage(input.getMessage());
                mediatorLiveData.setValue(error);
            }
            return input;
        });
    }

    public void onClickSearch() {
        showLoading();
        mSearchList.clear();
        mediatorLiveData.addSource(getSearchDefault(), input -> {
            if (input != null && input.getContent() != null) {
                mediatorLiveData.setValue(input);
            }
        });
    }

    public interface Navigator {
//        void navigateSomewhere();
    }

}
