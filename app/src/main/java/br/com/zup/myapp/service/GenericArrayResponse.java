package br.com.zup.myapp.service;

import com.google.gson.annotations.SerializedName;

public class GenericArrayResponse<T> {
    @SerializedName("data")
    public T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
