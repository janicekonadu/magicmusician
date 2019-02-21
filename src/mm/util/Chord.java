package mm.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import mm.iface.IChord;
import mm.iface.IEvent;

public class Chord implements IEvent, IChord {
	private String LABEL = "";
	private int OCTAVE = 1;
	private Note[] NOTES;
	public List<Note> WORKING;
	private long tick;
	
	Integer[] FINGERING = new Integer[6];
	Integer[] POS_1 = new Integer[6];
	Integer[] POS_2 = new Integer[6];
	Integer[] POS_3 = new Integer[6];
	
	public Chord() {
		this.WORKING = new LinkedList<>();
	}
	
	public void addNote(Note note) {
		WORKING.add(note);
	}
	
	public void finalize() {
		NOTES = new Note[WORKING.size()];
		WORKING.toArray(NOTES);
		WORKING = null;
	}
	
	public Chord(Note[] notes) {
		this.NOTES = notes;
	}
	
	public Chord(String label, Integer[] POS_1, Integer[] POS_2, Integer[] POS_3) {
		
	}
	
	
	public Chord(List<Integer> notes, long tick) {
		this.tick = tick;
		NOTES = new Note[notes.size()];
//		for (int i = 0; i < NOTES.length; i++) {
//			NOTES[i] = new Note(notes.get(i), tick);
//		}
	}

	public Note[] getNotes() {
		return NOTES;
	}

	@Override
	public String getLabel() {
		return this.LABEL;
	}
	
	@Override
	public void setLabel(String label) {
		this.LABEL = label;
	}
	
	@Override
	public int getOctave() {
		return this.OCTAVE;
	}

	@Override
	public void setOctave(int octave) {
		this.OCTAVE = octave;
	}

	public void setFingering(Integer[] input) {
		this.FINGERING = input;
	}

	@Override
	public Integer[] getFingering(int octave) {
		return FINGERING;
	}

	@Override
	public void setFingering(int[] input) {
		
	}
	
	public String toString() {
		return Arrays.toString(NOTES);
	}
}
