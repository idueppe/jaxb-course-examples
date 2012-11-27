package course.jaxb.xml;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Entity object - super class of other entity types
 * @author Sebastian Roekens
 *
 */
@XmlRootElement(namespace=Constants.NAMESPACE_DATATYPES)
@XmlType(propOrder={Constants.ID, Constants.PROPERTY_ATTRIBUTES}, namespace=Constants.NAMESPACE_DATATYPES)
public class Entity{
	
	private Long id;
	
	private List<Attribute> attributes;
	
	public Entity(){
	}
	
	public Entity(Long id){
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Entity)) {
			return false;
		}
		if (this.id == null) {
			return false;
		} else {
			return this.id.equals(((Entity) obj).id);
		}
	}

	@Override
	public int hashCode() {
		if (this.id == null) {
			return super.hashCode();
		} else {
			return this.id.hashCode();
		}
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append(id).toString();
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@XmlID
    @XmlJavaTypeAdapter(value=IdAdapter.class)
    @XmlElement(name=Constants.ID)
	public Long getId() {
		return id;
	}

	@XmlElementWrapper(name=Constants.ATTRIBUTES)
	@XmlElement(name=Constants.ATTRIBUTE)
	public List<Attribute> getAttributes() {
		return attributes;
	}

	private TransientAttribute attribute2TransientAttribute(Attribute attribute){
		return new TransientAttribute(attribute.getName(), attribute.getValue());
	}
	
	private PersistentAttribute attribute2PersistentAttribute(Attribute attribute){
		return new PersistentAttribute(attribute.getName(), attribute.getValue());
	}
	
	public void setAttributes(List<Attribute> attributes) {
		List<Attribute> newAttributeList = new ArrayList<Attribute>();
		for (Attribute att : attributes){
			if (att.isPersistent()){
				newAttributeList.add(attribute2PersistentAttribute(att));
			} else{
				newAttributeList.add(attribute2TransientAttribute(att));
			}
		}
		this.attributes = newAttributeList;
	}
}