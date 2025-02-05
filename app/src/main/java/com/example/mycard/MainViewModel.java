package com.example.mycard;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.Callable;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";
    private static final String BASE_USL = "https://tarotapi.dev/api/v1/cards/random?n=1";
    private static final String KEY_NAME = "cards[name]";
    private String name;

    private MutableLiveData<CardImage> cardImage = new MutableLiveData<>();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadCardImage(){
        Disposable disposable = loadCardImageRX()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CardImage>() {
                    @Override
                    public void accept(CardImage image) throws Throwable {
                        cardImage.setValue(image);

                    }

                },new Consumer<Throwable>(){
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d(TAG, "name: " + name);
                        Log.d(TAG, "Error: " + throwable.getMessage());
                    }
                });
        compositeDisposable.add(disposable);
    }

    private Single<CardImage> loadCardImageRX(){
        return Single.fromCallable(new Callable<CardImage>() {
            @Override
            public CardImage call() throws Exception {
                URL url = new URL(BASE_USL);
                //открываем содинение, сохроняя его в urlConnection
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                //создание потока ввода для считывания данных из интернета
                InputStream inputStream = urlConnection.getInputStream();
                //сичитывание символов по байтового
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                //считывание целой строки
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder data = new StringBuilder();
                String result;
                do {
                    result = bufferedReader.readLine();
                    if (result != null){
                        data.append(result);
                    }
                } while (result != null);

                JSONObject jsonObject = new JSONObject(data.toString());
                name = jsonObject.getString(KEY_NAME);
                Log.d(TAG, "name: " + name);
                return new CardImage(name);
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
