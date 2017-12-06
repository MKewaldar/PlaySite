package controllers;

import java.util.Set;

import exceptions.SongNotFoundException;
import models.Song;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.songs.*;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the song overview pages.
 */
public class SongController extends Controller {


	@Inject
    FormFactory formFactory;


    /**
     * Directs user to the index page
     * @return Index Page View
     */
	public Result index() {
		Set<Song> songList = Song.getAllSongs();
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
		Song.add(song);
		return redirect(routes.SongController.index());
	}

    /**
     *
     * @param songId ID of the song to edit
     * @return Edit Page View
     */
	public Result edit(int songId) {
		Song song = Song.findById(songId);
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
     *
     * @param songId ID of the song to delete
     * @return Index Page View
     */
	public Result delete(int songId) {
	    Song song = Song.findById(songId);
	    if(song == null) {
            try {
                throw new SongNotFoundException();
            } catch (SongNotFoundException e) {
                e.printStackTrace();
            }
            return notFound("[Delete] This song doesn't exist!");
        }
        Song.delete(song);
		return redirect(routes.SongController.index());
	}
	
	public Result show(int songId) {
        Song song = Song.findById(songId);
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
	
	public Result update() {
		Song song = formFactory.form(Song.class).bindFromRequest().get();
	    Song oldSong = Song.findById(song.id);
	    if(oldSong == null) {
            try {
                throw new SongNotFoundException("Song not found!");
            } catch (SongNotFoundException e) {
                e.printStackTrace();
            }
            return notFound("[UPDATE] This song doesn't exist!");
        }
        oldSong.setTitle(song.getTitle());
        oldSong.setArtist(song.getArtist());
        oldSong.setPrice(song.getPrice());

        return redirect(routes.SongController.index());

    }
}
