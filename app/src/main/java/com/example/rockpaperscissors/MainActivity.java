package com.example.rockpaperscissors;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectStone(View view) {
        this.selectionOption("Stone");
    }

    public void selectPaper(View view) {
        this.selectionOption("Paper");
    }

    public void selectScissor(View view) {
        this.selectionOption("Scissor");
    }

    public void selectionOption(String optionSelection) {
        ImageView imageResult = findViewById(R.id.imageResult);
        TextView resultText = findViewById(R.id.resultText);

        int number = new Random().nextInt(3);
        String[] options = {"Stone", "Paper", "Scissor"};
        String appOption = options[number];

        switch (appOption) {
            case "Stone":
                imageResult.setImageResource(R.drawable.padrao);
                break;
            case "Paper":
                imageResult.setImageResource(R.drawable.papel);
                break;
            case "Scissor":
                imageResult.setImageResource(R.drawable.tesoura);
                break;
        }
        if (
                (appOption == "Scissor" && optionSelection == "Paper") ||
                (appOption == "Paper" && optionSelection == "Stone") ||
                (appOption == "Stone" && optionSelection == "Scissor")
        ) {
            resultText.setText("You Lose");

        } else if (
                (optionSelection == "Scissor" && appOption == "Paper") ||
                 (optionSelection == "Paper" && appOption == "Stone") ||
                 (optionSelection == "Stone" && appOption == "Scissor")
        ) {
            resultText.setText("You Won");

        } else {
            resultText.setText("We Tie");
        }

        System.out.println("Selected Item "  + appOption);
    }
}