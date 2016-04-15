package com.boxfish.ming.dmgame.rx;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckedTextView;

import com.jakewharton.rxbinding.internal.Functions;

import rx.Observable;
import rx.functions.Action1;

import static com.jakewharton.rxbinding.internal.Preconditions.checkNotNull;

/**
 * Static factory methods for creating {@linkplain Action1 actions} for {@link CheckedTextView}.
 */
public final class RxArrayView {

    /**
     * An action which sets the checked property of {@code view} with a boolean value.
     * <p>
     * <em>Warning:</em> The created observable keeps a strong reference to {@code view}. Unsubscribe
     * to free this reference.
     */
    @CheckResult
    @NonNull
    public static Observable<View> clicks(@NonNull View ...view) {
        checkNotNull(view, "view == null");
        return Observable.create(new ArrayViewClickedOnSubscribe(Functions.FUNC0_ALWAYS_TRUE,view));
    }

    private RxArrayView() {
        throw new AssertionError("No instances.");
    }
}
