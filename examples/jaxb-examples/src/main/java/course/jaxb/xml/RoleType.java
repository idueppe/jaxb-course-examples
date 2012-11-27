package course.jaxb.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Role Type to differentiate 3 types of roles:
 * UNDEFINED - if role type cannot be defined
 * PARTICIPANT - if account participates in a course
 * ASSISTANT - if account is an assistant in a course
 * 
 * @author Ingo Düppe, Sebastian Roekens
 *
 */
@XmlEnum
@XmlType(namespace=Constants.NAMESPACE_DATATYPES)
public enum RoleType{
	@XmlEnumValue(value="UNDEFINED")
	UNDEFINED,
	@XmlEnumValue(value="PARTICIPANT")
	PARTICIPANT,
	@XmlEnumValue(value="ASSISTANT")
	ASSISTANT
}