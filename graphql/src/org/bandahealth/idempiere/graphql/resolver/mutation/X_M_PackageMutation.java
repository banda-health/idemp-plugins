package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PackageInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PackageInput;
import org.compiere.model.MPackage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PackageMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PackageInput.Table_Name;
	}

	public MPackage M_PackageSave(I_M_PackageInput Entity, DataFetchingEnvironment environment) {
		return (MPackage) super.save((X_M_PackageInput) Entity, environment);
	}

	public List<MPackage> M_PackageSaveMany(List<I_M_PackageInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_PackageInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPackage) entity).collect(Collectors.toList());
	}

	public boolean M_PackageDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
