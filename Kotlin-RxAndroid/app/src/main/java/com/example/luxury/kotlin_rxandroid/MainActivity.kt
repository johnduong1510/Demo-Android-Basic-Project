package com.example.luxury.kotlin_rxandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe.subscribe
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Sau 1s cap nhap content cua EditText len TextView
//        Observable.create(ObservableOnSubscribe<String> { subscripber ->
//            editText.addTextChangedListener(object : TextWatcher {
//                override fun afterTextChanged(s: Editable?) {
//
//                }
//
//                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//                }
//
//                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = subscripber.onNext(s.toString())
//            })
//        })
//                .debounce(1000, TimeUnit.MILLISECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ text ->
//                    textView.text = "Output: " + text
//                })

        //Su dung RxBinding rut gon
        RxTextView.afterTextChangeEvents(editText)
                .debounce(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        { editTextChangeEvent -> textView.text = "Output : " + editTextChangeEvent.view().text },
                        {error->Log.d("RxAndroid",error.message)},
                        {Log.d("RxAndroid","Complete: TextView")}
        )
        //Rx co ban
        //Tao Observable #1

//       Observable.just(1,2,3)
//               .subscribe(
//                       {result->Log.d("RxAndroid","Observable.just -onNext: ${result}")},
//                       {error->Log.d("RxAndroid","Observable.just  -onError: ${error.message}")},
//                       {Log.d("RxAndroid","Observable.just -onCompleted: Completed")}
//               )
//        Observable.just(1, 2, 3, 4)
//                .subscribeOn(Schedulers.newThread()) //Each subscription is going to be on a new thread
//                .observeOn(AndroidSchedulers.mainThread()) //Observation on a main thread
//                //here is subscriber
//                .subscribe(
//                        { result -> Log.d("RxAndroid", "Observable.just -onNext: ${result}") },
//                        { error -> Log.d("RxAndroid", "Observable.just  -onError: ${error.message}") },
//                        { Log.d("RxAndroid", "Observable.just -onCompleted: Completed") }
//                )
//        Observable.just("this is a string","hello")
//                .observeOn(Schedulers.newThread())
//                .map { text -> text.length }
//                .map { length -> 2 * length }
//                .subscribe({ number -> Log.d("RxAndroid", "Number=${number}") })

        Observable.just("Thread Concept")
                .map { Log.d("RxAndroid", Thread.currentThread().getName()) }
                .subscribeOn(Schedulers.newThread())
                .subscribe({ Log.d("RxAndroid", Thread.currentThread().getName()) })


        button.setOnClickListener({
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })
    }


}
