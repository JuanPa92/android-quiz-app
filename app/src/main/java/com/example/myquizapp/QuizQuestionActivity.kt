package com.example.myquizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition = 0

    private var progressBar: ProgressBar? = null
    private var tvProgressBar: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var option1: TextView? = null
    private var option2: TextView? = null
    private var option3: TextView? = null
    private var option4: TextView? = null

    private var btnSubmit: Button? = null

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
        btnSubmit = findViewById(R.id.submit_button)

        mQuestionList = Constants.getQuestions()

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        setQuestion()
    }

    private fun setQuestion() {

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgressBar?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4

        if (mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun setDefaultOptionsView() {
        val options = ArrayList<TextView>()

        option1?.let {
            options.add(0, it)
        }
        option2?.let {
            options.add(1, it)
        }
        option3?.let {
            options.add(2, it)
        }
        option4?.let {
            options.add(3, it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun setSelectedOption(tv: TextView, selectedOptionNum: Int){
        setDefaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option_one_text_view -> {
                option1?.let {
                    setSelectedOption(it, 1)
                }
            }

            R.id.option_two_text_view -> {
                option2?.let {
                    setSelectedOption(it, 2)
                }
            }

            R.id.option_three_text_view -> {
                option3?.let {
                    setSelectedOption(it, 3)
                }
            }

            R.id.option_four_text_view -> {
                option4?.let {
                    setSelectedOption(it, 4)
                }
            }

            R.id.submit_button -> {
                // TODO add submit button functionality
            }
        }
    }
}