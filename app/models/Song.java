/**
 * 
 */
package models;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marlon Kewaldar
 * Class representing a copy of a song.
 */
public class Song {

	public int id;
	public String title;
	public int priceInDollars;
	public String artist;
	public int durationInMinutes;
	public static Set<Song> songList;


	public Song() {

	}

	public Song(int id, String title, int priceInDollars, String artist, int durationInMinutes) {
		this.id = id;
		this.title = title;
		this.priceInDollars = priceInDollars;
		this.artist = artist;
		this.durationInMinutes = durationInMinutes;
	}

	static {
		songList = new HashSet<>();
		songList.add(new Song(1, "Imagine", 29, "John Lennon", 502));
		songList.add(new Song(2, "Free Bird", 25, "Skrkdrd", 562));
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return priceInDollars the priceInDollars to set
	 */
	public int getPrice() {
		return priceInDollars;
	}
	/**
	 * @param priceInDollars the priceInDollars to set
	 */
	public void setPrice(int price) {
		this.priceInDollars = price;
	}
	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/**
	 * @return the durationInMinutes
	 */
	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	/**
	 * @param durationInMinutes the durationInMinutes to set
	 */
	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	
	public static Set<Song> getAllSongs() {
		return songList;
	}
	
	public static Song findById(int id) {
		for (Song song: songList) {
			if(id == song.getId()) {
				return song;
			}
		}
		return null;
	}
	
	public static void add(Song songToAdd) {
		songList.add(songToAdd);
	}
	
	public static boolean delete(Song songToDelete) {
		return songList.remove(songToDelete); 
	}
}
