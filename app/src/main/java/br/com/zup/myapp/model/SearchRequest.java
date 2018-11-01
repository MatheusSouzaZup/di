package br.com.zup.myapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Observable;

public class SearchRequest extends Observable implements Parcelable {
    String text;

    public SearchRequest(String text) {
        this.text = text;
    }

    protected SearchRequest(Parcel in) {
        text = in.readString();
    }

    public static final Creator<SearchRequest> CREATOR = new Creator<SearchRequest>() {
        @Override
        public SearchRequest createFromParcel(Parcel in) {
            return new SearchRequest(in);
        }

        @Override
        public SearchRequest[] newArray(int size) {
            return new SearchRequest[size];
        }
    };

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
    }
}
