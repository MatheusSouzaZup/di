package br.com.zup.myapp.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import javax.inject.Inject;


import br.com.zup.myapp.model.SearchResponse;
import br.com.zup.myapp.service.Api;
import br.com.zup.myapp.service.BaseCallback;
import br.com.zup.myapp.service.GenericResponse;

public class SearchRepository {
    @Inject
    public Api api;

    @Inject
    public SearchRepository() {
    }

    public LiveData<GenericResponse<SearchResponse>> getSearch(String search) {
        final MutableLiveData<GenericResponse<SearchResponse>> data = new MutableLiveData<>();
        api.getSearch(search, "41e73444").enqueue(new BaseCallback<SearchResponse>() {
            @Override
            public void onSuccess(SearchResponse response) {
                GenericResponse<SearchResponse> genericResponse = new GenericResponse<>();
                genericResponse.setContent(response);
                data.setValue(genericResponse);
            }

            @Override
            public void onError(GenericResponse error) {
                data.setValue(error);
            }
        });
        return data;
    }
}
