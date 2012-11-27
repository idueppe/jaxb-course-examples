package course.jaxb.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Attribute Adapter to map transient and persistent attributes
 * @author Ingo Düppe, Sebastian Roekens
 *
 */
public class AttributeAdapter extends XmlAdapter<Attribute, Attribute>{

	
	
	@Override
	public Attribute unmarshal(Attribute v) throws Exception {
		if (!v.isPersistent()){
			return new TransientAttribute(v.getName(), v.getValue());
		}
		return new PersistentAttribute(v.getName(), v.getValue());
	}

	@Override
	public Attribute marshal(Attribute v) throws Exception {
		return v;
	}


}
