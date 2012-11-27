package course.xml.sax;

import java.io.IOException;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXExample {

	public static void main(String[] args) throws Exception {
		new SAXExample().parse();

	}

	private void parse() throws ParserConfigurationException, SAXException,	IOException {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		parserFactory.setValidating(false);
		parserFactory.setNamespaceAware(false);
		SAXParser parser = parserFactory.newSAXParser();
		InputSource inputSource = new InputSource(getClass().getClassLoader().getResourceAsStream("freedb.xml"));
		parser.parse(inputSource, new SAXExampleDefaultHandler());
	}

	public static class SAXExampleDefaultHandler extends DefaultHandler {

		private long count;

		private Stack<String> stack = new Stack<String>();
		private StringBuilder buffer = new StringBuilder();

		public void characters(char[] ch, int start, int length) {
			buffer.append(ch, start, length);
		}

		public void endElement(String uri, String localName, String name) {
			stack.pop();

			String value = buffer.toString().trim();
			if (!value.isEmpty()) {
				String indent = StringUtils.repeat("\t", stack.size());
				System.out.println(indent + "[" + name + "] " + value);
			}
			buffer.setLength(0);
		}

		public void startElement(String uri, String localName, String name,
				Attributes attributes) {
			stack.push(name);
			count++;
		}

		public void endDocument() {
			System.out.println("Im Dokument sind " + count + " Elemente");
		}

		@Override
		public void startDocument() throws SAXException {
			System.out.println("Dokument beginnt.");
		}
		
		

	}

}
