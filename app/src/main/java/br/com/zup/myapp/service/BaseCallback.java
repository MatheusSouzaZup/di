package br.com.zup.myapp.service;


import com.google.gson.Gson;


import br.com.zup.myapp.LiveDataViewModelInjector;
import br.com.zup.myapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseCallback<T> implements Callback<T> {

    public abstract void onSuccess(T response);

    public abstract void onError(GenericResponse error);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            try {
                onError(new Gson().fromJson(response.errorBody().string(), GenericResponse.class));
            } catch (Exception e) {
                e.printStackTrace();

                GenericResponse errorResponse = new GenericResponse();
                errorResponse.setMessage(e.getMessage());
                onError(errorResponse);
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        GenericResponse response = new GenericResponse();
        response.setMessage(LiveDataViewModelInjector.getInstance().getContext().getString(R.string.default_error_message));
        onError(response);
    }
}
