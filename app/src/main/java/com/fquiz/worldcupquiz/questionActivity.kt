package com.fquiz.worldcupquiz

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import android.content.Intent as Intent

class questionActivity : AppCompatActivity(), View.OnClickListener{
    private var mCurrentposition:Int=1
    private var mQuestionList:ArrayList<question>?=null
    private var mSelectedOptionPosition:Int=0
    private var musername:String?=null
    private var mccorrectAnswers=0

    private var textquiz:TextView?=null
    private var progressBar:ProgressBar?=null
    private var txtProgress:TextView?=null

    private var image1:ImageView?=null
    private var txtoption1:TextView?=null
    private var image2:ImageView?=null
    private var txtoption2:TextView?=null
    private var image3:ImageView?=null
    private var txtoption3:TextView?=null
    private var image4:ImageView?=null
    private var txtoption4:TextView?=null
    private var btnSubmit:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        musername=intent.getStringExtra(Constants.USER_NAME)

        textquiz = findViewById(R.id.questions)
        progressBar = findViewById(R.id.progressbar)
        txtProgress = findViewById(R.id.txtprogress)

        image1 = findViewById(R.id.neymar)
        txtoption1 = findViewById(R.id.option1)
        image2 = findViewById(R.id.valverde)
        txtoption2 = findViewById(R.id.option2)
        image3 = findViewById(R.id.messi)
        txtoption3 = findViewById(R.id.option3)
        image4 = findViewById(R.id.vinicius)
        txtoption4 = findViewById(R.id.option4)
        mCurrentposition = 1
        btnSubmit=findViewById(R.id.submit)
        mQuestionList=Constants.getquestion()

        txtoption1?.setOnClickListener(this)
        txtoption2?.setOnClickListener(this)
        txtoption3?.setOnClickListener(this)
        txtoption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        setQuestion()
        defaultOptionsView()

    }
        private fun setQuestion() {
            defaultOptionsView()
            val Question: question = mQuestionList!![mCurrentposition - 1]

            progressBar?.progress = mCurrentposition
            txtProgress?.text = "$mCurrentposition/${progressBar?.max}"
            textquiz?.text = Question.quetion
            image1?.setImageResource(Question.image)
            txtoption1?.text = Question.optionOne
            image2?.setImageResource(Question.image2)
            txtoption2?.text = Question.optionTwo
            image3?.setImageResource(Question.image3)
            txtoption3?.text = Question.optionThree
            image4?.setImageResource(Question.image4)
            txtoption4?.text = Question.optionFour

            if(mCurrentposition==mQuestionList!!.size){
                btnSubmit?.setText("FINISH")
            }else{
                btnSubmit?.setText("SUBMIT")
            }

        }
    private fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        txtoption1?.let{
            options.add(0,it)
        }
        txtoption2?.let{
            options.add(1,it)
        }
        txtoption3?.let{
            options.add(2,it)
        }
        txtoption4?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#FF000000"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,R.drawable.bacgroundoptions
            )
        }
    }
    private fun selectedOptionView(txt:TextView,selectedOptionMenu:Int){
        defaultOptionsView()

        mSelectedOptionPosition=selectedOptionMenu
        txt.setTextColor(Color.parseColor("#FF018786"))
        txt.setTypeface(txt.typeface,Typeface.BOLD)
        txt.background=ContextCompat.getDrawable(
            this,R.drawable.selectedbacground
        )
    }
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.option1->{
                txtoption1?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.option2->{
                txtoption2?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.option3->{
                txtoption3?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.option4->{
                txtoption4?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.submit->{
                if (mSelectedOptionPosition==0){
                    mCurrentposition++
                    when{
                        mCurrentposition<=mQuestionList!!.size->{
                            setQuestion()
                        }else->{
                            val intent=Intent(this,result::class.java)
                        intent.putExtra(Constants.USER_NAME,musername)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mccorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTION,mQuestionList?.size)
                        startActivity(intent)
                        finish()
                        }
                    }

                }else{
                    val questionn=mQuestionList?.get(mCurrentposition-1)
                    if(questionn!!.correctAnswer!=mSelectedOptionPosition){
                        answeView(mSelectedOptionPosition,R.drawable.wrongoption)
                    }
                    else{
                        mccorrectAnswers++
                    }
                    answeView(questionn.correctAnswer,R.drawable.correctoption)
                   if(mCurrentposition==mQuestionList?.size){
                       btnSubmit?.setText("FINISH")
                   }else{
                       btnSubmit?.setText("NEXT QUESTION")
                   }
                    mSelectedOptionPosition=0
                }
            }
        }
    }
    private fun answeView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                txtoption1?.background=ContextCompat.getDrawable(this,
                    drawableView
                )
            }
            2->{
                txtoption2?.background=ContextCompat.getDrawable(this,
                    drawableView
                )
            }
            3->{
                txtoption3?.background=ContextCompat.getDrawable(this,
                    drawableView
                )
            }
            4->{
                txtoption4?.background=ContextCompat.getDrawable(this,
                    drawableView
                )
            }
        }

    }
}