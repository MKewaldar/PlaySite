/**
 * 
 */
package models;

import io.ebean.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Marlon Kewaldar
 * Class representing a copy of a song.
 */

@Entity

public class Song extends Model {

    @Id
	private Integer id;
    private String title;
    private int priceInDollars;
    private String artist;
    private Integer durationInMinutes;

    public static Finder<Integer, Song> find = new Finder<>(Song.class);


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(int priceInDollars) {
        this.priceInDollars = priceInDollars;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
