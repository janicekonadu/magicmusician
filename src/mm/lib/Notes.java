package mm.lib;

import java.util.HashMap;
import mm.util.Note;


public class Notes {
	
	private static final HashMap<Integer, Note> NOTES = new HashMap<Integer, Note>() {
		private static final long serialVersionUID = 1L;
		HashMap<Integer, Note> init() {
			for (int k = 0; k < 128; k++) {
				this.put(k, new Note(k));
			}
			return this;
		}
	}.init();
	
	private static final HashMap<Note, Integer> KEYS = new HashMap<Note, Integer>() {
		private static final long serialVersionUID = 1L;
		HashMap<Note, Integer> init() {
			for (int k = 0; k < 128; k++) {
				this.put(NOTES.get(k), k);
			}
			return this;
		}
	}.init();
	
	public static Note getNote(int key) {
		return NOTES.get(key);
	}
	
	public static Integer getKey(Note note) {
		return KEYS.get(note);
	}
}
