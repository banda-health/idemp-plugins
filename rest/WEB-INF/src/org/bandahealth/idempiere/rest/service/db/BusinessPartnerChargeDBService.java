package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHBPartnerCharge;
import org.bandahealth.idempiere.base.model.MBHBPartnerChargeInfo;
import org.bandahealth.idempiere.base.model.MBHChargeInfo;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.rest.model.BusinessPartnerCharge;
import org.bandahealth.idempiere.rest.model.BusinessPartnerChargeInformation;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BusinessPartnerChargeDBService extends BaseDBService<BusinessPartnerCharge, MBHBPartnerCharge> {
	@Autowired
	private BusinessPartnerDBService businessPartnerDBService;
	@Autowired
	private ChargeDBService chargeDBService;
	@Autowired
	private ChargeInformationDBService chargeInformationDBService;
	@Autowired
	private BusinessPartnerChargeInformationDBService businessPartnerChargeInformationDBService;

	@Override
	public BusinessPartnerCharge saveEntity(BusinessPartnerCharge entity) {
		MBHBPartnerCharge businessPartnerCharge = getEntityByUuidFromDB(entity.getUuid());
		if (businessPartnerCharge == null) {
			businessPartnerCharge = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				businessPartnerCharge.setBH_BPartner_Charge_UU(entity.getUuid());
			}
		}

		// Set the Business Partner relationship
		if (entity.getBusinessPartnerId() > 0) {
			businessPartnerCharge.setC_BPartner_ID(entity.getBusinessPartnerId());
		} else {
			MBPartner_BH businessPartner = businessPartnerDBService.getEntityByUuidFromDB(entity.getBusinessPartnerUuid());
			if (businessPartner != null) {
				businessPartnerCharge.setC_BPartner_ID(businessPartner.getC_BPartner_ID());
			}
		}
		// Set the charge information relationship
		if (entity.getChargeId() > 0) {
			businessPartnerCharge.setC_Charge_ID(entity.getChargeId());
		} else {
			MCharge_BH charge = chargeDBService.getEntityByUuidFromDB(entity.getChargeUuid());
			if (charge != null) {
				businessPartnerCharge.setC_Charge_ID(charge.getC_Charge_ID());
			}
		}
		businessPartnerCharge.setName(entity.getName());
		ModelUtil.setPropertyIfPresent(entity.getDescription(), businessPartnerCharge::setDescription);

		businessPartnerCharge.saveEx();
		entity.setId(businessPartnerCharge.get_ID());

		// If there is info, we need to handle it
		if (entity.getChargeInformationList() != null) {
			// Save what's currently on the entity
			entity.getChargeInformationList().forEach(businessPartnerChargeInformation -> {
				businessPartnerChargeInformation.setBusinessPartnerChargeId(entity.getId());
				businessPartnerChargeInformationDBService.saveEntity(businessPartnerChargeInformation);
			});
		}

		return transformData(
				Collections.singletonList(getEntityByUuidFromDB(businessPartnerCharge.getBH_BPartner_Charge_UU()))).get(0);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// First, go remove the children
		MBHBPartnerCharge businessPartnerCharge = getEntityByUuidFromDB(entityUuid);
		if (businessPartnerCharge == null) {
			return true;
		}
		List<MBHBPartnerChargeInfo> businessPartnerChargeInformationList = businessPartnerChargeInformationDBService
				.getGroupsByIds(MBHBPartnerChargeInfo::getBH_BPartner_Charge_ID,
						MBHBPartnerChargeInfo.COLUMNNAME_BH_BPartner_Charge_ID,
						Collections.singleton(businessPartnerCharge.getBH_BPartner_Charge_ID()))
				.getOrDefault(businessPartnerCharge.getBH_BPartner_Charge_ID(), new ArrayList<>());
		boolean wereChildrenDeletesSuccessful = businessPartnerChargeInformationList.stream().allMatch(
				businessPartnerChargeInformation -> businessPartnerChargeInformationDBService
						.deleteEntity(businessPartnerChargeInformation.getBH_BPartner_Charge_Info_UU()));
		if (!wereChildrenDeletesSuccessful) {
			throw new AdempiereException("There was an error deleting this business partner's information");
		}
		// Now remove the charge
		return businessPartnerCharge.delete(false);
	}

	@Override
	protected BusinessPartnerCharge createInstanceWithDefaultFields(MBHBPartnerCharge instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BusinessPartnerCharge createInstanceWithAllFields(MBHBPartnerCharge instance) {
		return new BusinessPartnerCharge(instance);
	}

	@Override
	protected BusinessPartnerCharge createInstanceWithSearchFields(MBHBPartnerCharge instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHBPartnerCharge getModelInstance() {
		return new MBHBPartnerCharge(Env.getCtx(), 0, null);
	}

	@Override
	public List<BusinessPartnerCharge> transformData(List<MBHBPartnerCharge> dbModels) {
		Set<Integer> businessPartnerChargeIds =
				dbModels.stream().map(MBHBPartnerCharge::getBH_BPartner_Charge_ID).collect(Collectors.toSet());
		Set<Integer> chargeIds = dbModels.stream().map(MBHBPartnerCharge::getC_Charge_ID).collect(Collectors.toSet());
		Set<Integer> businessPartnerIds =
				dbModels.stream().map(MBHBPartnerCharge::getC_BPartner_ID).collect(Collectors.toSet());

		// Batch calls
		Map<Integer, List<MBHBPartnerChargeInfo>> businessPartnerChargeInfoByBusinessPartnerCharge =
				businessPartnerChargeInformationDBService.getGroupsByIds(MBHBPartnerChargeInfo::getBH_BPartner_Charge_ID,
						MBHBPartnerChargeInfo.COLUMNNAME_BH_BPartner_Charge_ID, businessPartnerChargeIds);
		Map<Integer, MCharge_BH> chargesByIds = chargeDBService.getByIds(chargeIds);
		Map<Integer, MBPartner_BH> businessPartnersByIds = businessPartnerDBService.getByIds(businessPartnerIds);
		Map<Integer, MBHChargeInfo> chargeInformationByIds = chargeInformationDBService.getByIds(
				businessPartnerChargeInfoByBusinessPartnerCharge.values().stream().flatMap(
						businessPartnerChargeInformation -> businessPartnerChargeInformation.stream()
								.map(MBHBPartnerChargeInfo::getBH_Charge_Info_ID)).collect(Collectors.toSet()));

		return dbModels.stream().map(this::createInstanceWithAllFields).peek(businessPartnerCharge -> {
			// Set the uuids
			businessPartnerCharge.setChargeUuid(chargesByIds.get(businessPartnerCharge.getChargeId()).getC_Charge_UU());
			businessPartnerCharge.setBusinessPartnerUuid(
					businessPartnersByIds.get(businessPartnerCharge.getBusinessPartnerId()).getC_BPartner_UU());
			// Set the children
			businessPartnerCharge.setChargeInformationList(businessPartnerChargeInfoByBusinessPartnerCharge
					.getOrDefault(businessPartnerCharge.getId(), new ArrayList<>()).stream()
					.map(BusinessPartnerChargeInformation::new).peek(
							businessPartnerChargeInformation -> {
								businessPartnerChargeInformation.setChargeInformationUuid(
										chargeInformationByIds.get(businessPartnerChargeInformation.getChargeInformationId())
												.getBH_Charge_Info_UU());
							}).collect(Collectors.toList()));
		}).collect(Collectors.toList());
	}
}
