package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payer_Info_FldInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payer_Info_FldInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Payer_Info_FldMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payer_Info_FldInput.Table_Name;
	}

	public MBHPayerInfoFld BH_Payer_Info_FldSave(I_BH_Payer_Info_FldInput input, DataFetchingEnvironment environment) {
		return (MBHPayerInfoFld) super.save((X_BH_Payer_Info_FldInput) input, environment);
	}

	public boolean BH_Payer_Info_FldDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
