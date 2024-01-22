package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_RMALineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_RMALineInput;
import org.compiere.model.MRMALine;

import java.util.List;

/**
 * Generated Query Resolver for M_RMALine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_RMALineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_RMALineInput.Table_Name;
	}

	public MRMALine M_RMALineSave(I_M_RMALineInput input, DataFetchingEnvironment environment) {
		return (MRMALine) super.save((X_M_RMALineInput) input, environment);
	}

	public boolean M_RMALineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
