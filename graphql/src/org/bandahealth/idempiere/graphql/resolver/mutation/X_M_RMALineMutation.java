package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_RMALineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_RMALineInput;
import org.compiere.model.MRMALine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_RMALine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_RMALineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_RMALineInput.Table_Name;
	}

	public MRMALine M_RMALineSave(I_M_RMALineInput Entity, DataFetchingEnvironment environment) {
		return (MRMALine) super.save((X_M_RMALineInput) Entity, environment);
	}

	public List<MRMALine> M_RMALineSaveMany(List<I_M_RMALineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_RMALineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRMALine) entity).collect(Collectors.toList());
	}

	public boolean M_RMALineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
