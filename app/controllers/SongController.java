package controllers;

import java.util.HashSet;

import exceptions.SongNotFoundException;
import models.Song;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.errors._404;
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
     *
     * @return Index Page View
     */
    public Result index() {
        //This used to be a List. I changed this to a HashSet because:
        // Big O Attributes for HashSet:
        // Adding elements: O(1)
        // using contains() function: O(1)
        // Checking next elements:  O(capacity/n)
        HashSet<Song> songList = new HashSet<>(Song.find.all());
        return ok(index.render(songList));
    }

    /**
     * Directs user to the creation page
     *
     * @return Create Page View
     */
    public Result create() {
        Form<Song> songForm = formFactory.form(Song.class);
        return ok(create.render(songForm));
    }

    /**
     * Saves a song from the form on the Create page, then redirects to the index page.
     *
     * @return Index Page View
     */
    public Result save() {
        Form<Song> songForm = formFactory.form(Song.class).bindFromRequest();
        //This checks form constrictions
        if (songForm.hasErrors()) {
            flash("danger", "Please make sure you filled out the fields correctly.");
            return badRequest(create.render(songForm));
        }
        Song song = songForm.get();
        song.save();
        flash("success", "Your song has been successfully saved!");
        return redirect(routes.SongController.index());
    }

    /**
     * TODO: Do this better
     * Edit a song, by essentially making a new one filled with the data from the old and saving it with some
     * edited fields
     *
     * @param songId ID of the song to edit
     * @return Edit Page View
     */

    public Result edit(Integer songId) {
        Song song = Song.find.byId(songId);
       // if (handleError(song)) return notFound(_404.render());
        Form<Song> songForm = formFactory.form(Song.class).fill(song);
        return ok(edit.render(songForm));
    }

    /**
     * Delete a song based on the ID given
     *
     * @param songId ID of the song to delete
     * @return Index Page View
     */
    public Result delete(Integer songId) {
        Song song = Song.find.byId(songId);
        //The if is generally not supposed to be triggered, but I added it just in case the HTTP request goes wrong
        if (song == null) {
            try {
                song.delete();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            flash("danger", "This song doesn't exist!");
            return notFound("[Delete] This song doesn't exist!");
        }
        song.delete();
        flash("success", "The song was successfully deleted!");
        return ok();
    }

    /**
     * Show all the information (save the ID) in an overview page
     *
     * @param songId ID of the song to show
     * @return Song Index View
     */
    public Result show(Integer songId) {
        Song song = Song.find.byId(songId);
        if (song == null) {
            flash("danger", "This song doesn't exist!");
            return notFound(_404.render());

        }
        return ok(show.render(song));
    }

    /**
     * Works in conjunction with the edit method, overwriting the old song with the new song created there
     *
     * @return Index Page View
     */
    public Result update() {
        Form<Song> songForm = formFactory.form(Song.class).bindFromRequest();

        if (songForm.hasErrors()) {
            flash("danger", "Please make sure you filled out the fields correctly.");
            return badRequest(create.render(songForm));
        }

        Song song = songForm.get();
        Song oldSong = Song.find.byId(song.getId());
        if (oldSong == null) {
            try {
                oldSong.setTitle(song.getTitle());
            } catch (NullPointerException j) {
                j.printStackTrace();

                flash("danger", "This song doesn't exist!");
                return notFound("[UPDATE] This song doesn't exist!");
            }
        }
        //Don't change ID, because it's autoincremented in db
        oldSong.setArtist(song.getArtist());
        oldSong.setPriceInDollars(song.getPriceInDollars());
        oldSong.setDurationInMinutes(song.getDurationInMinutes());
        oldSong.update();
        oldSong.setId(oldSong.getId());

        flash("success", "Your song has been successfully edited!");

        return ok();
    }
}
