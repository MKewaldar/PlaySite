package controllers;

import java.util.List;

import exceptions.SongNotFoundException;
import models.Song;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.songs.*;

import javax.inject.Inject;

/**
 * @author Marlon Kewaldar
 * This controller contains an action to handle HTTP requests
 * to the song overview pages
 */
public class SongController extends Controller {


    /**
     * Inject a formFactory from the Play library
     */
	@Inject
    FormFactory formFactory;


    /**
     * Directs user to the index page
     * @return Index Page View
     */
	public Result index() {
		List<Song> songList = Song.find.all();
		return ok(index.render(songList));
	}

    /**
     * Directs user to the creation page
     * @return Create Page View
     */
	public Result create() {
        Form<Song> songForm = formFactory.form(Song.class);
		return ok(create.render(songForm));
	}

    /**
     * Saves a song from the form on the Create page, then redirects to the index page.
     * @return Index Page View
     */
	public Result save() {
		Form<Song> songForm = formFactory.form(Song.class).bindFromRequest();
		Song song = songForm.get();
		song.save();
		return redirect(routes.SongController.index());
	}

    /**
     * TODO: Do this better
     * Edit a song, by essentially making a new one filled with the data from the old and saving it with some
     * edited fields
     * @param songId ID of the song to edit
     * @return Edit Page View
     */

	public Result edit(Integer songId) {
		Song song = Song.find.byId(songId);
		if(song == null) {
            try {
                throw new SongNotFoundException();
            } catch (SongNotFoundException e) {
                e.printStackTrace();
            }
            return notFound("[EDIT] This song doesn't exist!");
        }
		Form<Song> songForm = formFactory.form(Song.class).fill(song);
	    return ok(edit.render(songForm));
	}

    /**
     * Delete a song based on the ID given
     * @param songId ID of the song to delete
     * @return Index Page View
     */
	public Result delete(Integer songId) {
	    Song song = Song.find.byId(songId);
	    if(song == null) {
            try {
                throw new SongNotFoundException();
            } catch (SongNotFoundException e) {
                e.printStackTrace();
            }
            return notFound("[Delete] This song doesn't exist!");
        }
        song.delete();
		return redirect(routes.SongController.index());
	}

    /**
     * Show all the information (save the ID) in an overview page
     * @param songId ID of the song to show
     * @return Song Index View
     */
	public Result show(Integer songId) {
        Song song = Song.find.byId(songId);
        if (song == null) {
            try {
                throw new SongNotFoundException();
            } catch (SongNotFoundException e) {
                e.printStackTrace();
            }
            return notFound("[SHOW] This song doesn't exist!");
        }
        return ok(show.render(song));
    }

    /**
     * Works in conjunction with the edit method, overwriting the old song with the new song created there
     * @return Index Page View
     */
	public Result update() {
		Song song = formFactory.form(Song.class).bindFromRequest().get();
	    Song oldSong = Song.find.byId(song.getId());
	    if(oldSong == null) {
            try {
                throw new SongNotFoundException("Song not found!");
            } catch (SongNotFoundException e) {
                e.printStackTrace();
            }
            return notFound("[UPDATE] This song doesn't exist!");
        }
        //Don't change ID, because it's autoincremented in db
        oldSong.setTitle(song.getTitle());
        oldSong.setArtist(song.getArtist());
        oldSong.setPriceInDollars(song.getPriceInDollars());
        oldSong.update();
        oldSong.setId(oldSong.getId());

        return redirect(routes.SongController.index());
    }
}
