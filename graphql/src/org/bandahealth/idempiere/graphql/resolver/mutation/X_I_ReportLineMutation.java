package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_ReportLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_ReportLineInput;
import org.compiere.model.X_I_ReportLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_ReportLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_ReportLineInput.Table_Name;
	}

	public X_I_ReportLine I_ReportLineSave(I_I_ReportLineInput entity, DataFetchingEnvironment environment) {
		return (X_I_ReportLine) super.save((X_I_ReportLineInput) entity, environment);
	}

	public List<X_I_ReportLine> I_ReportLineSaveMany(List<I_I_ReportLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_I_ReportLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_ReportLine) entity).collect(Collectors.toList());
	}

	public boolean I_ReportLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
