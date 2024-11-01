package com.example.calculator.ViewModles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.calculator.Repository.CalcRepo;
import com.example.calculator.entities.Result;

public class CalcModle extends ViewModel {
    private CalcRepo repo = new CalcRepo();
    private MutableLiveData<Result> data = new MutableLiveData<>();


    public void eval(String dataset){
        Result calculate = repo.calculate(dataset);
        data.postValue(calculate);
    }
    public LiveData<Result> getData(){
        return  data;
    }
    public void setText(String text){
        data.postValue(new Result(text));
    }
}
