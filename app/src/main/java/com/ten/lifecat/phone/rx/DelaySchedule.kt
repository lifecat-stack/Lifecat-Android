package com.ten.lifecat.phone.rx

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit


class DelaySchedule {
    fun delay() {
        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { t: Long? ->
                    {

                    }
                }
    }
}