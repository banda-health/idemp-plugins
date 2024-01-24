package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_InOutLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InOutLineInput;
import org.compiere.model.MInOutLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_InOutLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InOutLineInput.Table_Name;
	}

	public MInOutLine M_InOutLineSave(I_M_InOutLineInput entity, DataFetchingEnvironment environment) {
		return (MInOutLine) super.save((X_M_InOutLineInput) entity, environment);
	}

	public List<MInOutLine> M_InOutLineSaveMany(List<I_M_InOutLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_InOutLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInOutLine) entity).collect(Collectors.toList());
	}

	public boolean M_InOutLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
