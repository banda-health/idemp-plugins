package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.SchemaParserBuilder;

/**
 * This class is responsible for adding all mutation resolvers to the GraphQL SchemaParserBuilder.
 */
public class BandaMutationComposer {
	/**
	 * Add the all mutations to the builder.
	 *
	 * @param builder The builder for the GraphQL SchemaParserBuilder
	 */
	public static void addAll(SchemaParserBuilder builder) {
		builder.resolvers(
				new AuthenticationMutation(),
//				new BusinessPartnerMutation(),
//				new ChargeMutation(),
				new M_AD_ClientMutation(),
				new M_AD_OrgMutation(),
				new M_AD_Ref_ListMutation(),
				new M_AD_UserMutation(),
				new M_BH_EncounterMutation(),
				new M_BH_VisitMutation(),
				new M_BH_Voided_ReasonMutation(),
				new M_C_BPartnerMutation(),
				new M_C_InvoiceMutation(),
				new M_C_OrderMutation(),
				new M_C_PaymentMutation(),
				new M_M_InOutMutation()
//				new InvoiceMutation(),
//				new OrderMutation(),
//				new PaymentMutation(),
//				new ProductMutation(),
//				new StorageOnHandMutation(),
//				new UserMutation()
		);
	}
}
