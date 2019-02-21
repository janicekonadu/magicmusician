package mm.tests;

import java.io.File;
import java.util.Arrays;

import org.junit.Test;

import mm.iface.IEvent;
import mm.util.MidiParser;
import mm.util.Song;

public class HarmonyTests {

	@Test
	public void testParse() {
			Song aSong = new MidiParser(new File("./data/midi/CantinaBand.mid")).parse();
			IEvent[][] anArray = aSong.split(1);
			for (IEvent[] a: anArray) {
				System.out.println(Arrays.toString(a));
			}
		
	}
}
