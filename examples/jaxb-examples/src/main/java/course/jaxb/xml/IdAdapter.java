package course.jaxb.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter class to convert ids from String to Long and back 
 * @author Ingo Düppe, Sebastian Roekens
 *
 */
public class IdAdapter extends XmlAdapter<String, Long>{

	
	
	@Override
	public Long unmarshal(String v) throws Exception {
		return Long.parseLong(v);
	}

	@Override
	public String marshal(Long v) throws Exception {
		return String.valueOf(v);
	}


}
