class EventManager {
    // eventId -> priority
    private Map<Integer, Integer> map = new HashMap<>();

    // priority -> eventIds set
    private TreeMap<Integer, TreeSet<Integer>> priority = new TreeMap<>();

    public EventManager(int[][] events) {
        for (int[] event : events) {
            int eventId = event[0];
            int priorityVal = event[1];

            map.put(eventId, priorityVal);

            priority.putIfAbsent(priorityVal, new TreeSet<>());
            priority.get(priorityVal).add(eventId);
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        int curPriority = map.get(eventId);

        // remove from old priority
        TreeSet<Integer> set = priority.get(curPriority);
        set.remove(eventId);
        if (set.isEmpty()) {
            priority.remove(curPriority);
        }

        // add to new priority
        priority.putIfAbsent(newPriority, new TreeSet<>());
        priority.get(newPriority).add(eventId);

        // update map
        map.put(eventId, newPriority);
    }

    public int pollHighest() {
        if (priority.isEmpty()) return -1;

        Map.Entry<Integer, TreeSet<Integer>> entry = priority.lastEntry();
        int highestPriority = entry.getKey();
        TreeSet<Integer> set = entry.getValue();

        int eventId = set.first(); // smallest id among max priority
        set.remove(eventId);

        if (set.isEmpty()) {
            priority.remove(highestPriority);
        }

        map.remove(eventId);

        return eventId;
    }
}