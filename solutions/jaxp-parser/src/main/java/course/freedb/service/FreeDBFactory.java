package course.freedb.service;

import course.freedb.service.impl.FreeDBDictionary;
import course.freedb.service.impl.ParserType;
import course.freedb.xml.DOMParserStrategy;
import course.freedb.xml.SAXParserStrategy;
import course.freedb.xml.StAXParserStrategy;

/**
 * Copyright by Ingo Düppe
 * 
 * @author: Ingo Düppe - www.dueppe.com
 * 
 */
public class FreeDBFactory {

    public static IFreeDBDictionary createDictionary(ParserType type) {
    	switch (type) {
    		case SAX: 
    			return new FreeDBDictionary(new SAXParserStrategy());
    		case DOM:
    			return new FreeDBDictionary(new DOMParserStrategy());
    		case StAX:
    			return new FreeDBDictionary(new StAXParserStrategy());
    		default:
    			return null;
    	}
    }

}
