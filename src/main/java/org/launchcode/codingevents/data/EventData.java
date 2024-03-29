package org.launchcode.codingevents.data;



import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    //place to put events
    private static Map<Integer, Event> events = new HashMap<>();

    //get all events
    public static Collection<Event> getAllEvents() {
        return events.values();
    }

    //get a single event
    public static Event getById(int id) {
        return events.get(id);
    }

    //add an event to collection
    public static void add(Event event) {
        events.put(event.getId(), event);
    }

    //remove an event from the collection
    public static void remove(int id) {
        events.remove(id);
    }
}
