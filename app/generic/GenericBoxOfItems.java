package generic;

import models.Song;


/**
 * This is a generic class. No relevance to the project; purely to show off for SRE2A. Will be removed
 * after final code review.
 * @param <T> Generic type that the box can hold.
 */
public class GenericBoxOfItems<T> {

    private T itemAdded;

    /**
     * Add an item to the box
     * @param t generic type
     */
    public void addItemToBox(T t) {
        this.itemAdded = t;
    }

    /**
     * Get the item in the box
     * @return generic item in the box
     */
    public T getItemAdded() {
        return itemAdded;
    }

    /**
     * Test function to show the concept works.
     * @param args
     */
    public static void main(String[] args) {
        GenericBoxOfItems<Song> boxWithSongs = new GenericBoxOfItems<Song>();
        GenericBoxOfItems<String> boxWithWords = new GenericBoxOfItems<String>();


        Song testSong1 = new Song();
        Song testSong2 = new Song();

        String testString1 = "TestString1";
        String testString2 = "TestString2";

        boxWithSongs.addItemToBox(testSong1);
        boxWithWords.addItemToBox(testString2);

        System.out.println(boxWithSongs.getItemAdded().toString());
        System.out.println(boxWithWords.getItemAdded().toString());
    }

}
