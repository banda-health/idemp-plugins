package org.bandahealth.idempiere.graphql.model;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.compiere.model.PO;

import java.util.Map;

/**
 * We need a way to override Jackson's default methodology of inferring camel-case naming for properties (for the
 * iDempiere models). This was discovered by looking at the
 * {@link com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector#_addSetterMethod(Map, AnnotatedMethod, AnnotationIntrospector)}
 * where it calls findImplicitPropertyName on the {@link AnnotationIntrospector}. Overriding it like this was the only
 * way I could think of to do it.
 */
public class BandaObjectMapper {
	public static ObjectMapper build() {
		return new ObjectMapper().registerModule(new SimpleModule() {
			@Override
			public void setupModule(SetupContext context) {
				super.setupModule(context);
				context.insertAnnotationIntrospector(new NopAnnotationIntrospector() {
					@Override
					public String findImplicitPropertyName(AnnotatedMember member) {
						// If we're working with an iDempiere model (i.e. one extending the PO object), we want to keep the
						// property names as-is (i.e. by just removing the "get" or "set" prefix
						if (PO.class.isAssignableFrom(member.getDeclaringClass())) {
							if (member.getName().startsWith("get")) {
								return member.getName().replace("get", "");
							} else if (member.getName().startsWith("set")) {
								return member.getName().replace("set", "");
							}
						}
						return super.findImplicitPropertyName(member);
					}
				});
			}
		});
	}
}
