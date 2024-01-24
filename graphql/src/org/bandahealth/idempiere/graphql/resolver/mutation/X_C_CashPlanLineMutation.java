package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CashPlanLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CashPlanLineInput;
import org.compiere.model.MCashPlanLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CashPlanLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CashPlanLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CashPlanLineInput.Table_Name;
	}

	public MCashPlanLine C_CashPlanLineSave(I_C_CashPlanLineInput entity, DataFetchingEnvironment environment) {
		return (MCashPlanLine) super.save((X_C_CashPlanLineInput) entity, environment);
	}

	public List<MCashPlanLine> C_CashPlanLineSaveMany(List<I_C_CashPlanLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CashPlanLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCashPlanLine) entity).collect(Collectors.toList());
	}

	public boolean C_CashPlanLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
