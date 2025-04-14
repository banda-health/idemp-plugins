package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BPartner_ProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BPartner_ProductInput;
import org.compiere.model.MBPartnerProduct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BPartner_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BPartner_ProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BPartner_ProductInput.Table_Name;
	}

	public MBPartnerProduct C_BPartner_ProductSave(I_C_BPartner_ProductInput Entity, DataFetchingEnvironment environment) {
		return (MBPartnerProduct) super.save((X_C_BPartner_ProductInput) Entity, environment);
	}

	public List<MBPartnerProduct> C_BPartner_ProductSaveMany(List<I_C_BPartner_ProductInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BPartner_ProductInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBPartnerProduct) entity).collect(Collectors.toList());
	}

	public boolean C_BPartner_ProductDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
