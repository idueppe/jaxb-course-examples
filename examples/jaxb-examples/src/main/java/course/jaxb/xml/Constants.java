package course.jaxb.xml;
/*
 * 
 * Class containing all String of package to prevent multiple definitions of same Strings
 * @author Sebastian Roekens
 *
 */
public class Constants{
	//namespace
	public static final String NAMESPACE_DATATYPES="http://cse.campussource.de/DataTypes";
	
	//xml structure elements
	public static final String COURSE = "course";
	public static final String COURSES = "courses";
	public static final String CATEGORY = "category";
	public static final String CATEGORIES = "categories";
	public static final String WORKGROUP = "workgroup";
	public static final String WORKGROUPS = "workgroups";
	public static final String ROLE = "role";
	public static final String ROLES = "roles";
	public static final String ACCOUNT = "account";
	public static final String ACCOUNTS = "accounts";
	public static final String GROUP = "group";
	public static final String GROUPS = "groups";
	public static final String PARENT = "parent";
	public static final String PARENTS = "parents";
	public static final String MEMBERS = "members";
	public static final String TYPE = "type";
	public static final String ENTITY = "entity";
	
	//entity ids
	public static final String COURSE_ID = "courseId";
	public static final String CATEGORY_ID = "categoryId";
	public static final String ROLE_ID = "roleId";
	public static final String ACCOUNT_ID = "accountId";
	public static final String GROUP_ID = "groupId";
	public static final String MEMBER = "member";
	public static final String ATTRIBUTE = "attribute";
	public static final String ATTRIBUTES = "attributes";
	
	//entity property names
	public static final String PROPERTY_ATTRIBUTES = "attributes";
	public static final String PROPERTY_PARENTS = "parents";
	public static final String PROPERTY_PARENT = "parent";
	public static final String PROPERTY_CHILDREN = "children";
	public static final String PROPERTY_COURSES = "courses";
	public static final String PROPERTY_NAME = "name";
	public static final String PROPERTY_VALUE = "value";
	public static final String PROPERTY_PERSISTENT = "peristent";
	
	//table names
	public static final String TABLENAME_ACCOUNT = "CDMM_ACCOUNT";
	public static final String TABLENAME_CATEGORY = "CDMM_CATEGORY";
	public static final String TABLENAME_COURSE = "CDMM_COURSE";
	public static final String TABLENAME_ENTITY = "CDMM_ENTITY";
	public static final String TABLENAME_GROUP = "CDMM_GROUP";
	public static final String TABLENAME_ROLE = "CDMM_ROLE";
	public static final String TABLENAME_GROUP2ACCOUNT = "CDMM_GROUP2ACCOUNT";
	public static final String TABLENAME_COURSE2CATEGORY = "CDMM_COURSE2CAT";
	
	//column names
	public static final String COLUMNNAME_CATEGORY2CATEGORY = "PARENT_CAT_ID";
	public static final String COLUMNNAME_ROLE_TYPE="ROLE_TYPE";
	public static final String COLUMNNAME_CHILD_ID="CHILD_ID";
	public static final String COLUMNNAME_PARENT_ID="PARENT_ID";
	public static final String COLUMNNAME_GROUP_ID="GROUP_ID";
	public static final String COLUMNNAME_ACCOUNT_ID = "ACCOUNT_ID";
	public static final String COLUMNNAME_CATEGORY_ID = "CATEGORY_ID";
	public static final String COLUMNNAME_COURSE_ID = "COURSE_ID";
	public static final String COLUMNNAME_NAME = "NAME";
	public static final String COLUMNNAME_VALUE = "VALUE";
	public static final String COLUMNNAME_ENTITY_ID = "ENTITY_ID";
	

	public static final String ID = "id";




}