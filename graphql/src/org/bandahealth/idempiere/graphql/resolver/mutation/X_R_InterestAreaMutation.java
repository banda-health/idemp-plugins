package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_InterestAreaInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_InterestAreaInput;
import org.compiere.model.MInterestArea;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_InterestArea - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_InterestAreaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_InterestAreaInput.Table_Name;
	}

	public MInterestArea R_InterestAreaSave(I_R_InterestAreaInput Entity, DataFetchingEnvironment environment) {
		return (MInterestArea) super.save((X_R_InterestAreaInput) Entity, environment);
	}

	public List<MInterestArea> R_InterestAreaSaveMany(List<I_R_InterestAreaInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_InterestAreaInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInterestArea) entity).collect(Collectors.toList());
	}

	public boolean R_InterestAreaDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
