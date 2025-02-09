package com.example.mycard;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ResourceBundle;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";
    private static final String BASE_USL = "https://tarotapi.dev/api/v1/cards/random?n=1";
    private static final String KEY_NAME = "name";
    private String name;

    private final MutableLiveData<CardImage> cardImage = new MutableLiveData<>();

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<CardImage> getCardImage(){
        return cardImage;
    }


    public void loadCardImage(){
        Disposable disposable = loadCardImageRX()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CardImage>() {
                    @Override
                    public void accept(CardImage card) throws Throwable {
                        cardImage.setValue(card);

                        Log.d(TAG, "name: " + cardImage.getValue().getCards().get(0).getName());
                    }

                },new Consumer<Throwable>(){
                    @Override
                    public void accept(Throwable throwable) throws Throwable {

                        Log.d(TAG, "Error: " + throwable.getMessage());
                    }
                });
        compositeDisposable.add(disposable);
    }

    private Single<CardImage> loadCardImageRX(){
        return ApiFactory.getApiService().loadCardImage();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
