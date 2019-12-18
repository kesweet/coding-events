package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping //this method lives at /events, returns events/index page
    public String getAllEvents(Model model) {
        model.addAttribute("events", EventData.getAllEvents());
        return "events/index";
    }

    @GetMapping("create") //this method lives at /events/create
    public String renderCreateForm() {
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String diplayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAllEvents());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        Event eventToEdit = EventData.getById(eventId);
        model.addAttribute("event", eventToEdit);
        model.addAttribute("title", "Edit Event " + eventToEdit.getName() + "(id=" + eventToEdit.getId() + ")");
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String eventName, String eventDescription) {
        Event event = EventData.getById(eventId);
        event.setName(eventName);
        event.setDescription(eventDescription);
        return "redirect:";
    }

}
