package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.graphql.model.input.I_BH_BP_Specific_Payer_InfoInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_BP_Specific_Payer_InfoInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_BP_Specific_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_BP_Specific_Payer_InfoMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_BP_Specific_Payer_InfoInput.Table_Name;
	}

	public MBHBPSpecificPayerInfo BH_BP_Specific_Payer_InfoSave(I_BH_BP_Specific_Payer_InfoInput input, DataFetchingEnvironment environment) {
		return (MBHBPSpecificPayerInfo) super.save((X_BH_BP_Specific_Payer_InfoInput) input, environment);
	}

	public boolean BH_BP_Specific_Payer_InfoDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
