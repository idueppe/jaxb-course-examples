package course.freedb.xml;

import java.io.InputStream;

import org.xml.sax.InputSource;

import course.freedb.service.impl.ParserStrategy;


public abstract class AbstractParserStrategy implements ParserStrategy{

    private String xmlFile = "freedb.xml";
    
    protected InputSource getXmlAsInputSource() {
    	return new InputSource(getXmlAsInputStream());
    }

	protected InputStream getXmlAsInputStream() {
		return getClass().getClassLoader().getResourceAsStream(xmlFile);
	}

	
}
