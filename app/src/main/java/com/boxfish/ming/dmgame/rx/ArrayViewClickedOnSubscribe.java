package com.boxfish.ming.dmgame.rx;

import android.view.View;

import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func0;

import static com.jakewharton.rxbinding.internal.Preconditions.checkUiThread;

final class ArrayViewClickedOnSubscribe implements Observable.OnSubscribe<View> {
    final View[] view;
    final Func0<Boolean> handled;

    ArrayViewClickedOnSubscribe(Func0<Boolean> handled,View ...view) {
        this.view = view;
        this.handled = handled;
    }

    @Override
    public void call(final Subscriber<? super View> subscriber) {
        checkUiThread();
        View.OnClickListener listener = v -> {
            if (handled.call()) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(v);
                }
            }
        };

        for(View v:view){
            v.setOnClickListener(listener);
        }

        subscriber.add(new MainThreadSubscription() {
            @Override
            protected void onUnsubscribe() {

                for(View v:view){
                    v.setOnClickListener(null);
                }
            }
        });
    }
}
