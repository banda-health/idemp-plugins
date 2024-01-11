package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DiscountSchemaBreakInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DiscountSchemaBreakInput;
import org.compiere.model.MDiscountSchemaBreak;

import java.util.List;

/**
 * Generated Query Resolver for M_DiscountSchemaBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DiscountSchemaBreakMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DiscountSchemaBreakInput.Table_Name;
	}

	public MDiscountSchemaBreak M_DiscountSchemaBreakSave(I_M_DiscountSchemaBreakInput input, DataFetchingEnvironment environment) {
		return (MDiscountSchemaBreak) super.save((X_M_DiscountSchemaBreakInput) input, environment);
	}

	public boolean M_DiscountSchemaBreakDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
