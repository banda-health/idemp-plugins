package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DiscountSchemaBreakInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DiscountSchemaBreakInput;
import org.compiere.model.MDiscountSchemaBreak;

import java.util.List;
import java.util.stream.Collectors;

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

	public MDiscountSchemaBreak M_DiscountSchemaBreakSave(I_M_DiscountSchemaBreakInput entity, DataFetchingEnvironment environment) {
		return (MDiscountSchemaBreak) super.save((X_M_DiscountSchemaBreakInput) entity, environment);
	}

	public List<MDiscountSchemaBreak> M_DiscountSchemaBreakSaveMany(List<I_M_DiscountSchemaBreakInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_DiscountSchemaBreakInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDiscountSchemaBreak) entity).collect(Collectors.toList());
	}

	public boolean M_DiscountSchemaBreakDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
