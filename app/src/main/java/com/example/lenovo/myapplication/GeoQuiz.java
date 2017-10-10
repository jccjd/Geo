package com.example.lenovo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GeoQuiz extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mnextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_africa,false),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true),
    };
    private int mCurrentIndex = 0;

    private void updataQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_quiz);

        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);


        mFalseButton = (Button)findViewById(R.id.false_button);


        /*匿名内部类的两大好处
        *   1.因为匿名内部类的可以在同一处实现监听器方法，代码清晰可读
        *   2.事件监听器一般只在同一处使用，使匿名内部类可以避免不必要的命名类的实现
        * */
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Does nothing yet,but soon!
                Toast.makeText(GeoQuiz.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();

            }
        });
        mTrueButton = (Button)findViewById(R.id.true_button);
        mnextButton = (Button) findViewById(R.id.next_button);
        mnextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updataQuestion();
            }
        });
        updataQuestion();
    }
}
