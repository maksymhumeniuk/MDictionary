package ua.com.mdictionary.core.utils.transformers;

import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public final class FlowableRxTransformers {
    public static <T> FlowableTransformer<T, T> applyApiRequestSchedulers() {
        return tObservable -> tObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> FlowableTransformer<T, T> applyOnBeforeAndAfter(Action before, Action after) {
        return observable -> observable
                .doAfterTerminate(after)
                .doOnCancel(after)
                .doOnSubscribe(disposable -> before.run());
    }
}
