package com.example.game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private static final String Brown = "Brown";
    private static final String Teal = "Teal";
    private static final String Purple = "Purple";
    private static final String Black = "Black";
    private static final String BROWN_VALUE = "#954535";
    private static final String TEAL_VALUE = "#FF03DAC5";
    private static final String PURPLE_VALUE = "#FFBB86FC";
    private static final String BLACK_VALUE = "#FF000000";

    private TextView textQuestion = null;
    private Button btnBrown, btnTeal, btnPurple, btnBlack = null;
    private ProgressBar progbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textQuestion = findViewById(R.id.txt_question);

        btnBrown = findViewById(R.id.btn_brown);
        btnTeal = findViewById(R.id.btn_teal);
        btnPurple = findViewById(R.id.btn_purple);
        btnBlack = findViewById(R.id.btn_black);

        progbar = findViewById(R.id.progressBar);
        progbar.setProgress(0);

        setQuestion();

    }

    private void setQuestion(){
        Map<String, String> colorMap = new HashMap<>();
        colorMap.put(Brown, BROWN_VALUE);
        colorMap.put(Teal, TEAL_VALUE);
        colorMap.put(Purple, PURPLE_VALUE);

        String question = getRandmonColor();
        String questionColor = getRandmonColor();

        if(colorMap.containsKey(question) && colorMap.containsKey(questionColor)){
            textQuestion.setText(question);
            String questionTextColor = colorMap.get(questionColor);
            textQuestion.setTextColor(Color.parseColor(questionTextColor));
        }

    }

    private String getRandmonColor(){
        List<String> colors = Arrays.asList(Brown, Teal, Purple, Black);
        Random random = new Random();
        int randomIndex = random.nextInt(4);    //Arrays Value 0,1,2,3 so 4 is the LIMIT
        return colors.get(randomIndex);

    }

    public void submitAnswer(View view){
        Button btn = (Button) view;
        //boolean result = textQuestion.getText().equals(btn.getText());
        boolean result = textQuestion.getText().toString().equalsIgnoreCase(btn.getText().toString());
        if(result){
            // Correct Answer
            setQuestion(); // Generate NEW Question

        } else {
            // Game Over

        }
    }
}