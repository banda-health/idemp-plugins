package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DemandLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DemandLineInput;
import org.compiere.model.X_M_DemandLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_DemandLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DemandLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DemandLineInput.Table_Name;
	}

	public X_M_DemandLine M_DemandLineSave(I_M_DemandLineInput Entity, DataFetchingEnvironment environment) {
		return (X_M_DemandLine) super.save((X_M_DemandLineInput) Entity, environment);
	}

	public List<X_M_DemandLine> M_DemandLineSaveMany(List<I_M_DemandLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_DemandLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_DemandLine) entity).collect(Collectors.toList());
	}

	public boolean M_DemandLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
