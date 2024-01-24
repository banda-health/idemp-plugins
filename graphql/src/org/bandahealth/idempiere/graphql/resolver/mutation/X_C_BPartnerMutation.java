package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_BPartnerInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BPartnerInput;

import java.util.List;

/**
 * Generated Query Resolver for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BPartnerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BPartnerInput.Table_Name;
	}

	public MBPartner_BH C_BPartnerSave(I_C_BPartnerInput input, DataFetchingEnvironment environment) {
		return (MBPartner_BH) super.save((X_C_BPartnerInput) input, environment);
	}

	public boolean C_BPartnerDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
