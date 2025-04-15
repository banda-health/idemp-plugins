package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_BOMAlternativeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_BOMAlternativeInput;
import org.compiere.model.X_M_BOMAlternative;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_BOMAlternative - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_BOMAlternativeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_BOMAlternativeInput.Table_Name;
	}

	public X_M_BOMAlternative M_BOMAlternativeSave(I_M_BOMAlternativeInput Entity, DataFetchingEnvironment environment) {
		return (X_M_BOMAlternative) super.save((X_M_BOMAlternativeInput) Entity, environment);
	}

	public List<X_M_BOMAlternative> M_BOMAlternativeSaveMany(List<I_M_BOMAlternativeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_BOMAlternativeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_BOMAlternative) entity).collect(Collectors.toList());
	}

	public boolean M_BOMAlternativeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
