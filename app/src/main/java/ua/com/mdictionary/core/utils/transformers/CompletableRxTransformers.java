package ua.com.mdictionary.core.utils.transformers;

import io.reactivex.CompletableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class CompletableRxTransformers {
    public static CompletableTransformer applyApiRequestSchedulers() {
        return tObservable -> tObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static CompletableTransformer applyOnBeforeAndAfter(Action before, Action after) {
        return observable -> observable
                .doAfterTerminate(after)
                .doFinally(after)
                .doOnSubscribe(disposable -> before.run());
    }
}
