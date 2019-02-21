package mm.iface;

import mm.util.Note;

public interface IChord {
	public Note[] getNotes();
	public void setLabel(String label);
	public void setOctave(int octave);
	public void setFingering(int[] input);
	public Integer[] getFingering(int octave);
}
