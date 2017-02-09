package org.wxh.bestpractice.current.concurrency_in_practice.Example5_19;

import java.util.concurrent.*;

/**
 * Created by wangxh on 16-12-26.
 * Package org.wxh.bestpractice.current.concurrency_in_practice.Example5_19
 * DES:
 */

interface Computable<A, V> { V compute(A arg) throws ExecutionException, InterruptedException; }

public class Memoizer<A, V> implements Computable<A, V>  {

    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> computable;

    public Memoizer(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(final A arg) throws ExecutionException, InterruptedException {
        Future<V> result = cache.get(arg);
        if (result == null) {
            // org.wxh.bestpractice.lambda -> Callable的 Call 方法
            FutureTask<V> futureTask = new FutureTask<V>( () -> this.computable.compute(arg) );
            result = futureTask;
            cache.put(arg, futureTask);
            futureTask.run();
        }
        return result.get();
    }
}
