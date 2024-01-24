package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_FundInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_FundInput;
import org.compiere.model.X_GL_Fund;

import java.util.List;

/**
 * Generated Query Resolver for GL_Fund - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_FundMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_FundInput.Table_Name;
	}

	public X_GL_Fund GL_FundSave(I_GL_FundInput input, DataFetchingEnvironment environment) {
		return (X_GL_Fund) super.save((X_GL_FundInput) input, environment);
	}

	public boolean GL_FundDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
