package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Account;
import org.bandahealth.idempiere.rest.model.BusinessPartnerGroup;
import org.bandahealth.idempiere.rest.model.Charge;
import org.bandahealth.idempiere.rest.model.ChargeType;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MBPGroup;
import org.compiere.model.MElementValue;
import org.compiere.model.MRefList;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BusinessPartnerGroupDBService extends BaseDBService<BusinessPartnerGroup, MBPGroup_BH> {
	@Autowired
	private ReferenceListDBService referenceListDBService;

	@Override
	public BusinessPartnerGroup saveEntity(BusinessPartnerGroup entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected BusinessPartnerGroup createInstanceWithDefaultFields(MBPGroup_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BusinessPartnerGroup createInstanceWithAllFields(MBPGroup_BH instance) {
		return new BusinessPartnerGroup(instance);
	}

	@Override
	protected MBPGroup_BH getModelInstance() {
		return new MBPGroup_BH(Env.getCtx(), 0, null);
	}

	@Override
	public List<BusinessPartnerGroup> transformData(List<MBPGroup_BH> dbModels) {
//		// Batch call to get reference lists for charges
//		Map<String, MRefList> subTypeByValue = referenceListDBService
//				.getTypes(MReference_BH.NON_PATIENT_PAYER_AD_REFERENCE_UU,
//						dbModels.stream().map(MCharge_BH::getBH_SubType).collect(Collectors.toSet())).stream()
//				.collect(Collectors.toMap(MRefList::getValue, referenceList -> referenceList));
//
//		return dbModels.stream().map(businessPartnerGroup -> {
//			BusinessPartnerGroup businessPartnerGroupToReturn = new BusinessPartnerGroup(businessPartnerGroup);
//
//			// Now fill in the child data
//			if (!StringUtil.isNullOrEmpty(businessPartnerGroup.getBH_SubType()) && subTypeByValue.containsKey(businessPartnerGroup.getBH_SubType())) {
//				businessPartnerGroupToReturn.setSubType(new ReferenceList(subTypeByValue.get(businessPartnerGroup.getBH_SubType())));
//			}
//
//			return businessPartnerGroupToReturn;
//		}).collect(Collectors.toList());
		return super.transformData(dbModels);
	}
}
