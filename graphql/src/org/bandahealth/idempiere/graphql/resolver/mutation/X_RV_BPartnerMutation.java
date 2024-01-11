package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_RV_BPartnerInput;
import org.bandahealth.idempiere.graphql.model.input.X_RV_BPartnerInput;
import org.compiere.model.MBPartnerInfo;

import java.util.List;

/**
 * Generated Query Resolver for RV_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_RV_BPartnerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_RV_BPartnerInput.Table_Name;
	}

	public MBPartnerInfo RV_BPartnerSave(I_RV_BPartnerInput input, DataFetchingEnvironment environment) {
		return (MBPartnerInfo) super.save((X_RV_BPartnerInput) input, environment);
	}

	public boolean RV_BPartnerDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
