package org.bandahealth.idempiere.graphql.model;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ClientInput;
import org.bandahealth.idempiere.graphql.model.input.I_AD_OrgInput;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Ref_ListInput;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserInput;
import org.bandahealth.idempiere.graphql.model.input.I_BH_EncounterInput;
import org.bandahealth.idempiere.graphql.model.input.I_BH_VisitInput;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Voided_ReasonInput;
import org.bandahealth.idempiere.graphql.model.input.I_C_BPartnerInput;
import org.bandahealth.idempiere.graphql.model.input.I_C_InvoiceInput;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrderInput;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaymentInput;
import org.bandahealth.idempiere.graphql.model.input.I_M_InOutInput;
import org.bandahealth.idempiere.graphql.model.input.MClientInput;
import org.bandahealth.idempiere.graphql.model.input.MOrgInput;
import org.bandahealth.idempiere.graphql.model.input.MRefListInput;
import org.bandahealth.idempiere.graphql.model.input.MUserInput;
import org.bandahealth.idempiere.graphql.model.input.MBHEncounterInput;
import org.bandahealth.idempiere.graphql.model.input.MBHVisitInput;
import org.bandahealth.idempiere.graphql.model.input.MBHVoidedReasonInput;
import org.bandahealth.idempiere.graphql.model.input.MBPartnerInput;
import org.bandahealth.idempiere.graphql.model.input.MInvoiceInput;
import org.bandahealth.idempiere.graphql.model.input.MOrderInput;
import org.bandahealth.idempiere.graphql.model.input.MPaymentInput;
import org.bandahealth.idempiere.graphql.model.input.MInOutInput;
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

			{
				setAbstractTypes(new SimpleAbstractTypeResolver() {{
					addMapping(I_AD_ClientInput.class, MClientInput.class);
					addMapping(I_AD_OrgInput.class, MOrgInput.class);
					addMapping(I_AD_Ref_ListInput.class, MRefListInput.class);
					addMapping(I_AD_UserInput.class, MUserInput.class);
					addMapping(I_BH_EncounterInput.class, MBHEncounterInput.class);
					addMapping(I_BH_VisitInput.class, MBHVisitInput.class);
					addMapping(I_BH_Voided_ReasonInput.class, MBHVoidedReasonInput.class);
					addMapping(I_C_BPartnerInput.class, MBPartnerInput.class);
					addMapping(I_C_InvoiceInput.class, MInvoiceInput.class);
					addMapping(I_C_OrderInput.class, MOrderInput.class);
					addMapping(I_C_PaymentInput.class, MPaymentInput.class);
					addMapping(I_M_InOutInput.class, MInOutInput.class);
				}});
			}
		});
	}
}
