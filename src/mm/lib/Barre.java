package mm.lib;

import java.util.HashMap;

public class Barre {
	private static final HashMap<String, Integer[]> OFFSETS = new HashMap<String, Integer[]>() {
		private static final long serialVersionUID = 1L;
		HashMap<String, Integer[]> init() {
			this.put("Major",	new Integer[] {0, 2, 2, 1, 0, 0});
			this.put("minor",	new Integer[] {0, 2, 2, 0, 0, 0});
			
			this.put("6",		new Integer[] {null, 0, 3, 3, 3, 3});
			this.put("m6",		new Integer[] {null, 1, null, 0, 2, 1});
			this.put("7",		new Integer[] {0, 2, 0, 1, 0, 0});
			this.put("maj7",	new Integer[] {null, 0, 2, 1, 2, 0});
			this.put("m7",		new Integer[] {0, 2, 0, 0, 0, 0});
			this.put("9",		new Integer[] {0, 2, 0, 1, 0, 2});
			this.put("maj9",	new Integer[] {null, 1, 0, 2, 1, 0});
			this.put("m9",		new Integer[] {0, 2, 0, 0, 0, 2});
			this.put("11",		new Integer[] {0, 0, 0, 1, 0, 0});
			this.put("maj11",	new Integer[] {null, 2, 1, 3, 0, 0});
			this.put("m11",		new Integer[] {0, 0, 0, 0, 0, 0});
			this.put("13",		new Integer[] {0, null, 0, 1, 2, 2});
			this.put("maj13",	new Integer[] {1, 0, 0, 0, 1, 0});
			this.put("m13",		new Integer[] {0, 2, 0, 0, 2, 2});
			
			this.put("dim",		new Integer[] {0, 1, 2, 0, null, null});
			this.put("dim7",	new Integer[] {1, null, 0, 1, 0, null});
			this.put("aug",		new Integer[] {3, 2, 1, 0, 0, null});
			this.put("sus2",	new Integer[] {null, 0, 2, 2, 0, 0});
			this.put("sus4",	new Integer[] {0, 2, 2, 2, 0, 0});
			this.put("sus2sus4",new Integer[] {0, 0, 2, 2, 0, 2});
			this.put("add9",	new Integer[] {3, 0, 0, 0, 0, null});
			this.put("-5",		new Integer[] {0, 1, 2, 1, null, null});

			//maj7b5
			//maj7#5		
			//madd9	
			//m6add9	
			//mmaj7
			//mmaj9
			//m7b5
			//m7#5
			//7sus4
			//7b5
			//7#5
			//7b9
			//7#9
			//7b5b9
			//7b5#9
			//7#5b9
			//7#5#9
			//9b5
			//9#5
			//13#11
			//13b9
			//11b9

			return this;
		}
	}.init();
	
	public static Integer[] get(String label) {
		return OFFSETS.get(label);
	}

}
