package course.jaxb.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Group entity object
 * @author Ingo Düppe, Sebastian Roekens
 *
 */
@XmlRootElement(namespace=Constants.NAMESPACE_DATATYPES)
@XmlType(propOrder={Constants.MEMBERS}, namespace=Constants.NAMESPACE_DATATYPES)
public class Group extends Account{

	private List<Account> members;
    
    public Group(){
    }
    
    public Group(Long id){
    	setId(id);
    }
	
	@Override
    public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Group)) {
			return false;
		}
		if (this.getId() == null) {
			return false;
		} else {
			return this.getId().equals(((Group) obj).getId());
		}
	}

	@Override
	public int hashCode() {
		if (this.getId() == null) {
			return super.hashCode();
		} else {
			return this.getId().hashCode();
		}
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append(this.getId()).toString();
	}

	public void setMembers(List<Account> members) {
		this.members = members;
	}

	@XmlElementWrapper(name=Constants.MEMBERS)
	@XmlElement(name=Constants.MEMBER)
	@XmlIDREF
	public List<Account> getMembers() {
		return members;
	}
}
