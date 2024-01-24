package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_RetirementInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_RetirementInput;
import org.compiere.model.X_A_Asset_Retirement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Retirement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_RetirementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_RetirementInput.Table_Name;
	}

	public X_A_Asset_Retirement A_Asset_RetirementSave(I_A_Asset_RetirementInput entity, DataFetchingEnvironment environment) {
		return (X_A_Asset_Retirement) super.save((X_A_Asset_RetirementInput) entity, environment);
	}

	public List<X_A_Asset_Retirement> A_Asset_RetirementSaveMany(List<I_A_Asset_RetirementInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Asset_RetirementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_Asset_Retirement) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_RetirementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
