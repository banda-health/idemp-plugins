package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PackageMPSInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PackageMPSInput;
import org.compiere.model.MPackageMPS;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_PackageMPS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PackageMPSMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PackageMPSInput.Table_Name;
	}

	public MPackageMPS M_PackageMPSSave(I_M_PackageMPSInput entity, DataFetchingEnvironment environment) {
		return (MPackageMPS) super.save((X_M_PackageMPSInput) entity, environment);
	}

	public List<MPackageMPS> M_PackageMPSSaveMany(List<I_M_PackageMPSInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_PackageMPSInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPackageMPS) entity).collect(Collectors.toList());
	}

	public boolean M_PackageMPSDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
