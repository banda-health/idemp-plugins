package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_BPartnerInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_BPartnerInput;
import org.compiere.model.X_I_BPartner;

import java.util.List;

/**
 * Generated Query Resolver for I_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_BPartnerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_BPartnerInput.Table_Name;
	}

	public X_I_BPartner I_BPartnerSave(I_I_BPartnerInput input, DataFetchingEnvironment environment) {
		return (X_I_BPartner) super.save((X_I_BPartnerInput) input, environment);
	}

	public boolean I_BPartnerDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
