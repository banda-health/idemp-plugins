package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_ContactInterestInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_ContactInterestInput;
import org.compiere.model.MContactInterest;

import java.util.List;

/**
 * Generated Query Resolver for R_ContactInterest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_ContactInterestMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_ContactInterestInput.Table_Name;
	}

	public MContactInterest R_ContactInterestSave(I_R_ContactInterestInput input, DataFetchingEnvironment environment) {
		return (MContactInterest) super.save((X_R_ContactInterestInput) input, environment);
	}

	public boolean R_ContactInterestDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
