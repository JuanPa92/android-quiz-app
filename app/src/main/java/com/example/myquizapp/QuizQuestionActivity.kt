package com.example.myquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var tvProgressBar: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var option1: TextView? = null
    private var option2: TextView? = null
    private var option3: TextView? = null
    private var option4: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        progressBar = findViewById(R.id.progress_bar)
        tvProgressBar = findViewById(R.id.progress_text_view)
        tvQuestion = findViewById(R.id.question_text_view)
        ivImage = findViewById(R.id.flag_image_view)
        option1 = findViewById(R.id.option_one_text_view)
        option2 = findViewById(R.id.option_two_text_view)
        option3 = findViewById(R.id.option_three_text_view)
        option4 = findViewById(R.id.option_four_text_view)

        val questionList = Constants.getQuestions()
        Log.i("QuestionsList size: ", "${questionList.size}")

        var currentPosition = 1
        val question: Question =  questionList[currentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        tvProgressBar?.text = "$currentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4
    }
}