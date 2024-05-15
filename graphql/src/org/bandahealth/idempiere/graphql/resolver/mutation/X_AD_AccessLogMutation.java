package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AccessLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AccessLogInput;
import org.compiere.model.MAccessLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_AccessLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AccessLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AccessLogInput.Table_Name;
	}

	public MAccessLog AD_AccessLogSave(I_AD_AccessLogInput Entity, DataFetchingEnvironment environment) {
		return (MAccessLog) super.save((X_AD_AccessLogInput) Entity, environment);
	}

	public List<MAccessLog> AD_AccessLogSaveMany(List<I_AD_AccessLogInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_AccessLogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAccessLog) entity).collect(Collectors.toList());
	}

	public boolean AD_AccessLogDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
