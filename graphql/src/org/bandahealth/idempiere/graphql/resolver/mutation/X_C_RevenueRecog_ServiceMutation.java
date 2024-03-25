package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RevenueRecog_ServiceInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RevenueRecog_ServiceInput;
import org.compiere.model.MRevenueRecogService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_RevenueRecog_Service - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RevenueRecog_ServiceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RevenueRecog_ServiceInput.Table_Name;
	}

	public MRevenueRecogService C_RevenueRecog_ServiceSave(I_C_RevenueRecog_ServiceInput entity, DataFetchingEnvironment environment) {
		return (MRevenueRecogService) super.save((X_C_RevenueRecog_ServiceInput) entity, environment);
	}

	public List<MRevenueRecogService> C_RevenueRecog_ServiceSaveMany(List<I_C_RevenueRecog_ServiceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_RevenueRecog_ServiceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRevenueRecogService) entity).collect(Collectors.toList());
	}

	public boolean C_RevenueRecog_ServiceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
