package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TableInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TableInput;
import org.compiere.model.MTable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_TableMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TableInput.Table_Name;
	}

	public MTable AD_TableSave(I_AD_TableInput Entity, DataFetchingEnvironment environment) {
		return (MTable) super.save((X_AD_TableInput) Entity, environment);
	}

	public List<MTable> AD_TableSaveMany(List<I_AD_TableInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_TableInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTable) entity).collect(Collectors.toList());
	}

	public boolean AD_TableDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
