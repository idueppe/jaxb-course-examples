package course.jaxb.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Attribute entity object
 * @author Ingo Düppe, Sebastian Roekens
 *
 */
@XmlRootElement(namespace=Constants.NAMESPACE_DATATYPES)
@XmlType(namespace=Constants.NAMESPACE_DATATYPES)
@XmlJavaTypeAdapter(value=AttributeAdapter.class)
public class Attribute {

	private String name;
	
	private String value;
	
	
	private boolean persistent;
	
	public Attribute(){
	}
	
	@XmlAttribute(name=Constants.PROPERTY_PERSISTENT)
	public boolean isPersistent() {
		return persistent;
	}

	public void setPersistent(boolean persistent) {
		this.persistent = persistent;
	}

	@XmlAttribute(name=Constants.PROPERTY_NAME)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlValue
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
}
