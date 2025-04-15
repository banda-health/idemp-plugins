package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DiscountSchemaInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DiscountSchemaInput;
import org.compiere.model.MDiscountSchema;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_DiscountSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_DiscountSchemaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DiscountSchemaInput.Table_Name;
	}

	public MDiscountSchema M_DiscountSchemaSave(I_M_DiscountSchemaInput Entity, DataFetchingEnvironment environment) {
		return (MDiscountSchema) super.save((X_M_DiscountSchemaInput) Entity, environment);
	}

	public List<MDiscountSchema> M_DiscountSchemaSaveMany(List<I_M_DiscountSchemaInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_DiscountSchemaInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDiscountSchema) entity).collect(Collectors.toList());
	}

	public boolean M_DiscountSchemaDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
