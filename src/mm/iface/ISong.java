package mm.iface;

import java.util.LinkedList;
import mm.util.MidiTrack;

public interface ISong {
	public String getName();
	public void setName(String name);
	public int getNumTracks();
	public int getTimeSig();
	public void setTimeSig(int timeSig);
	public void addTrack(MidiTrack newTrack);
	public LinkedList<MidiTrack> getTracks();	
}
