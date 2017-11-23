/**
 * 
 */
package models;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marlon Kewaldar
 * Class representing a physical copy of a song.
 */
public class Song {

	private int id;
	private String title;
	private int priceInDollars;
	private String artist;
	private int durationInMinutes;
	
	public Song(int id, String title, int priceInDollars, String artist, int durationInMinutes) {
		this.id = id;
		this.title = title;
		this.priceInDollars = priceInDollars;
		this.artist = artist;
		this.durationInMinutes = durationInMinutes;
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
	 * @return the price
	 */
	public int getPrice() {
		return priceInDollars;
	}
	/**
	 * @param price the price to set
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
	
	private static Set<Song> songList;
	
	static {
		songList = new HashSet<>();
		songList.add(new Song(1, "Imagine", 29, "John Lennon", 502));
		songList.add(new Song(2, "Free Bird", 25, "Skrkdrd", 562));			
	}
}
