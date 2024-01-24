package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_ReportStatementInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_ReportStatementInput;
import org.compiere.model.X_T_ReportStatement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_ReportStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_ReportStatementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_ReportStatementInput.Table_Name;
	}

	public X_T_ReportStatement T_ReportStatementSave(I_T_ReportStatementInput entity, DataFetchingEnvironment environment) {
		return (X_T_ReportStatement) super.save((X_T_ReportStatementInput) entity, environment);
	}

	public List<X_T_ReportStatement> T_ReportStatementSaveMany(List<I_T_ReportStatementInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_T_ReportStatementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_T_ReportStatement) entity).collect(Collectors.toList());
	}

	public boolean T_ReportStatementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
