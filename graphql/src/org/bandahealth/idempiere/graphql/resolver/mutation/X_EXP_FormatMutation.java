package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_EXP_FormatInput;
import org.bandahealth.idempiere.graphql.model.input.X_EXP_FormatInput;
import org.compiere.model.MEXPFormat;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for EXP_Format - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_EXP_FormatMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_EXP_FormatInput.Table_Name;
	}

	public MEXPFormat EXP_FormatSave(I_EXP_FormatInput Entity, DataFetchingEnvironment environment) {
		return (MEXPFormat) super.save((X_EXP_FormatInput) Entity, environment);
	}

	public List<MEXPFormat> EXP_FormatSaveMany(List<I_EXP_FormatInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_EXP_FormatInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MEXPFormat) entity).collect(Collectors.toList());
	}

	public boolean EXP_FormatDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
