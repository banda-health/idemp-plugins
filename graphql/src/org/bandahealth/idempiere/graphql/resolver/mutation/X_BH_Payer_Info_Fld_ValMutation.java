package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payer_Info_Fld_ValInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payer_Info_Fld_ValInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld_Val - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Payer_Info_Fld_ValMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payer_Info_Fld_ValInput.Table_Name;
	}

	public MBHPayerInfoFldVal BH_Payer_Info_Fld_ValSave(I_BH_Payer_Info_Fld_ValInput input, DataFetchingEnvironment environment) {
		return (MBHPayerInfoFldVal) super.save((X_BH_Payer_Info_Fld_ValInput) input, environment);
	}

	public boolean BH_Payer_Info_Fld_ValDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
