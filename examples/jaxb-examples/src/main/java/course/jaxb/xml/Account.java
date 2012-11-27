package course.jaxb.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Account entity object
 * @author Ingo Düppe, Sebastian Roekens
 */
@XmlRootElement(namespace=Constants.NAMESPACE_DATATYPES)
@XmlType(propOrder={Constants.GROUPS, Constants.ROLES}, namespace=Constants.NAMESPACE_DATATYPES)
public class Account extends Entity{
	
	private List<Role> roles;
	
	private List<Group> groups;
	
	public Account(){
	}
	
	public Account(Long id){
		setId(id);
	}
	
	/**
	 * Convenience method to add an account to a group
	 * @param group group account should be added to
	 * @return success of operation
	 */
	public boolean addToGroup(Group group){
		if(group==null){
			return false;
		}
		List<Group> groups = this.getGroups();
		if (groups==null){
			groups = new ArrayList<Group>();
		}
		if (groups.contains(group)||(group.getMembers()!=null && group.getMembers().contains(this))){
			return false;
		}
		groups.add(group);
		setGroups(groups);
		List<Account> accounts = group.getMembers();
		if (accounts == null){
			accounts = new ArrayList<Account>();
		}
		accounts.add(this);
		group.setMembers(accounts);
		return true;
	}
	
	/**
	 * Convenience method to remove an account from a group
	 * @param group group to remove account from
	 * @return success of operation
	 */
	public boolean removeFromGroup(Group group){
		if (group == null){
			return false;
		}
		List<Group> groups = this.getGroups();
		if ((!(groups==null) && !groups.contains(group))||!group.getMembers().contains(this)){
			return false;
		}
		groups.remove(group);
		setGroups(groups);
		List<Account> accounts = group.getMembers();
		accounts.remove(this);
		group.setMembers(accounts);
		return true;
	}
	
	/**
	 * Convenience method to check if account is member of a group
	 * @param group group to check membership of
	 * @return membership state of account and given group
	 */
	public boolean isInGroup(Group group){
		if (group == null){
			return false;
		}
		if (group.getMembers()==null){
			return false;
		}
		return (group.getMembers().contains(this));
	}
	
    @Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Account)) {
			return false;
		}
		if (this.getId() == null) {
			return false;
		} else {
			return this.getId().equals(((Account) obj).getId());
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

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append(this.getId()).toString();
	}
	
	@XmlElementWrapper(name=Constants.ROLES)
	@XmlElement(name=Constants.ROLE)
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@XmlElementWrapper(name=Constants.GROUPS)
	@XmlElement(name=Constants.GROUP)
	@XmlIDREF
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
}
