package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_ProcessDataInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_ProcessDataInput;
import org.compiere.model.X_AD_WF_ProcessData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_ProcessData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_ProcessDataMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_ProcessDataInput.Table_Name;
	}

	public X_AD_WF_ProcessData AD_WF_ProcessDataSave(I_AD_WF_ProcessDataInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_WF_ProcessData) super.save((X_AD_WF_ProcessDataInput) Entity, environment);
	}

	public List<X_AD_WF_ProcessData> AD_WF_ProcessDataSaveMany(List<I_AD_WF_ProcessDataInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_WF_ProcessDataInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WF_ProcessData) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_ProcessDataDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
