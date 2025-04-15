package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TabInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TabInput;
import org.compiere.model.MTab;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TabMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TabInput.Table_Name;
	}

	public MTab AD_TabSave(I_AD_TabInput Entity, DataFetchingEnvironment environment) {
		return (MTab) super.save((X_AD_TabInput) Entity, environment);
	}

	public List<MTab> AD_TabSaveMany(List<I_AD_TabInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_TabInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTab) entity).collect(Collectors.toList());
	}

	public boolean AD_TabDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
