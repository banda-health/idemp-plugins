package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.X_BH_Ocl_Originating_Source;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Ocl_Originating_SourceInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Ocl_Originating_SourceInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Ocl_Originating_Source - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Ocl_Originating_SourceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Ocl_Originating_SourceInput.Table_Name;
	}

	public X_BH_Ocl_Originating_Source BH_Ocl_Originating_SourceSave(I_BH_Ocl_Originating_SourceInput Entity, DataFetchingEnvironment environment) {
		return (X_BH_Ocl_Originating_Source) super.save((X_BH_Ocl_Originating_SourceInput) Entity, environment);
	}

	public List<X_BH_Ocl_Originating_Source> BH_Ocl_Originating_SourceSaveMany(List<I_BH_Ocl_Originating_SourceInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Ocl_Originating_SourceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_BH_Ocl_Originating_Source) entity).collect(Collectors.toList());
	}

	public boolean BH_Ocl_Originating_SourceDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
