package com.example.teiyuueki.tablayout3.models;

/**
 * Created by teiyuueki on 2016/04/17.
 */
public class ListPersonItems {

    private static final String LARGE_BASE_URL = "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/large/";
    private static final String THUMB_BASE_URL = "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/";

    public static ListPersonItems[] ITEMS = new ListPersonItems[] {
            new ListPersonItems("Flying in the Light", "Romain Guy", "flying_in_the_light.jpg"),
            new ListPersonItems("Caterpillar", "Romain Guy", "caterpillar.jpg"),
            new ListPersonItems("Look Me in the Eye", "Romain Guy", "look_me_in_the_eye.jpg"),
            new ListPersonItems("Flamingo", "Romain Guy", "flamingo.jpg"),
            new ListPersonItems("Rainbow", "Romain Guy", "rainbow.jpg"),
            new ListPersonItems("Over there", "Romain Guy", "over_there.jpg"),
            new ListPersonItems("Jelly Fish 2", "Romain Guy", "jelly_fish_2.jpg"),
            new ListPersonItems("Lone Pine Sunset", "Romain Guy", "lone_pine_sunset.jpg"),
    };

    public static ListPersonItems getItem(int id) {
        for (ListPersonItems listPersonItems : ITEMS) {
            if (listPersonItems.getId() == id) {
                return listPersonItems;
            }
        }
        return null;
    }

    private final String mName;
    private final String mAuthor;
    private final String mFileName;

    ListPersonItems(String name, String author, String fileName) {
        mName = name;
        mAuthor = author;
        mFileName = fileName;
    }

    public int getId() {
        return mName.hashCode() + mFileName.hashCode();
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getName() {
        return mName;
    }

    public String getPhotoUrl() {
        return LARGE_BASE_URL + mFileName;
    }

    public String getThumbnailUrl() {
        return THUMB_BASE_URL + mFileName;
    }

}
