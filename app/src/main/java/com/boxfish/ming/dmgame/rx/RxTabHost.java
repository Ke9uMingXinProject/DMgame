package com.boxfish.ming.dmgame.rx;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.widget.CheckedTextView;
import android.widget.TabHost;

import com.jakewharton.rxbinding.internal.Functions;

import rx.Observable;
import rx.functions.Action1;

import static com.jakewharton.rxbinding.internal.Preconditions.checkNotNull;

/**
 * Static factory methods for creating {@linkplain Action1 actions} for {@link CheckedTextView}.
 */
public final class RxTabHost {

    /**
     * An action which sets the checked property of {@code view} with a boolean value.
     * <p>
     * <em>Warning:</em> The created observable keeps a strong reference to {@code view}. Unsubscribe
     * to free this reference.
     */
    @CheckResult
    @NonNull
    public static Observable<String> onChanged(@NonNull TabHost view) {
        checkNotNull(view, "view == null");
        return Observable.create(new TabHostChangedOnSubscribe(view, Functions.FUNC0_ALWAYS_TRUE));
    }

    private RxTabHost() {
        throw new AssertionError("No instances.");
    }
}
