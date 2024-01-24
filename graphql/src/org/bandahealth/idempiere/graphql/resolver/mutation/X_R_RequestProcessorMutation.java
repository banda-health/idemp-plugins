package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestProcessorInput;
import org.compiere.model.MRequestProcessor;

import java.util.List;

/**
 * Generated Query Resolver for R_RequestProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestProcessorInput.Table_Name;
	}

	public MRequestProcessor R_RequestProcessorSave(I_R_RequestProcessorInput input, DataFetchingEnvironment environment) {
		return (MRequestProcessor) super.save((X_R_RequestProcessorInput) input, environment);
	}

	public boolean R_RequestProcessorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
