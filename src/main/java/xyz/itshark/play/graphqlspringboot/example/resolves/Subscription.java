package xyz.itshark.play.graphqlspringboot.example.resolves;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import xyz.itshark.play.graphqlspringboot.example.pojo.Hello;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class Subscription implements GraphQLSubscriptionResolver {


    public Publisher<Hello> data() {
        Observable<Hello> observable = Observable.create( e -> {
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            executorService.scheduleAtFixedRate(() -> {
                Hello h = new Hello();
                h.setMessage("hello " + new Date().toString());
                e.onNext(h);
            }, 0, 2, TimeUnit.SECONDS);
        });

        ConnectableObservable connectableObservable = observable.share().publish();
        connectableObservable.connect();
        return connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

}
