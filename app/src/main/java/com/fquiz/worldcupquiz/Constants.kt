package com.fquiz.worldcupquiz

object Constants {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTION:String="total_quentions"
    const val CORRECT_ANSWERS:String="correct_answers"
    fun getquestion():ArrayList<question>{
        val questionList=ArrayList<question>()
        val  q1=question(1,"Who is the greatest player in South America?",
        R.drawable.nrymar,"Neymar",R.drawable.valverde,
            "Valverde",R.drawable.messi,
            "Messi",R.drawable.vinicius,"Vinicius",3)
        questionList.add(q1)
        val  q2=question(1,"Who is the greatest player in Europe?",
            R.drawable.muller,"Muller",R.drawable.benzema,
            "Benzema",R.drawable.ronaldo,
            "Ronaldo",R.drawable.debryune,"De bruyne",3)
        questionList.add(q2)
        val  q3=question(1,"Who is the greatest player in the world?",
            R.drawable.messi,"Messi",R.drawable.ronaldo,
            "Ronaldo",R.drawable.salah,
            "Salah",R.drawable.lewadoski,"Lewandowski",2)
        questionList.add(q3)
        val  q4=question(1,"Who is Your GOAT of all the time?",
            R.drawable.haaland,"Haaland",R.drawable.mbappe,
            "Mbappe",R.drawable.messi,
            "Messi",R.drawable.ronaldo,"Ronaldo",3)
        questionList.add(q4)
        val  q5=question(1,"Which country is likely to win this world cup?",
            R.drawable.germany,"Germany",R.drawable.france,
            "France",R.drawable.argentina,
            "Argentina",R.drawable.portugal,"Portugal",1)
        questionList.add(q5)
        val  q6=question(1,"Who is the best young player in the world?",
            R.drawable.foden,"Foden",R.drawable.haaland,
            "Haaland",R.drawable.vinicius,
            "Vinicius",R.drawable.mbappe,"Mbappe",2)
        questionList.add(q6)
        val  q7=question(1,"Which country are you supporting in World Cup",
            R.drawable.brazil,"Brazil",R.drawable.france,
            "France",R.drawable.england,
            "England",R.drawable.argentina,"Argentina",4)
        questionList.add(q7)
        val  q8=question(1,"Which player do you think he should have not missed the world Cup?",
            R.drawable.firmino,"Firmino",R.drawable.benzema,
            "Benzema",R.drawable.sancho,
            "Sancho",R.drawable.mane,"Sadio Mane",1)
        questionList.add(q8)
        val  q9=question(1,"Who is your idle in football?",
            R.drawable.ronaldinho,"Ronaldinho",R.drawable.maradona,
            "Maradona",R.drawable.ronaldo,
            "Ronaldo",R.drawable.messi,"Messi",4)
        questionList.add(q9)
        val  q10=question(1,"Whom do you think will win the Golden Boot in this World cup?",
            R.drawable.ronaldo,"Ronaldo",R.drawable.cane,
            "Harry Kane",R.drawable.mbappe,
            "Mbappe",R.drawable.memphis,"memphis",2)
        questionList.add(q10)
        val  q11=question(1,"After messi and Ronaldo Retirement which players do you think will replace them?",
            R.drawable.vinicius,"Vinicius",R.drawable.haaland,
            "Haaland",R.drawable.mbappe,
            "Mbappe",R.drawable.pedri,"pedri",3)

        questionList.add(q11)

        return questionList
    }
}