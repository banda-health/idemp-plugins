package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_DistributionLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_DistributionLineInput;
import org.compiere.model.MDistributionLine;

import java.util.List;

/**
 * Generated Query Resolver for GL_DistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_DistributionLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_DistributionLineInput.Table_Name;
	}

	public MDistributionLine GL_DistributionLineSave(I_GL_DistributionLineInput input, DataFetchingEnvironment environment) {
		return (MDistributionLine) super.save((X_GL_DistributionLineInput) input, environment);
	}

	public boolean GL_DistributionLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
