package course.jaxb.xml;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Representation of an attribute object, which should not be saved persistent
 * @author Ingo Düppe, Sebastian Roekens
 *
 */
@XmlTransient
public class TransientAttribute extends Attribute {
	public TransientAttribute(){}
	
	public TransientAttribute(String name, String value){
		setName(name);
		setValue(value);
		setPersistent(false);
	}
}
