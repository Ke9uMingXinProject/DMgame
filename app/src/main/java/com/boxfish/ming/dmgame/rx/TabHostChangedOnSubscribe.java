package com.boxfish.ming.dmgame.rx;

import android.widget.TabHost;

import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func0;

import static com.jakewharton.rxbinding.internal.Preconditions.checkUiThread;

final class TabHostChangedOnSubscribe implements Observable.OnSubscribe<String> {
    final TabHost view;
    final Func0<Boolean> handled;

    TabHostChangedOnSubscribe(TabHost view, Func0<Boolean> handled) {
        this.view = view;
        this.handled = handled;
    }

    @Override
    public void call(final Subscriber<? super String> subscriber) {
        checkUiThread();
        TabHost.OnTabChangeListener listener = s -> {
            if (handled.call()) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(s);
                }
            }
        };
        view.setOnTabChangedListener(listener);

        subscriber.add(new MainThreadSubscription() {
            @Override
            protected void onUnsubscribe() {
                view.setOnTabChangedListener(null);
            }
        });
    }
}
