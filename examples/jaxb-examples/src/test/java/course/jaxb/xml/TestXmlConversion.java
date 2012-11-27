package course.jaxb.xml;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import junit.framework.TestCase;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.bind.*;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sebastian Roekens
 */
public class TestXmlConversion extends TestCase {
    private static Long currentTimeMillis = System.currentTimeMillis();

    private Long createUniqueId() {
        return currentTimeMillis++;
    }

    @Test
    public void testAccountXml() {
        System.out.println("----- entering Account XML Test -----");
        //create and fetch account object
        EntityContainer container = generateTestStructure();
        Account account = null;
        for (Account acc : container.getAccounts()) {
            if (acc instanceof Account && !(acc instanceof Group)) {
                account = acc;
            }
        }
        if (account == null) {
            fail("no account object created");
        }

        //create jaxb context and marshaller
        Marshaller marshaller = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Account.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        //convert account object to xml
        String outputXml = "";
        try {
            Writer writer = new StringWriter();
            marshaller.marshal(account, writer);
            outputXml = writer.toString();
            writer.close();
        } catch (JAXBException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }
        assertTrue((outputXml != null) && (outputXml != ""));
        System.out.println(outputXml);

        //convert xml back to an object and assert equality to source object
        Account convertedAccount = null;
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            convertedAccount = (Account) unmarshaller.unmarshal(new StringReader(outputXml));
            System.out.println(convertedAccount.toString());
        } catch (JAXBException e) {
            fail(e.getMessage());
        }
        assertTrue(account.equals(convertedAccount));
        System.out.println("----- leaving Account XML Test -----");
    }

    @Test
    public void testCategoryXml() {
        System.out.println("----- entering Category XML Test -----");
        //create and fetch category object
        EntityContainer container = generateTestStructure();
        Category category = container.getRootCategory();
        assertNotNull(category);

        //create jaxb context and marshaller
        Marshaller marshaller = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Category.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        //convert category object to xml
        String outputXml = "";
        try {
            Writer writer = new StringWriter();
            marshaller.marshal(category, writer);
            outputXml = writer.toString();
            writer.close();
        } catch (JAXBException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }
        assertTrue((outputXml != null) && (outputXml != ""));
        System.out.println(outputXml);

        //convert xml back to an object and assert equality to source object
        Category convertedCategory = null;
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            convertedCategory = (Category) unmarshaller.unmarshal(new StringReader(outputXml));
            System.out.println(convertedCategory.toString());
        } catch (JAXBException e) {
            fail(e.getMessage());
        }
        assertTrue(category.equals(convertedCategory));
        System.out.println("----- leaving Category XML Test -----");
    }

    @Test
    public void testCourseXml() {
        System.out.println("----- entering Course XML Test -----");
        //create and fetch course object
        EntityContainer container = generateTestStructure();
        Course course = container.getCourses().get(0);
        assertNotNull(course);

        //create jaxb context and marshaller
        Marshaller marshaller = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Course.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        //convert course object to xml
        String outputXml = "";
        try {
            Writer writer = new StringWriter();
            marshaller.marshal(course, writer);
            outputXml = writer.toString();
            writer.close();
        } catch (JAXBException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }
        assertTrue((outputXml != null) && (outputXml != ""));
        System.out.println(outputXml);

        //convert xml back to an object and assert equality to source object
        Course convertedCourse = null;
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            convertedCourse = (Course) unmarshaller.unmarshal(new StringReader(outputXml));
            System.out.println(convertedCourse.toString());
        } catch (JAXBException e) {
            fail(e.getMessage());
        }
        assertTrue(course.equals(convertedCourse));
        System.out.println("----- leaving Course XML Test -----");
    }


    @Test
    public void testRoleXml() {
        System.out.println("----- entering Role XML Test -----");
        //create and fetch role object
        EntityContainer container = generateTestStructure();
        Role role = container.getAccounts().get(0).getRoles().get(0);
        assertNotNull(role);

        //create jaxb context and marshaller
        Marshaller marshaller = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Role.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        //convert role object to xml
        String outputXml = "";
        try {
            Writer writer = new StringWriter();
            marshaller.marshal(role, writer);
            outputXml = writer.toString();
            writer.close();
        } catch (JAXBException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }
        assertTrue((outputXml != null) && (outputXml != ""));
        System.out.println(outputXml);

        //convert xml back to an object and assert equality to source object
        Role convertedRole = null;
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            convertedRole = (Role) unmarshaller.unmarshal(new StringReader(outputXml));
            System.out.println(convertedRole.toString());
        } catch (JAXBException e) {
            fail(e.getMessage());
        }
        assertTrue(role.equals(convertedRole));
        System.out.println("----- leaving Role XML Test -----");
    }

    @Test
    public void testGroupXml() {
        System.out.println("----- entering Group XML Test -----");
        //create and fetch group object
        EntityContainer container = generateTestStructure();
        Group group = null;
        for (Account account : container.getAccounts()) {
            if (account instanceof Group) {
                group = (Group) account;
            }
        }
        assertNotNull(group);

        //create jaxb context and marshaller
        Marshaller marshaller = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Group.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        //convert group object to xml
        String outputXml = "";
        try {
            Writer writer = new StringWriter();
            marshaller.marshal(group, writer);
            outputXml = writer.toString();
            writer.close();
        } catch (JAXBException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }
        assertTrue((outputXml != null) && (outputXml != ""));
        System.out.println(outputXml);

        //convert xml back to an object and assert equality to source object
        Group convertedGroup = null;
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            convertedGroup = (Group) unmarshaller.unmarshal(new StringReader(outputXml));
            System.out.println(convertedGroup.toString());
        } catch (JAXBException e) {
            fail(e.getMessage());
        }
        assertTrue(group.equals(convertedGroup));
        System.out.println("----- leaving Group XML Test -----");
    }

    @Test
    public void testXmlSchema() {
        //create jaxb context and marshaller
        Marshaller marshaller = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(new Class[]{EntityContainer.class, Account.class, Group.class, Role.class, Course.class, Category.class});
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        //create schema
        final List<DOMResult> results = new ArrayList<DOMResult>();
        try {
            context.generateSchema(
                    new SchemaOutputResolver() {
                        @Override
                        public Result createOutput(String ns, String file) throws IOException {
                            DOMResult result = new DOMResult();
                            result.setSystemId(file);
                            results.add(result);
                            return result;
                        }
                    });
            for (DOMResult result : results) {
                System.out.println("----- Generated XML Schema: ");
                printDOMResult(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

    private void printDOMResult(DOMResult domResult) throws IOException {
        Document doc = (Document) domResult.getNode();
        OutputFormat format = new OutputFormat(doc);
        format.setIndenting(true);
        XMLSerializer serializer = new XMLSerializer(System.out, format);
        serializer.serialize(doc);
    }

    private EntityContainer generateTestStructure() {
        //create small category structure: parentCategory -> childCategory
        Category parentCategory = new Category(createUniqueId());
        Category childCategory = new Category(createUniqueId());


        List<Category> childCategoryList = new ArrayList<Category>();
        childCategoryList.add(childCategory);

        parentCategory.setChildren(childCategoryList);
        childCategory.setParent(parentCategory);


        //create Course with one child workgroup
        List<Category> parentCategoryList = new ArrayList<Category>();
        parentCategoryList.add(parentCategory);
        Course course = new Course(createUniqueId());
        course.setCategories(parentCategoryList);

        Course workgroup = new Course(createUniqueId());
        workgroup.setParent(course);
        workgroup.setRoles(null);
        List<Course> workgroups = new ArrayList<Course>();
        workgroups.add(workgroup);

        course.setWorkgroups(workgroups);

        //add course to parent Category
        List<Course> courses = new ArrayList<Course>();
        courses.add(course);

        parentCategory.setCourses(courses);

        //create account and a group and put account to group
        Account account = new Account(createUniqueId());
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(account);

        Group group = new Group(createUniqueId());
        group.setMembers(accounts);

        List<Group> groups = new ArrayList<Group>();
        groups.add(group);

        account.setGroups(groups);

        //define role between account and course
        Role role = new Role(createUniqueId());
        role.setAccount(account);
        role.setCourse(course);
        role.setType(RoleType.ASSISTANT);

        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        account.setRoles(roles);
        course.setRoles(roles);

        // put all created objects into entitycontainer

        EntityContainer container = new EntityContainer();
        List<Account> accs = new ArrayList<Account>();
        accs.add(account);
        accs.add(group);
        container.setAccounts(accs);

        container.setRootCategory(parentCategory);

        List<Course> cous = new ArrayList<Course>();
        cous.add(course);
        container.setCourses(cous);

        return container;
    }

    @Test
    public void testAttributeXml() {
        System.out.println("----- entering Attribute XML Test -----");
        //create category object with two attributes
        Category category = new Category(createUniqueId());
        TransientAttribute att1 = new TransientAttribute("TNAME", "TVALUE");
        PersistentAttribute att2 = new PersistentAttribute("PNAME", "PVALUE");
        att2.setEntity(category);
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(att1);
        attributes.add(att2);
        category.setAttributes(attributes);

        //create jaxb context and marshaller
        Marshaller marshaller = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Category.class, Attribute.class, PersistentAttribute.class, TransientAttribute.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        //convert group object to xml
        String outputXml = "";
        try {
            Writer writer = new StringWriter();
            marshaller.marshal(category, writer);
            outputXml = writer.toString();
            writer.close();
        } catch (JAXBException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }
        assertTrue((outputXml != null) && (outputXml != ""));
        System.out.println(outputXml);

        //convert xml back to an object and assert equality to source object
        Category convertedCategory = null;
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            convertedCategory = (Category) unmarshaller.unmarshal(new StringReader(outputXml));
            System.out.println(convertedCategory.toString());
        } catch (JAXBException e) {
            fail(e.getMessage());
        }
        assertTrue(category.equals(convertedCategory));
        System.out.println("----- leaving Attribute XML Test -----");

    }

}