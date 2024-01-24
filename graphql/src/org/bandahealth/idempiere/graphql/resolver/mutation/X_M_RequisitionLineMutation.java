package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_RequisitionLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_RequisitionLineInput;
import org.compiere.model.MRequisitionLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_RequisitionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_RequisitionLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_RequisitionLineInput.Table_Name;
	}

	public MRequisitionLine M_RequisitionLineSave(I_M_RequisitionLineInput entity, DataFetchingEnvironment environment) {
		return (MRequisitionLine) super.save((X_M_RequisitionLineInput) entity, environment);
	}

	public List<MRequisitionLine> M_RequisitionLineSaveMany(List<I_M_RequisitionLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_RequisitionLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRequisitionLine) entity).collect(Collectors.toList());
	}

	public boolean M_RequisitionLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
