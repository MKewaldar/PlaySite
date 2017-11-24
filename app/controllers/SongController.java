package controllers;

import java.util.Set;

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



	public Result index() {
		Set<Song> songList = Song.getAllSongs();
		return ok(index.render(songList));
	}
	
	public Result create() {
        Form<Song> songForm = formFactory.form(Song.class);
		return ok(create.render(songForm));
	}
	
	public Result save() {
		Form<Song> songForm = formFactory.form(Song.class).bindFromRequest();
		Song song = songForm.get();
		Song.add(song);
		return redirect(routes.SongController.index());
	}
	
	public Result edit(int songId) {
		return TODO;
	}
	
	public Result delete(int songId) {
		return TODO;
	}
	
	public Result show(int songId) {
		return TODO;
	}
	
	public Result update() {
		return TODO;
	}
}
