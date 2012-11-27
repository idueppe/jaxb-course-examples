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
 * Course entity object
 * @author Ingo Düppe, Sebastian Roekens
 *
 */
@XmlRootElement(namespace=Constants.NAMESPACE_DATATYPES)
@XmlType(propOrder={ Constants.CATEGORIES, Constants.PARENT, Constants.WORKGROUPS, Constants.ROLES}, namespace=Constants.NAMESPACE_DATATYPES)
public class Course extends Entity{
	
	private Course parent;
	
	private List<Course> workgroups;
	
	private List<Category> categories;
	
	private List<Role> roles;
	
	public Course(){
	}
	
	public Course(Long id){
		setId(id);
	}
	
	/**
	 * Convenience method to add this course to a category. 
	 * Updates category list of course object and course list of category object.
	 * @param category the category this course should be added to
	 * @return Success of operation
	 */
	public boolean addToCategory(Category category){
		if (category == null){
			return false;
		}
		List<Course> courses = category.getCourses();
		if (courses==null){
			courses = new ArrayList<Course>();
		}
		List<Category> categories = this.getCategories();
		if (categories == null){
			categories = new ArrayList<Category>();
		}
		categories.add(category);
		this.setCategories(categories);
		courses.add(this);
		category.setCourses(courses);
		return true;
	}
	
	/**
	 * Convenience method for adding course to a number of categories
	 * 
	 * @param categories List of categories course is to add to
	 */
	public void addToCagetories(List<Category> categories){
		for (Category category : categories){
			addToCategory(category);
		}
	}
	
	/**
	 * Convenience method to add this course as a workgroup to course
	 * @param course parent course
	 * @return success of operation
	 */
	public boolean addAsWorkgroupTo(Course course){
		if (course==null||(course.getParent()!=null)){
			return false;
		}
		List<Course> workgroups = course.getWorkgroups();
		if (workgroups == null){
			workgroups = new ArrayList<Course>();
		}
		workgroups.add(this);
		course.setWorkgroups(workgroups);
		this.setParent(course);
		return true;
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).toString();
	}
	
	@XmlElement(name=Constants.PARENT)
	@XmlIDREF
	public Course getParent() {
		return parent;
	}

	public void setParent(Course parent) {
		this.parent = parent;
	}

	@XmlElementWrapper(name=Constants.WORKGROUPS)
	@XmlElement(name=Constants.WORKGROUP)
	public List<Course> getWorkgroups() {
		return workgroups;
	}

	public void setWorkgroups(List<Course> workgroups) {
		this.workgroups = workgroups;
	}

	@XmlElementWrapper(name=Constants.CATEGORIES)
	@XmlElement(name=Constants.CATEGORY)
	@XmlIDREF
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@XmlElementWrapper(name=Constants.ROLES)
	@XmlElement(name=Constants.ROLE)
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
