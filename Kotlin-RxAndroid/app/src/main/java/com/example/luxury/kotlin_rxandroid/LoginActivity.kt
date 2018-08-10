package com.example.luxury.kotlin_rxandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.ObservableTransformer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        Observable.just("abcdefadwads")
//                .compose(lengthGreaterThanSix)
//                .compose(verifyEmailPattern)
//                .subscribe({
//                })
        //Another example

        val mUserObservable: BehaviorSubject<String> = BehaviorSubject.create()


        Observable.create(ObservableOnSubscribe<String> { emitter ->
            editTextAddFriend.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if ((s != null) && (s.length >= 3)) {
                        emitter.onNext(s.trim().toString())}
                    else { progessBar.visibility=View.INVISIBLE
                        buttonAddFriend.visibility=View.INVISIBLE
                        textViewAddFriendResult.text=""
                    }
                }

            })
        })
                .debounce(1500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({result->
                    progessBar.visibility=View.VISIBLE
                    mUserObservable.onNext(result)})

        mUserObservable
                .debounce (1000,TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({result->
                    progessBar.visibility=View.VISIBLE
                    //fetch server
                    if(findUser(result)) {
                        progessBar.visibility=View.INVISIBLE
                }
                    Log.d("RxAndroid","mUserObservable activated onNext")})



    }



    private fun findUser(user: String): Boolean {
        //fake fetch from server
        //
        if((user.equals("Luan")) || (user.equals("Han"))) return true
        else return false
    }


    private val lengthGreaterThanSix = ObservableTransformer<String, String> { observale ->
        observale.map { it.trim() }
                .filter { it.length > 6 }
                .singleOrError()
                .onErrorResumeNext {
                    if (it is NoSuchElementException) {
                        Single.error(Exception("Length should be greater than 6"))
                    } else Single.error(it)
                }
                .toObservable()
    }
    private val verifyEmailPattern = ObservableTransformer<String, String> { observable ->
        observable.map { it.trim() }
                .filter { Patterns.EMAIL_ADDRESS.matcher(it).matches() }
                .singleOrError()
                .onErrorResumeNext {
                    if (it is NoSuchElementException) Single.error(Exception("Email not valid"))
                    else Single.error(it)
                }
                .toObservable()
    }


}
