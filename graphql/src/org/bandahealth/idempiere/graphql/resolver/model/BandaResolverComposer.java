package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.SchemaParserBuilder;

/**
 * This class is responsible for adding all non-query & non-mutation resolvers to the GraphQL SchemaParserBuilder.
 */
public class BandaResolverComposer {
	/**
	 * Add all resolvers to the GraphQL SchemaParserBuilder
	 *
	 * @param builder The builder for the GraphQL Schema Parser
	 */
	public static void addAll(SchemaParserBuilder builder) {
		builder.resolvers(
//				new AccountResolver(),
//				new AttributeSetInstanceResolver(),
//				new AttributeSetResolver(),
//				new BusinessPartnerResolver(),
//				new ChargeResolver(),
//				new ChargeTypeResolver(),
//				new ClientResolver(),
//				new FormResolver(),
//				new InvoiceLineResolver(),
//				new InvoiceResolver(),
//				new LocationResolver(),
//				new LocatorResolver(),
				new M_AD_ClientResolver(),
				new M_AD_OrgResolver(),
				new M_AD_Ref_ListResolver(),
				new M_AD_UserResolver(),
				new M_BH_EncounterResolver(),
				new M_BH_VisitResolver(),
				new M_BH_Voided_ReasonResolver(),
				new M_C_BPartnerResolver(),
				new M_C_InvoiceResolver(),
				new M_C_OrderResolver(),
				new M_C_PaymentResolver(),
				new M_M_InOutResolver()
//				new OrderLineResolver(),
//				new OrderResolver(),
//				new OrganizationResolver(),
//				new PaymentResolver(),
//				new ProcessParameterResolver(),
//				new ProcessResolver(),
//				new ProductCategoryResolver(),
//				new ProductResolver(),
//				new ReferenceListResolver(),
//				new ReferenceResolver(),
//				new ReportViewResolver(),
//				new RoleResolver(),
//				new StorageOnHandResolver(),
//				new UserResolver(),
//				new WarehouseResolver(),
//				new WorkflowResolver()
		);
	}
}
