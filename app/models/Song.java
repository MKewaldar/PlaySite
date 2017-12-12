/**
 * 
 */
package models;

import io.ebean.*;
import play.data.validation.Constraints;

import javax.persistence.Id;

/**
 * @author Marlon Kewaldar
 * Class representing a copy of a song.
 */

@javax.persistence.Entity

public class Song extends Model implements Entity {

    //The @Id indicated that eBean treats the id field as the primary key
    @Id
	private Integer id;

    @Constraints.Required
    @Constraints.MinLength(5)
    @Constraints.MaxLength(30)
    private String title;

    @Constraints.Required
    @Constraints.Min(5)
    @Constraints.Max(100)
    private int priceInDollars;

    @Constraints.Required
    @Constraints.MinLength(5)
    @Constraints.MaxLength(60)
    private String artist;

    @Constraints.Min(1)
    @Constraints.Max(20)
    @Constraints.Required
    private Integer durationInMinutes;

    public static Finder<Integer, Song> find = new Finder<>(Song.class);

    public Song () {

    }
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

    @Override
    public Entity returnSelf() {
        return this;
    }
}
