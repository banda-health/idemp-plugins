package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_SubstituteInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_SubstituteInput;
import org.compiere.model.X_M_Substitute;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Substitute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_SubstituteMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_SubstituteInput.Table_Name;
	}

	public X_M_Substitute M_SubstituteSave(I_M_SubstituteInput Entity, DataFetchingEnvironment environment) {
		return (X_M_Substitute) super.save((X_M_SubstituteInput) Entity, environment);
	}

	public List<X_M_Substitute> M_SubstituteSaveMany(List<I_M_SubstituteInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_SubstituteInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_Substitute) entity).collect(Collectors.toList());
	}

	public boolean M_SubstituteDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
