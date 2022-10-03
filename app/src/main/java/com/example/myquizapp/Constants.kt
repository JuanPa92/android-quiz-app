package com.example.myquizapp

object Constants {

    // CONSTANTS to communicate data between activities
    const val USER_NAME: String = "username"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Mexico",
            "Bulgaria",
            "Turkic",
            1
        )

        val question2 = Question(
            2,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "Mexico",
            "Belgium",
            "Turkic",
            3
        )

        val question3 = Question(
            3,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Mexico",
            "Bulgaria",
            "Turkia",
            1
        )

        val question4 = Question(
            4,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_denmark,
            "Argentina",
            "Mexico",
            "Bulgaria",
            "Denmark",
            4
        )

        val question5 = Question(
            5,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "Mexico",
            "Fiji",
            "Denmark",
            3
        )

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)

        return questionList
    }
}