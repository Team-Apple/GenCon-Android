package com.github.teamapple.gencon.util.ext

import android.arch.lifecycle.*
import org.reactivestreams.Publisher

fun <T> Publisher<T>.toLiveData() = LiveDataReactiveStreams.fromPublisher(this) as LiveData<T>

fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T?) -> Unit) =
        observe(owner, Observer<T> { v -> observer.invoke(v) })

fun <X, Y> LiveData<X>.map(transformer: (X) -> Y): LiveData<Y> =
        Transformations.map(this, { transformer(it) })

