package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRefList;

/**
 * Boolean methods needs to be generated to get the capitalized letters
 */
public class X_BH_VisitResolver extends BaseResolver<MBHVisit> implements GraphQLResolver<MBHVisit> {
	public MRefList BH_PatientType_RL(MBHVisit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_PatientType())) {
			return null;
		}
		return new MRefList(BandaGraphQLContext.getCtx(environment), 0, entity.get_TrxName());
	}

	public MRefList BH_Process_Stage_RL(MBHVisit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Process_Stage())) {
			return null;
		}
		return new MRefList(BandaGraphQLContext.getCtx(environment), 0, entity.get_TrxName());
	}

	public MRefList bh_referral_RL(MBHVisit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getbh_referral())) {
			return null;
		}
		return new MRefList(BandaGraphQLContext.getCtx(environment), 0, entity.get_TrxName());
	}

	public MBHVoidedReason BH_Voided_Reason(MBHVisit entity, DataFetchingEnvironment environment) {
		return null;
	}

	public MBPartner_BH Patient(MBHVisit entity, DataFetchingEnvironment environment) {
		return new MBPartner_BH(BandaGraphQLContext.getCtx(environment), 1000118, entity.get_TrxName());
	}
}
