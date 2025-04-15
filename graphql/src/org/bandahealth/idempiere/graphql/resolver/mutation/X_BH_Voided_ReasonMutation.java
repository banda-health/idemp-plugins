package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Voided_ReasonInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Voided_ReasonInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Voided_Reason - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Voided_ReasonMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Voided_ReasonInput.Table_Name;
	}

	public MBHVoidedReason BH_Voided_ReasonSave(I_BH_Voided_ReasonInput Entity, DataFetchingEnvironment environment) {
		return (MBHVoidedReason) super.save((X_BH_Voided_ReasonInput) Entity, environment);
	}

	public List<MBHVoidedReason> BH_Voided_ReasonSaveMany(List<I_BH_Voided_ReasonInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Voided_ReasonInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHVoidedReason) entity).collect(Collectors.toList());
	}

	public boolean BH_Voided_ReasonDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
