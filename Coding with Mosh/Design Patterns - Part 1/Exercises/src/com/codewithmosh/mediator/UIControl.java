package com.codewithmosh.mediator;

import java.util.ArrayList;
import java.util.List;

public abstract class UIControl {
    private List<EventHandler> eventHandlers = new ArrayList<EventHandler>();

    public void attach (EventHandler eventHandler){
        eventHandlers.add(eventHandler);
    }

    protected void notifyEventHandlers(){
        for (var handler : eventHandlers){
            handler.update();
        }
    }
}
