package com.aa.sportstree.sportstree.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS_TEAMS = new ArrayList<DummyItem>();


    /**
            * An array of sample (dummy) items.
            */
    public static List<DummyItem> ITEMS_SPORTS = new ArrayList<DummyItem>();


    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_TEAMS_MAP = new HashMap<String, DummyItem>();


    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_SPORTS_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Ohio State Buckeyes"));
        addItem(new DummyItem("2", "Purdue Boilermakers"));
        addItem(new DummyItem("3", "USC Trojans"));
        addItem(new DummyItem("4", "Ohio State Buckeyes"));
        addItem(new DummyItem("5", "Purdue Boilermakers"));
        addItem(new DummyItem("6", "USC Trojans"));
        addItem(new DummyItem("7", "Ohio State Buckeyes"));
        addItem(new DummyItem("8", "Purdue Boilermakers"));
        addItem(new DummyItem("9", "USC Trojans"));
        addItem(new DummyItem("10", "Ohio State Buckeyes"));
        addItem(new DummyItem("11", "Purdue Boilermakers"));
        addItem(new DummyItem("12", "USC Trojans"));



        addSportsItem(new DummyItem("1", "Football"));
        addSportsItem(new DummyItem("2", "Soccer"));
        addSportsItem(new DummyItem("3", "Baseball"));
        addSportsItem(new DummyItem("4", "Basketball"));
        addSportsItem(new DummyItem("5", "Tennis"));


    }

    private static void addItem(DummyItem item) {
        ITEMS_TEAMS .add(item);
        ITEM_TEAMS_MAP.put(item.id, item);
    }


    private static void addSportsItem(DummyItem item) {
        ITEMS_SPORTS .add(item);
        ITEM_SPORTS_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
