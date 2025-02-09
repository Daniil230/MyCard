package com.example.mycard;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageStar;
    private TextView mainText;
    private TextView mainText2, yourCard;
    private ImageView imageCard;
    private MainViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.loadCardImage();


        imageStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.loadCardImage();
                Random random = new Random();
                int number = random.nextInt(78);
                Log.d("MainActivity", "number: " + number);
                setCardsImage(number);
                mainText.setVisibility(View.INVISIBLE);
                mainText2.setVisibility(View.VISIBLE);
                yourCard.setVisibility(View.VISIBLE);
            }
        });

    }
    private void setCardsImage(int number) {
        switch (number) {
            case 0:
                imageCard.setImageResource(R.drawable.shut);
                yourCard.setText("ШУТ");
                break;
            case 1:
                imageCard.setImageResource(R.drawable.mag);
                yourCard.setText("МАГ");
                break;
            case 2:
                imageCard.setImageResource(R.drawable.verhovaya_zhrica);
                yourCard.setText("ЖРИЦА");
                break;
            case 3:
                imageCard.setImageResource(R.drawable.imperatrica);
                yourCard.setText("ИМПЕРАТРИЦА");
                break;
            case 4:
                imageCard.setImageResource(R.drawable.imperator);
                yourCard.setText("ИМПЕРАТОР");
                break;
            case 5:
                imageCard.setImageResource(R.drawable.verhovnyi_zhrec);
                yourCard.setText("ЖРЕЦ");
                break;
            case 6 :
                imageCard.setImageResource(R.drawable.vlublennye);
                yourCard.setText("ВЛЮБЛЁННЫЕ");
                break;
            case 7 :
                imageCard.setImageResource(R.drawable.sila);
                yourCard.setText("СИЛА");
                break;
            case 8 :
                imageCard.setImageResource(R.drawable.otshelnik);
                yourCard.setText("ОТШЕЛЬНИК");
                break;
            case 9 : imageCard.setImageResource(R.drawable.koleso_fortuny);
                yourCard.setText("КОЛЕСО ФОРТУНЫ");
                break;
            case 10 :imageCard.setImageResource(R.drawable.spravedlivost);
                yourCard.setText("СПРАВЕДЛИВОСТЬ");
                break;
            case 11 :imageCard.setImageResource(R.drawable.poveshennyi);
                yourCard.setText("ПОВЕШЕННЫЙ");
                break;
            case 12 :imageCard.setImageResource(R.drawable.smert);
                yourCard.setText("СМЕРТЬ");
                break;
            case 13 :imageCard.setImageResource(R.drawable.umerennost);
                yourCard.setText("УМЕРЕННОСТЬ");
                break;
            case 14 :imageCard.setImageResource(R.drawable.diyavol);
                yourCard.setText("ДЬЯВОЛ");
                break;
            case 15 :imageCard.setImageResource(R.drawable.padayushaya_bashnya);
                yourCard.setText("БАШНЯ");
                break;
            case 16 :imageCard.setImageResource(R.drawable.zvezda);
                yourCard.setText("ЗВЕЗДА");
                break;
            case 17 : imageCard.setImageResource(R.drawable.luna);
                yourCard.setText("ЛУНА");
                break;
            case 18 : imageCard.setImageResource(R.drawable.solnce);
                yourCard.setText("СОЛНЦЕ");
                break;
            case 19 : imageCard.setImageResource(R.drawable.strashnyi_sud);
                yourCard.setText("СТРАШНЫЙ СУД");
                break;
            case 20 : imageCard.setImageResource(R.drawable.mir);
                yourCard.setText("МИР");
                break;
            case 21 : imageCard.setImageResource(R.drawable.tuz_zhezlov);
                yourCard.setText("ТУЗ ЖЕЗЛОВ");
                break;
            case 22 : imageCard.setImageResource(R.drawable.korol_zhezlov);
                yourCard.setText("КОРОЛЬ ЖЕЗЛОВ");
                break;
            case 23 : imageCard.setImageResource(R.drawable.koroleva_zhezlov);
                yourCard.setText("КОРОЛЕВА ЖЕЗЛОВ");
                break;
            case 24 : imageCard.setImageResource(R.drawable.rycar_zhezlov);
                yourCard.setText("РЫЦАРЬ ЖЕЗЛОВ");
                break;
            case 25 : imageCard.setImageResource(R.drawable.pazh_zhezlov);
                yourCard.setText("ПАЖ ЖЕЗЛОВ");
                break;
            case 26 : imageCard.setImageResource(R.drawable.dvoika_zhezlov);
                yourCard.setText("ДВОЙКА ЖЕЗЛОВ");
                break;
            case 27 : imageCard.setImageResource(R.drawable.troika_zhezlov);
                yourCard.setText("ТРОЙКА ЖЕЗЛОВ");
                break;
            case 28 : imageCard.setImageResource(R.drawable.chetverka_zhezlov);
                yourCard.setText("ЧЕТВЁРКА ЖЕЗЛОВ");
                break;
            case 29 : imageCard.setImageResource(R.drawable.pyaterka_zhezlov);
                yourCard.setText("ПЯТЁРКА ЖЕЗЛОВ");
                break;
            case 30 : imageCard.setImageResource(R.drawable.shesterka_zhezlov);
                yourCard.setText("ШЕСТЁРКА ЖЕЗЛОВ");
                break;
            case 31 : imageCard.setImageResource(R.drawable.semerka_zhezlov);
                yourCard.setText("СЕМЁРКА ЖЕЗЛОВ");
                break;
            case 32 : imageCard.setImageResource(R.drawable.vosmerka_zhezlov);
                yourCard.setText("ВОСЬМЁРКА ЖЕЗЛОВ");
                break;
            case 33 : imageCard.setImageResource(R.drawable.devyatka_zhezlov);
                yourCard.setText("ДЕВЯТКА ЖЕЗЛОВ");
                break;
            case 34 : imageCard.setImageResource(R.drawable.desyatka_zhezlov);
                yourCard.setText("ДЕСЯТКА ЖЕЗЛОВ");
                break;
            case 35 : imageCard.setImageResource(R.drawable.tuz_kubkov);
                yourCard.setText("ТУЗ КУБКОВ");
                break;
            case 36 : imageCard.setImageResource(R.drawable.korol_kubkov);
                yourCard.setText("КОРОЛЬ КУБКОВ");
                break;
            case 37 : imageCard.setImageResource(R.drawable.koroleva_kubkov);
                yourCard.setText("КОРОЛЕВА КУБКОВ");
                break;
            case 38 : imageCard.setImageResource(R.drawable.rycar_kubkov);
                yourCard.setText("РЫЦАРЬ КУБКОВ");
                break;
            case 39 : imageCard.setImageResource(R.drawable.pazh_kubkov);
                yourCard.setText("ПАЖ КУБКОВ");
                break;
            case 40 : imageCard.setImageResource(R.drawable.dvoika_kubkov);
                yourCard.setText("ДВОЙКА КУБКОВ");
                break;
            case 41 : imageCard.setImageResource(R.drawable.troika_kubkov);
                yourCard.setText("ТРОЙКА КУБКОВ");
                break;
            case 42 : imageCard.setImageResource(R.drawable.chetverka_kubkov);
                yourCard.setText("ЧЕТВЁРКА КУБКОВ");
                break;
            case 43 : imageCard.setImageResource(R.drawable.pyaterka_kubkov);
                yourCard.setText("ПЯТЁРКА КУБКОВ");
                break;
            case 44 : imageCard.setImageResource(R.drawable.shesterka_kubkov);
                yourCard.setText("ШЕСТЁРКА КУБКОВ");
                break;
            case 45 : imageCard.setImageResource(R.drawable.semerka_kubkov);
                yourCard.setText("СЕМЁРКА КУБКОВ");
                break;
            case 46 :
                imageCard.setImageResource(R.drawable.vosmerka_kubkov);
                yourCard.setText("ВОСЬМЁРКА КУБКОВ");
                break;
            case 47 :
                imageCard.setImageResource(R.drawable.devyatka_kubkov);
                yourCard.setText("ДЕВЯТКА КУБКОВ");
                break;
            case 48 :
                imageCard.setImageResource(R.drawable.desyatka_kubkov);
                yourCard.setText("ДЕСЯТКА КУБКОВ");
                break;
            case 49 :
                imageCard.setImageResource(R.drawable.tuz_mechei);
                yourCard.setText("ТУЗ МЕЧЕЙ");
                break;
            case 50 :
                imageCard.setImageResource(R.drawable.korol_mechei);
                yourCard.setText("КОРОЛЬ МЕЧЕЙ");
                break;
            case 51 :
                imageCard.setImageResource(R.drawable.koroleva_mechei);
                yourCard.setText("КОРОЛЕВА МЕЧЕЙ");
                break;
            case 52 :
                imageCard.setImageResource(R.drawable.rycar_mechei);
                yourCard.setText("РЫЦАРЬ МЕЧЕЙ");
                break;
            case 53 :
                imageCard.setImageResource(R.drawable.pazh_mechei);
                yourCard.setText("ПАЖ МЕЧЕЙ");
                break;
            case 54 :
                imageCard.setImageResource(R.drawable.dvoika_mechei);
                yourCard.setText("ДВОЙКА МЕЧЕЙ");
                break;
            case 55 :
                imageCard.setImageResource(R.drawable.troika_mechei);
                yourCard.setText("ТРОЙКА МЕЧЕЙ");
                break;
            case 56 :
                imageCard.setImageResource(R.drawable.chetverka_mechei);
                yourCard.setText("ЧЕТВЁРКА МЕЧЕЙ");
                break;
            case 57 :
                imageCard.setImageResource(R.drawable.pyaterka_mechei);
                yourCard.setText("ПЯТЁРКА МЕЧЕЙ");
                break;
            case 58 :
                imageCard.setImageResource(R.drawable.shesterka_mechei);
                yourCard.setText("ШЕСТЁРКА МЕЧЕЙ");
                break;
            case 59 :
                imageCard.setImageResource(R.drawable.semerka_mechei);
                yourCard.setText("СЕМЁРКА МЕЧЕЙ");
                break;
            case 60 :
                imageCard.setImageResource(R.drawable.vosmerka_mechei);
                yourCard.setText("ВОСЬМЁРКА МЕЧЕЙ");
                break;
            case 61 :
                imageCard.setImageResource(R.drawable.devyatka_mechei);
                yourCard.setText("ДЕВЯТКА МЕЧЕЙ");
                break;
            case 62 :
                imageCard.setImageResource(R.drawable.desyatka_mechei);
                yourCard.setText("ДЕСЯТКА МЕЧЕЙ");
                break;
            case 63 :
                imageCard.setImageResource(R.drawable.korol_pentaklei);
                yourCard.setText("КОРОЛЬ ПЕНТАКЛЕЙ");
                break;
            case 64 :
                imageCard.setImageResource(R.drawable.koroleva_pentaklei);
                yourCard.setText("КОРОЛЕВА ПЕНТАКЛЕЙ");
                break;
            case 65 :
                imageCard.setImageResource(R.drawable.rycar_pentaklei);
                yourCard.setText("РЫЦАРЬ ПЕНТАКЛЕЙ");
                break;
            case 66 :
                imageCard.setImageResource(R.drawable.pazh_pentaklei);
                yourCard.setText("ПАЖ ПЕНТАКЛЕЙ");
                break;
            case 67 :
                imageCard.setImageResource(R.drawable.dvoika_pentaklei);
                yourCard.setText("ДВОЙКА ПЕНТАКЛЕЙ");
                break;
            case 68 :
                imageCard.setImageResource(R.drawable.troika_pentaklei);
                yourCard.setText("ТРОЙКА ПЕНТАКЛЕЙ");
                break;
            case 69 :
                imageCard.setImageResource(R.drawable.chetverka_pentaklei);
                yourCard.setText("ЧЕТВЁРКА ПЕНТАКЛЕЙ");
                break;
            case 70 :
                imageCard.setImageResource(R.drawable.pyaterka_pentaklei);
                yourCard.setText("ПЯТЁРКА ПЕНТАКЛЕЙ");
                break;
            case 71 :
                imageCard.setImageResource(R.drawable.shesterka_pentaklei);
                yourCard.setText("ШЕСТЁРКА ПЕНАТКЛЕЙ");
                break;
            case 72 :
                imageCard.setImageResource(R.drawable.semerka_pentaklei);
                yourCard.setText("СЕМЁРКА ПЕНТАКЛЕЙ");
                break;
            case 73 :
                imageCard.setImageResource(R.drawable.vosmerka_pentaklei);
                yourCard.setText("ВОСЬМЁРКА ПЕНТАКЛЕЙ");
                break;
            case 74 :
                imageCard.setImageResource(R.drawable.devyatka_pentaklei);
                yourCard.setText("ДЕВЯТКА ПЕНТАКЛЕЙ");
                break;
            case 75 :
                imageCard.setImageResource(R.drawable.desyatka_pentaklei);
                yourCard.setText("ДЕСЯТКА ПЕНТАКЛЕЙ");
                break;
            case 76 :
                imageCard.setImageResource(R.drawable.kolesnica);
                yourCard.setText("КОЛЕСНИЦА");
                break;
            case 77 :
                imageCard.setImageResource(R.drawable.tuz_pentakley);
                yourCard.setText("ТУЗ ПЕНТАКЛЕЙ");
                break;
            default:
                imageCard.setImageResource(R.drawable.shut);
        }
    }
    private void initViews(){
        imageStar = findViewById(R.id.imageStar);
        mainText = findViewById(R.id.mainText);
        mainText2 = findViewById(R.id.mainText2);
        imageCard = findViewById(R.id.imageCard);
        yourCard = findViewById(R.id.yourCard);
    }
}