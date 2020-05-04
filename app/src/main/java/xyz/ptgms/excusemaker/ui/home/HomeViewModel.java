package xyz.ptgms.excusemaker.ui.home;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    public void myClickMethod(View v) {
        System.out.println("yes");
    }
}