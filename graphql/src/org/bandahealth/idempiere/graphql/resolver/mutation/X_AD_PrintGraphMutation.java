package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintGraphInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintGraphInput;
import org.compiere.model.X_AD_PrintGraph;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PrintGraph - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PrintGraphMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintGraphInput.Table_Name;
	}

	public X_AD_PrintGraph AD_PrintGraphSave(I_AD_PrintGraphInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_PrintGraph) super.save((X_AD_PrintGraphInput) Entity, environment);
	}

	public List<X_AD_PrintGraph> AD_PrintGraphSaveMany(List<I_AD_PrintGraphInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_PrintGraphInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PrintGraph) entity).collect(Collectors.toList());
	}

	public boolean AD_PrintGraphDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
