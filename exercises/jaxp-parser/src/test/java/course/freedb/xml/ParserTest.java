package course.freedb.xml;

import org.junit.Test;

import course.freedb.service.FreeDBFactory;
import course.freedb.service.IFreeDBDictionary;
import course.freedb.service.ITrackList;
import course.freedb.service.impl.ParserType;

public class ParserTest {

	@Test
	public void testDOM() {
		IFreeDBDictionary dictionary = FreeDBFactory.createDictionary(ParserType.DOM);
		ITrackList list = retrieveList(dictionary);
		printTrackList(list);
	}

	@Test
	public void testSAX() {
		IFreeDBDictionary dictionary = FreeDBFactory.createDictionary(ParserType.SAX);
		ITrackList list = retrieveList(dictionary);
		printTrackList(list);
	}

	@Test
	public void testStAX() {
		IFreeDBDictionary dictionary = FreeDBFactory.createDictionary(ParserType.StAX);
		ITrackList list = retrieveList(dictionary);
		printTrackList(list);
	}

	private ITrackList retrieveList(IFreeDBDictionary dictionary) {
		long start = System.currentTimeMillis();
		ITrackList list = dictionary.findTracks(null);
		long time = System.currentTimeMillis() - start;
		System.out.println("Tracks found " + list.length() + " in " + time);
		return list;
	}

	private void printTrackList(ITrackList list) {
//		for (int i = 0; i < list.length(); i++) {
//			System.out.println(list.getTrack(i));
//		}
	}

}
