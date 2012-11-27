package course.freedb.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;

import course.freedb.domain.Album;
import course.freedb.domain.Dictionary;
import course.freedb.domain.Track;

public class JAXBTest {

	@Test
	public void testResource() {
		assertNotNull(getClass().getClassLoader().getResourceAsStream("freedb.xml"));
	}

	@Test
	public void testUnmarschallXML() {
		try {
			JAXBContext context = JAXBContext.newInstance(Dictionary.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("freedb.xml");
			Dictionary dictionary = (Dictionary) unmarshaller.unmarshal(inputStream);
			assertNotNull(dictionary);
			assertFalse(dictionary.getAlbums().isEmpty());
			Album album = dictionary.getAlbums().get(0);
			assertNotNull(album.getName());
			assertFalse(dictionary.getAlbums().get(0).getTracks().isEmpty());
			assertNotNull(album.getTracks().get(0).getAlbum());
			assertEquals(album, album.getTracks().get(0).getAlbum());
		} catch (JAXBException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testMarshallXML() {
		Dictionary dictionary = new Dictionary();
		Album album = new Album();
		album.setArtist("Artist");
		album.setDiscId("discID");
		album.setGenre("genre");
		album.setYear(12345);
		dictionary.getAlbums().add(album);
		Track track = new Track();
		track.setAlbum(album);
		track.setTitle("title");
		track.setTrackNo(1);
		album.getTracks().add(track);

		String outputXml = "";
		try {
			JAXBContext context = JAXBContext.newInstance(Dictionary.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Writer writer = new StringWriter();
			marshaller.marshal(dictionary, writer);

			outputXml = writer.toString();
			writer.close();

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		System.out.println(outputXml);
		assertTrue(outputXml != null && !outputXml.isEmpty());

	}

	@Test
	public void testGenerateSchema() {
		try {
			JAXBContext context = JAXBContext.newInstance(Dictionary.class);

			// create schema
			final List<DOMResult> results = new ArrayList<DOMResult>();
			try {
				context.generateSchema(new SchemaOutputResolver() {
					@Override
					public Result createOutput(String ns, String file)
							throws IOException {
						DOMResult result = new DOMResult();
						result.setSystemId(file);
						results.add(result);
						return result;
					}
				});
				for (DOMResult result : results) {
					System.out.println("----- Generated XML Schema: ");
					printDOMResult(result);
				}
			} catch (IOException e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private void printDOMResult(DOMResult domResult) {
		try {
			DOMSource ds = new DOMSource(domResult.getNode());
			Writer target = new StringWriter();
			Transformer transformer;
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(ds, new StreamResult(target));
			System.out.println(target.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
