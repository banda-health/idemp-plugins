package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.model.input.I_BH_VisitInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_VisitInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Visit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_VisitMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_VisitInput.Table_Name;
	}

	public MBHVisit BH_VisitSave(I_BH_VisitInput Entity, DataFetchingEnvironment environment) {
		return (MBHVisit) super.save((X_BH_VisitInput) Entity, environment);
	}

	public List<MBHVisit> BH_VisitSaveMany(List<I_BH_VisitInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_VisitInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHVisit) entity).collect(Collectors.toList());
	}

	public boolean BH_VisitDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
