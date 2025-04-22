package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SystemInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SystemInput;
import org.compiere.model.MSystem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_System - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_SystemMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SystemInput.Table_Name;
	}

	public MSystem AD_SystemSave(I_AD_SystemInput Entity, DataFetchingEnvironment environment) {
		return (MSystem) super.save((X_AD_SystemInput) Entity, environment);
	}

	public List<MSystem> AD_SystemSaveMany(List<I_AD_SystemInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_SystemInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSystem) entity).collect(Collectors.toList());
	}

	public boolean AD_SystemDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
