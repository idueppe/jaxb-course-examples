package course.jaxb.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Role entity object
 * @author Ingo Düppe, Sebastian Roekens
 *
 */
@XmlRootElement(namespace=Constants.NAMESPACE_DATATYPES)
@XmlType(propOrder={Constants.TYPE, Constants.ACCOUNT, Constants.COURSE}, namespace=Constants.NAMESPACE_DATATYPES)
public class Role extends Entity{
	
	private RoleType type;
	
	private Account account;
	
	private Course course;
	
	public static final String FIND_BY_ACCOUNT_AND_COURSE = "Role.findByAccountAndCourse";
	
	public Role(){		
	}
	
	/**
	 * Convenience method to add role to a course and an account.
	 * Role is added to roles list of course and account object, and
	 * course and account are added to role object 
	 * @param course target course role is associated to
	 * @param account target account role is associated to
	 * @return success of operation
	 */
	public boolean addToCourseAndAccount(Course course, Account account){
		if ((course==null)||(account==null)){
			return false;
		}
		List<Role> courseRoles = course.getRoles();
		if (courseRoles==null){
			courseRoles = new ArrayList<Role>();
		}
		List<Role> accountRoles = account.getRoles();
		if (accountRoles==null){
			accountRoles = new ArrayList<Role>();
		}
		this.setAccount(account);
		this.setCourse(course);
		accountRoles.add(this);
		courseRoles.add(this);
		account.setRoles(accountRoles);
		course.setRoles(courseRoles);
		return true;
	}
	
	public Role(Long id, RoleType type){
		setId(id);
		this.type = type;
	}
	
	public Role(Long id) {
		setId(id);
	}

	@XmlElement(name=Constants.TYPE)
	public RoleType getType() {
		return type;
	}

	public void setType(RoleType type) {
		this.type = type;
	}

	@XmlElement(name=Constants.ACCOUNT_ID, required=true)
	@XmlIDREF
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@XmlElement(name=Constants.COURSE_ID, required=true)
	@XmlIDREF
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
