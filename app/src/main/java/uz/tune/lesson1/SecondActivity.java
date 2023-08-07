package uz.tune.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import uz.tune.lesson1.models.Question;

public class SecondActivity extends AppCompatActivity {

    TextView questionText;
    RadioGroup radioGroup;
    RadioButton rdFirst;
    RadioButton rdSecond;
    RadioButton rdThird;
    Button btnNext;
    Button btnBack;
    Button btnFinish;
    TextView tvResult;

    Button btnRestart;

    List<Question> questions;
    Map<Integer, Integer> answers;
    int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        answers = new HashMap<>();

        initUI();
        initClicks();
        displayQuestions();
    }

    private void initUI() {
        questionText = findViewById(R.id.tv_question);
        radioGroup = findViewById(R.id.rd_answers);
        rdFirst = findViewById(R.id.rb_first);
        rdSecond = findViewById(R.id.rb_second);
        rdThird = findViewById(R.id.rb_third);
        btnNext = findViewById(R.id.btn_next);
        btnBack = findViewById(R.id.btn_back);
        btnFinish = findViewById(R.id.btn_finish);
        tvResult = findViewById(R.id.tv_result);
        btnRestart = findViewById(R.id.btn_restart);
    }

    private void initClicks() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton selectedButton = findViewById(i);
                try {
                    answers.put(currentQuestion, getAnswerId(selectedButton.getId()));
                    Log.d("res", "res");
                } catch (Exception e) {

                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestion < questions.size() - 1) {
                    currentQuestion++;
                    displayQuestions();
                } else {
                    Toast.makeText(SecondActivity.this, "tugadi", Toast.LENGTH_SHORT).show();
                    Log.d("answers====>>", answers.toString());
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestion > 0) {
                    currentQuestion--;
                    displayQuestions();
                }
            }
        });


        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.setVisibility(View.GONE);
                btnBack.setVisibility(View.GONE);
                radioGroup.setVisibility(View.GONE);
                questionText.setVisibility(View.GONE);

                AtomicInteger correctAnswers = new AtomicInteger();
                answers.forEach((key, value) -> {
                            if (questions.get(key).getTrueAnswer() == value) {
                                correctAnswers.getAndIncrement();
                            }
                        }
                );

                answers.clear();

                tvResult.setVisibility(View.VISIBLE);
                tvResult.setText(correctAnswers + "/" + questions.size());

                btnRestart.setVisibility(View.VISIBLE);
                btnFinish.setVisibility(View.INVISIBLE);

            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnRestart.setVisibility(View.INVISIBLE);
                restart();
            }
        });
    }

    private void displayQuestions() {
        questions = Question.initQuestions();

        if (currentQuestion <= questions.size() - 1 && currentQuestion >= 0) {
            questionText.setText(questions.get(currentQuestion).getText());
            rdFirst.setText(questions.get(currentQuestion).getAnswer1());
            rdSecond.setText(questions.get(currentQuestion).getAnswer2());
            rdThird.setText(questions.get(currentQuestion).getAnswer3());
            radioGroup.check(0);
        }

        if (currentQuestion == questions.size() - 1) {
            btnFinish.setVisibility(View.VISIBLE);
        } else {
            btnFinish.setVisibility(View.INVISIBLE);
        }
    }

    private int getAnswerId(int viewId) {
        int ans = 0;
        if (viewId == R.id.rb_first) ans = 1;
        else if (viewId == R.id.rb_second) ans = 2;
        else if (viewId == R.id.rb_third) ans = 3;

        return ans;
    }

    private void restart() {
        currentQuestion = 0;
        displayQuestions();

        questionText.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.VISIBLE);
        btnBack.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);

        tvResult.setVisibility(View.INVISIBLE);
        btnFinish.setVisibility(View.INVISIBLE);
    }
}