package course.jaxb.xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Category entity object
 *
 * @@author Ingo Düppe, Sebastian Roekens
 */
@XmlRootElement(namespace = Constants.NAMESPACE_DATATYPES)
@XmlType(propOrder = {Constants.PROPERTY_PARENT, Constants.PROPERTY_CHILDREN, Constants.PROPERTY_COURSES}, namespace = Constants.NAMESPACE_DATATYPES)
public class Category extends Entity {

    private Category parent;

    private List<Category> children;

    private List<Course> courses;

    public Category() {
    }

    public Category(Long id) {
        setId(id);
    }

    /**
     * Convenience method for dependency check to prevent circular dependencies.
     * True if circular dependency would be created.
     *
     * @param newChildCategory new child category to be added to this
     * @return true, if newChildCategory is present in hierarchy above this, else false
     */
    private boolean checkForCircularDependencies(Category newChildCategory) {
        if (this.equals(newChildCategory)) {
            return true;
        }
        if (this.isRoot()) {
            return false;
        }
        return this.parent.checkForCircularDependencies(newChildCategory);
    }

    /**
     * Private method for adding category to list of children.
     * If list of children does not exist, it is created.
     *
     * @param category child category
     * @return success of operation
     */
    private boolean addChild(Category category) {
        if (this.children == null) {
            this.children = new ArrayList<Category>();
        }
        if (checkForCircularDependencies(category)) {
            return false;
        }
        return this.children.add(category);
    }

    /**
     * Convenience method for parent <-> children connection of categories.
     * Parent of this is set to parent category and list of children of parent category
     * is updated with this.
     *
     * @param parent parent category
     * @return Success of operation
     */
    public boolean addToParentCategory(Category parent) {
        this.parent = parent;
        return parent.addChild(this);
    }


    @XmlElementWrapper(name = Constants.CATEGORIES)
    @XmlElement(name = Constants.CATEGORY)
    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    @XmlElementWrapper(name = Constants.COURSES)
    @XmlElement(name = Constants.COURSE)
    @XmlIDREF
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @XmlElement(name = Constants.PARENT)
    @XmlIDREF
    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }


    /**
     * Convenience method for checking if category is root category.
     *
     * @return true if category is root category, else returning false
     */
    @XmlTransient
    public boolean isRoot() {
        return (parent == null);
    }

}
