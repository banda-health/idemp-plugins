package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_ContactInterestInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_ContactInterestInput;
import org.compiere.model.MContactInterest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_ContactInterest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_ContactInterestMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_ContactInterestInput.Table_Name;
	}

	public MContactInterest R_ContactInterestSave(I_R_ContactInterestInput Entity, DataFetchingEnvironment environment) {
		return (MContactInterest) super.save((X_R_ContactInterestInput) Entity, environment);
	}

	public List<MContactInterest> R_ContactInterestSaveMany(List<I_R_ContactInterestInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_ContactInterestInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MContactInterest) entity).collect(Collectors.toList());
	}

	public boolean R_ContactInterestDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
