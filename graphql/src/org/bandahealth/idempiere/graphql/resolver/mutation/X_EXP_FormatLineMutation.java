package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_EXP_FormatLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_EXP_FormatLineInput;
import org.compiere.model.MEXPFormatLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for EXP_FormatLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_EXP_FormatLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_EXP_FormatLineInput.Table_Name;
	}

	public MEXPFormatLine EXP_FormatLineSave(I_EXP_FormatLineInput Entity, DataFetchingEnvironment environment) {
		return (MEXPFormatLine) super.save((X_EXP_FormatLineInput) Entity, environment);
	}

	public List<MEXPFormatLine> EXP_FormatLineSaveMany(List<I_EXP_FormatLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_EXP_FormatLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MEXPFormatLine) entity).collect(Collectors.toList());
	}

	public boolean EXP_FormatLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
