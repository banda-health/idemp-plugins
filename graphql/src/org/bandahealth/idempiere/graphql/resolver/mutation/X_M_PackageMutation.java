package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PackageInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PackageInput;
import org.compiere.model.MPackage;

import java.util.List;

/**
 * Generated Query Resolver for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PackageMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PackageInput.Table_Name;
	}

	public MPackage M_PackageSave(I_M_PackageInput input, DataFetchingEnvironment environment) {
		return (MPackage) super.save((X_M_PackageInput) input, environment);
	}

	public boolean M_PackageDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
