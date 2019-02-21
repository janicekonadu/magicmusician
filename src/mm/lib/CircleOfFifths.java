package mm.lib;

import java.util.ArrayList;

import mm.util.Note;

public class CircleOfFifths {
	private static final ArrayList<KeyTuple<Note, Note>> CIRCLE = new ArrayList<KeyTuple<Note, Note>>() {
		private static final long serialVersionUID = 1L;
		ArrayList<KeyTuple<Note, Note>> init() {
			this.add(new KeyTuple<Note, Note>(0x3C, 0x45)); // C  Major, a  minor
			this.add(new KeyTuple<Note, Note>(0x43, 0x40)); // G  Major, e  minor
			this.add(new KeyTuple<Note, Note>(0x3E, 0x47)); // D  Major, b  minor
			this.add(new KeyTuple<Note, Note>(0x45, 0x42)); // A  Major, gb minor
			this.add(new KeyTuple<Note, Note>(0x40, 0x3D)); // E  Major, db minor
			this.add(new KeyTuple<Note, Note>(0x47, 0x44)); // B  Major, ab minor
			this.add(new KeyTuple<Note, Note>(0x42, 0x3F)); // Gb Major, eb minor
			this.add(new KeyTuple<Note, Note>(0x3D, 0x46)); // Db Major, bb minor
			this.add(new KeyTuple<Note, Note>(0x44, 0x41)); // Ab Major, f  minor
			this.add(new KeyTuple<Note, Note>(0x3F, 0x3C)); // Eb Major, c  minor
			this.add(new KeyTuple<Note, Note>(0x46, 0x43)); // Bb Major, g  minor
			this.add(new KeyTuple<Note, Note>(0x41, 0x3E)); // F  Major, d  minor
			return this;
		}
	}.init();
	
	
	private static class KeyTuple <Major, minor> {
		private Note Major;
		private Note minor;
		
		public KeyTuple(int MajorKey, int minorKey) {
			this.Major = Notes.getNote(MajorKey);
			this.minor = Notes.getNote(minorKey);;
		}
		
		public Note getMajor() {
			return this.Major;
		}
		
		public Note getMinor() {
			return this.minor;
		}
	}
}
