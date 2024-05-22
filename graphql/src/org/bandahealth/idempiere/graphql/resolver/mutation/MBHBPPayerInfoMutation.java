package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MBHBPPayerInfoMutation extends X_BH_BP_Payer_InfoMutation {
	@Override
	public boolean BH_BP_Payer_InfoDelete(List<String> uuids, DataFetchingEnvironment environment) {
		ModelUtil.getTableAndCheckAccess(BandaGraphQLContext.getCtx(environment), getTableName(), true);
		Map<String, MBHBPPayerInfo> entitiesByUuid =
				Repository.getByUuids(BandaGraphQLContext.getCtx(environment), getTableName(), null, new HashSet<>(uuids));
		// First, go remove the children
		Map<Integer, List<MBHBPGeneralPayerInfo>> businessPartnerGeneralPayerInformationList =
				Repository.getGroupsByIds(BandaGraphQLContext.getCtx(environment), MBHBPGeneralPayerInfo.Table_Name, null,
						MBHBPGeneralPayerInfo::getBH_BP_Payer_Info_ID, MBHBPGeneralPayerInfo.COLUMNNAME_BH_BP_Payer_Info_ID,
						entitiesByUuid.values().stream().map(MBHBPPayerInfo::getBH_BP_Payer_Info_ID)
								.collect(Collectors.toSet()));
		boolean wereChildrenDeletesSuccessful = businessPartnerGeneralPayerInformationList.values().stream().flatMap(
				Collection::stream).allMatch(entity -> entity.delete(true));
		if (!wereChildrenDeletesSuccessful) {
			throw new AdempiereException("There was an error deleting this business partner's information");
		}
		// Now remove the BP payer information
		return super.BH_BP_Payer_InfoDelete(uuids, environment);
	}
}
