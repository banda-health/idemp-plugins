package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_InOutLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InOutLineInput;
import org.compiere.model.MInOutLine;

import java.util.List;

/**
 * Generated Query Resolver for M_InOutLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_InOutLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InOutLineInput.Table_Name;
	}

	public MInOutLine M_InOutLineSave(I_M_InOutLineInput input, DataFetchingEnvironment environment) {
		return (MInOutLine) super.save((X_M_InOutLineInput) input, environment);
	}

	public boolean M_InOutLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
