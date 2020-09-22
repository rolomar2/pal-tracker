package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    private Long countEntries = 1L;

    public TimeEntry create(TimeEntry timeEntry){
        timeEntry.setId(countEntries);
        timeEntries.put(timeEntry.getId(), timeEntry);
        countEntries++;

        return timeEntry;
    }

    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(!timeEntries.containsKey(id)){
            return null;
        }
        timeEntry.setId(id);
        timeEntries.put(id, timeEntry);
        return timeEntry;
    }

    public void delete(long id) {
        timeEntries.remove(id);
    }
}
