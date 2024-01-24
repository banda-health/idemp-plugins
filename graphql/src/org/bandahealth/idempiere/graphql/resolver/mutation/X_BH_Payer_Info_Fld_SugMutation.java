package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payer_Info_Fld_SugInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payer_Info_Fld_SugInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Payer_Info_Fld_SugMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payer_Info_Fld_SugInput.Table_Name;
	}

	public MBHPayerInfoFldSug BH_Payer_Info_Fld_SugSave(I_BH_Payer_Info_Fld_SugInput input, DataFetchingEnvironment environment) {
		return (MBHPayerInfoFldSug) super.save((X_BH_Payer_Info_Fld_SugInput) input, environment);
	}

	public boolean BH_Payer_Info_Fld_SugDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
