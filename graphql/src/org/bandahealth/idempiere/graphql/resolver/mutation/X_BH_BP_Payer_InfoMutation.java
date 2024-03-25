package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.graphql.model.input.I_BH_BP_Payer_InfoInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_BP_Payer_InfoInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_BP_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_BP_Payer_InfoMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_BP_Payer_InfoInput.Table_Name;
	}

	public MBHBPPayerInfo BH_BP_Payer_InfoSave(I_BH_BP_Payer_InfoInput entity, DataFetchingEnvironment environment) {
		return (MBHBPPayerInfo) super.save((X_BH_BP_Payer_InfoInput) entity, environment);
	}

	public List<MBHBPPayerInfo> BH_BP_Payer_InfoSaveMany(List<I_BH_BP_Payer_InfoInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_BH_BP_Payer_InfoInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHBPPayerInfo) entity).collect(Collectors.toList());
	}

	public boolean BH_BP_Payer_InfoDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
