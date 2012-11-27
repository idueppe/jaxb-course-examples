package course.jaxb.xml;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Representation of an persistent attribute
 * @author Ingo Düppe, Sebastian Roekens
 *
 */
@XmlTransient
public class PersistentAttribute extends Attribute {
	
	
	private String name;
	
	private String value;
	
	public Entity entity;
	
	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	
	public PersistentAttribute(){}
	
	public PersistentAttribute(String name, String value){
		setName(name);
		setValue(value);
		setPersistent(true);
	}

}
