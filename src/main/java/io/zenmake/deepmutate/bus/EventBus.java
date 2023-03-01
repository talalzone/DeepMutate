package io.zenmake.deepmutate.bus;

import com.jakewharton.rxrelay3.ReplayRelay;
import io.reactivex.rxjava3.core.Observer;

/**
 * EventBus: Not used by any component and will be removed.
 * <p></p>
 * Created by Talal Ahmed on 23/02/2023
 */
@Deprecated
public class EventBus<T> {

    private static final EventBus INSTANCE = new EventBus();

    private final ReplayRelay<T> relay = ReplayRelay.create();

    private EventBus() {
    }

    public static <T> EventBus<T> getInstance() {
        return INSTANCE;
    }

    public void send(T msg){
        relay.accept(msg);
    }

    public void subscribe(Observer<T> o) {
        relay.subscribe(o);
    }

}
