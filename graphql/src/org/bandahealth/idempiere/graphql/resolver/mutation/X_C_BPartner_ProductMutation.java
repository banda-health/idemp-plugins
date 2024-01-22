package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BPartner_ProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BPartner_ProductInput;
import org.compiere.model.MBPartnerProduct;

import java.util.List;

/**
 * Generated Query Resolver for C_BPartner_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BPartner_ProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BPartner_ProductInput.Table_Name;
	}

	public MBPartnerProduct C_BPartner_ProductSave(I_C_BPartner_ProductInput input, DataFetchingEnvironment environment) {
		return (MBPartnerProduct) super.save((X_C_BPartner_ProductInput) input, environment);
	}

	public boolean C_BPartner_ProductDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
