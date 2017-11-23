package controllers;

import java.util.Set;

import models.Song;
import play.mvc.*;
import views.html.songs.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the song overview pages.
 */
public class SongController extends Controller {

	public Result index() {
		Set<Song> songList = Song.getAllSongs();
		return ok(index.render(songList));
	}
	
	public Result create() {
		return TODO;
	}
	
	public Result save() {
		return TODO;
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
