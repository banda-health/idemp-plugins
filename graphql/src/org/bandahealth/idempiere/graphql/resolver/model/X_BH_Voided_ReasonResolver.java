package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.dataloader.DataLoader;

import java.math.BigDecimal;

/**
 * Generated ModelResolver for BH_Voided_Reason - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Voided_ReasonResolver extends POResolver<MBHVoidedReason> implements GraphQLResolver<MBHVoidedReason> {


	public BigDecimal bh_window_id(MBHVoidedReason entity, DataFetchingEnvironment environment) {
		return entity.getbh_window_id();
	}

}
