package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SessionInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SessionInput;
import org.compiere.model.MSession;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Session - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_SessionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SessionInput.Table_Name;
	}

	public MSession AD_SessionSave(I_AD_SessionInput Entity, DataFetchingEnvironment environment) {
		return (MSession) super.save((X_AD_SessionInput) Entity, environment);
	}

	public List<MSession> AD_SessionSaveMany(List<I_AD_SessionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_SessionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSession) entity).collect(Collectors.toList());
	}

	public boolean AD_SessionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
