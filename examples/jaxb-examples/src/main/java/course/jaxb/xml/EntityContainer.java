package course.jaxb.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Container class for entity objects
 * @author Ingo Düppe, Sebastian Roekens
 *
 */
@XmlRootElement(namespace=Constants.NAMESPACE_DATATYPES)
@XmlType(namespace=Constants.NAMESPACE_DATATYPES)
public class EntityContainer{
	
	private Category rootCategory;
	
	private List<Course> courses;
	
	private List<Account> accounts;
	

	@XmlElement(name=Constants.CATEGORY)
	public Category getRootCategory() {
		return rootCategory;
	}

	@XmlElementWrapper(name=Constants.COURSES)
	@XmlElement(name=Constants.COURSE)
	public List<Course> getCourses() {
		return courses;
	}


	@XmlElementWrapper(name=Constants.ACCOUNTS)
	@XmlElements(value= {@XmlElement(name=Constants.ACCOUNT,type=Account.class), @XmlElement(name=Constants.GROUP,type=Group.class)})
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		if (courses==null){
			courses = new ArrayList<Course>();
		}
		if (accounts == null){
			accounts = new ArrayList<Account>();
		}
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE).append(rootCategory).append(courses.toArray()).append(accounts.toArray()).toString();
	}

	public void setRootCategory(Category rootCategory) {
		this.rootCategory = rootCategory;
	}
	
	
	
}