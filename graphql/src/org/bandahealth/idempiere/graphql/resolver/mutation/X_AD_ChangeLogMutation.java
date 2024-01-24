package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ChangeLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ChangeLogInput;
import org.compiere.model.MChangeLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ChangeLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ChangeLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ChangeLogInput.Table_Name;
	}

	public MChangeLog AD_ChangeLogSave(I_AD_ChangeLogInput entity, DataFetchingEnvironment environment) {
		return (MChangeLog) super.save((X_AD_ChangeLogInput) entity, environment);
	}

	public List<MChangeLog> AD_ChangeLogSaveMany(List<I_AD_ChangeLogInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_ChangeLogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MChangeLog) entity).collect(Collectors.toList());
	}

	public boolean AD_ChangeLogDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
