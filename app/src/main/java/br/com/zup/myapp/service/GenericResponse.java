package br.com.zup.myapp.service;

import com.google.gson.annotations.SerializedName;

public class GenericResponse<T> {

    @SerializedName("content")
    private T content;

    @SerializedName("message")
    private String message;

    public GenericResponse() {
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
