package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PackageLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PackageLineInput;
import org.compiere.model.MPackageLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_PackageLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PackageLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PackageLineInput.Table_Name;
	}

	public MPackageLine M_PackageLineSave(I_M_PackageLineInput entity, DataFetchingEnvironment environment) {
		return (MPackageLine) super.save((X_M_PackageLineInput) entity, environment);
	}

	public List<MPackageLine> M_PackageLineSaveMany(List<I_M_PackageLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_PackageLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPackageLine) entity).collect(Collectors.toList());
	}

	public boolean M_PackageLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
