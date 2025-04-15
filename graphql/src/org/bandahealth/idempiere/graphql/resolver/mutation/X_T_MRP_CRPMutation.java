package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_MRP_CRPInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_MRP_CRPInput;
import org.eevolution.model.X_T_MRP_CRP;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_MRP_CRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_MRP_CRPMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_MRP_CRPInput.Table_Name;
	}

	public X_T_MRP_CRP T_MRP_CRPSave(I_T_MRP_CRPInput Entity, DataFetchingEnvironment environment) {
		return (X_T_MRP_CRP) super.save((X_T_MRP_CRPInput) Entity, environment);
	}

	public List<X_T_MRP_CRP> T_MRP_CRPSaveMany(List<I_T_MRP_CRPInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_T_MRP_CRPInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_T_MRP_CRP) entity).collect(Collectors.toList());
	}

	public boolean T_MRP_CRPDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
