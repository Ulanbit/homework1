package com.example.lesson1.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel {

    private String title;

    public String getTitle() {
        return title;
    }

    public HomeViewModel(String title) {
        this.title = title;
    }

    public HomeViewModel(){}
//    public LiveData<String> getText(){return null;}
}