package company.test;

import java.util.HashMap;

/**
 * @author ConfusedRobo
 * Dated: 09-09-2020
 * Do not modify.
 */
public class AnimeSite {
    private final HashMap<String, String> animes = new HashMap<>();
    private final String siteName;

    public AnimeSite(String siteName) {
        this.siteName = siteName;
    }

    public HashMap<String, String> getAnimes() {
        return new HashMap<>(animes);
    }

    public void addAnime(String name, String tags) {
        animes.put(name, tags);
        System.out.println("Anime added.");
    }

    public void removeAnime(String name) {
        if (!animes.containsKey(name)) {
            System.out.println("Anime not found.");
        } else {
            animes.remove(name);
            System.out.println("Anime removed.");
        }
    }

    public void removeByTag(String searchTag) {
        for (String key : animes.keySet()) {
            for (String tag : animes.get(key).split(", ")) {
                if (tag.equals(searchTag)) {
                    animes.remove(key);
                    removeByTag(searchTag);
                }
            }
        }

        System.out.println("Anime with " + searchTag + " are all removed.");
    }

    public void traverse() {
        System.out.println(siteName + " anime list:-");
        for (String key : animes.keySet()) {
            System.out.println("===================================");
            System.out.println("Anime: " + key);
            System.out.println("Tag(s): " + animes.get(key));
        }
    }
}
