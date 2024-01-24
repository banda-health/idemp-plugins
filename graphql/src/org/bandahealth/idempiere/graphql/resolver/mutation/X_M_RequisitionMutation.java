package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_RequisitionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_RequisitionInput;
import org.compiere.model.MRequisition;

import java.util.List;

/**
 * Generated Query Resolver for M_Requisition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_RequisitionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_RequisitionInput.Table_Name;
	}

	public MRequisition M_RequisitionSave(I_M_RequisitionInput input, DataFetchingEnvironment environment) {
		return (MRequisition) super.save((X_M_RequisitionInput) input, environment);
	}

	public boolean M_RequisitionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
