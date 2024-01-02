package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MLocatorType;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for M_LocatorType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_LocatorTypeResolver extends POResolver<MLocatorType> implements GraphQLResolver<MLocatorType> {


	public Boolean IsAvailableForReplenishment(MLocatorType entity, DataFetchingEnvironment environment) {
		return entity.isAvailableForReplenishment();
	}

	public Boolean IsAvailableForReservation(MLocatorType entity, DataFetchingEnvironment environment) {
		return entity.isAvailableForReservation();
	}

	public Boolean IsAvailableForShipping(MLocatorType entity, DataFetchingEnvironment environment) {
		return entity.isAvailableForShipping();
	}

}
