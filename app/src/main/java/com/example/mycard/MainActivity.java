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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageStar;
    private TextView mainText;
    private TextView mainText2;
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
                Random random = new Random();
                int number = random.nextInt(21);
                Log.d("MainActivity", "number: " + number);
                setCardsImage(number);
                mainText.setVisibility(View.INVISIBLE);
                mainText2.setVisibility(View.VISIBLE);
            }
        });

    }

    private void initViews(){
        imageStar = findViewById(R.id.imageStar);
        mainText = findViewById(R.id.mainText);
        mainText2 = findViewById(R.id.mainText2);
        imageCard = findViewById(R.id.imageCard);
    }

    private void setCardsImage(int number){

        switch (number){
            case 0 : imageCard.setImageResource(R.drawable.card); break;
            case 1 : imageCard.setImageResource(R.drawable.card1); break;
            case 2 : imageCard.setImageResource(R.drawable.card2); break;
            case 3 : imageCard.setImageResource(R.drawable.card3); break;
            case 4 : imageCard.setImageResource(R.drawable.card4); break;
            case 6 : imageCard.setImageResource(R.drawable.card6); break;
            case 7 : imageCard.setImageResource(R.drawable.card7); break;
            case 8 : imageCard.setImageResource(R.drawable.card8); break;
            case 9 : imageCard.setImageResource(R.drawable.card9); break;
            case 10 : imageCard.setImageResource(R.drawable.card10); break;
            case 11 : imageCard.setImageResource(R.drawable.card11); break;
            case 12 : imageCard.setImageResource(R.drawable.card12); break;
            case 13 : imageCard.setImageResource(R.drawable.card13); break;
            case 14 : imageCard.setImageResource(R.drawable.card14); break;
            case 15 : imageCard.setImageResource(R.drawable.card15); break;
            case 16 : imageCard.setImageResource(R.drawable.card16); break;
            case 17 : imageCard.setImageResource(R.drawable.card17); break;
            case 18 : imageCard.setImageResource(R.drawable.card18); break;
            case 19 : imageCard.setImageResource(R.drawable.card19); break;
            case 20 : imageCard.setImageResource(R.drawable.card20); break;
            default: imageCard.setImageResource(R.drawable.card); break;
        }

    }
}