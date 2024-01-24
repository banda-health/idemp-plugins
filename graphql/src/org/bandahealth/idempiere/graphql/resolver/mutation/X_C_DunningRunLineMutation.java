package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DunningRunLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DunningRunLineInput;
import org.compiere.model.MDunningRunLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_DunningRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningRunLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DunningRunLineInput.Table_Name;
	}

	public MDunningRunLine C_DunningRunLineSave(I_C_DunningRunLineInput entity, DataFetchingEnvironment environment) {
		return (MDunningRunLine) super.save((X_C_DunningRunLineInput) entity, environment);
	}

	public List<MDunningRunLine> C_DunningRunLineSaveMany(List<I_C_DunningRunLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_DunningRunLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDunningRunLine) entity).collect(Collectors.toList());
	}

	public boolean C_DunningRunLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
