package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.BusinessPartnerGeneralPayerInformation;
import org.bandahealth.idempiere.rest.model.BusinessPartnerPayerInformation;
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
public class BusinessPartnerPayerInformationDBService
		extends BaseDBService<BusinessPartnerPayerInformation, MBHBPPayerInfo> {
	@Autowired
	private BusinessPartnerDBService businessPartnerDBService;
	@Autowired
	private PayerInformationFieldDBService payerInformationFieldDBService;
	@Autowired
	private BusinessPartnerGeneralPayerInformationDBService businessPartnerGeneralPayerInformationDBService;

	@Override
	public BusinessPartnerPayerInformation saveEntity(BusinessPartnerPayerInformation entity) {
		MBHBPPayerInfo businessPartnerPayerInformation = getEntityByUuidFromDB(entity.getUuid());
		if (businessPartnerPayerInformation == null) {
			businessPartnerPayerInformation = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				businessPartnerPayerInformation.setBH_BP_Payer_Info_UU(entity.getUuid());
			}
		}

		// Set the Business Partner relationship
		if (entity.getBusinessPartnerId() > 0) {
			businessPartnerPayerInformation.setC_BPartner_ID(entity.getBusinessPartnerId());
		} else {
			MBPartner_BH businessPartner = businessPartnerDBService.getEntityByUuidFromDB(entity.getBusinessPartnerUuid());
			if (businessPartner != null) {
				businessPartnerPayerInformation.setC_BPartner_ID(businessPartner.getC_BPartner_ID());
			}
		}
		// Set the charge information relationship
		if (entity.getPayerId() > 0) {
			businessPartnerPayerInformation.setBH_Payer_ID(entity.getPayerId());
		} else {
			MBPartner_BH payer = businessPartnerDBService.getEntityByUuidFromDB(entity.getPayerUuid());
			if (payer != null) {
				businessPartnerPayerInformation.setBH_Payer_ID(payer.get_ID());
			}
		}
		businessPartnerPayerInformation.setName(entity.getName());
		ModelUtil.setPropertyIfPresent(entity.getDescription(), businessPartnerPayerInformation::setDescription);

		businessPartnerPayerInformation.saveEx();
		entity.setId(businessPartnerPayerInformation.get_ID());

		// If there is info, we need to handle it
		if (entity.getBusinessPartnerGeneralPayerInformationList() != null) {
			// Save what's currently on the entity
			entity.getBusinessPartnerGeneralPayerInformationList().forEach(businessPartnerGeneralPayerInformation -> {
				businessPartnerGeneralPayerInformation.setBusinessPartnerPayerInformationId(entity.getId());
				businessPartnerGeneralPayerInformationDBService.saveEntity(businessPartnerGeneralPayerInformation);
			});
		}

		return transformData(
				Collections.singletonList(getEntityByUuidFromDB(businessPartnerPayerInformation.getBH_BP_Payer_Info_UU()))).get(
				0);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// First, go remove the children
		MBHBPPayerInfo businessPartnerCharge = getEntityByUuidFromDB(entityUuid);
		if (businessPartnerCharge == null) {
			return true;
		}
		List<MBHBPGeneralPayerInfo> businessPartnerGeneralPayerInformationList =
				businessPartnerGeneralPayerInformationDBService
						.getGroupsByIds(MBHBPGeneralPayerInfo::getBH_BP_Payer_Info_ID,
								MBHBPGeneralPayerInfo.COLUMNNAME_BH_BP_Payer_Info_ID,
								Collections.singleton(businessPartnerCharge.getBH_BP_Payer_Info_ID()))
						.getOrDefault(businessPartnerCharge.getBH_BP_Payer_Info_ID(), new ArrayList<>());
		boolean wereChildrenDeletesSuccessful = businessPartnerGeneralPayerInformationList.stream().allMatch(
				businessPartnerChargeInformation -> businessPartnerGeneralPayerInformationDBService
						.deleteEntity(businessPartnerChargeInformation.getBH_BP_General_Payer_Info_UU()));
		if (!wereChildrenDeletesSuccessful) {
			throw new AdempiereException("There was an error deleting this business partner's information");
		}
		// Now remove the charge
		return businessPartnerCharge.delete(false);
	}

	@Override
	protected BusinessPartnerPayerInformation createInstanceWithDefaultFields(MBHBPPayerInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BusinessPartnerPayerInformation createInstanceWithAllFields(MBHBPPayerInfo instance) {
		return new BusinessPartnerPayerInformation(instance);
	}

	@Override
	protected MBHBPPayerInfo getModelInstance() {
		return new MBHBPPayerInfo(Env.getCtx(), 0, null);
	}

	@Override
	public List<BusinessPartnerPayerInformation> transformData(List<MBHBPPayerInfo> dbModels) {
		Set<Integer> businessPartnerPayerInformationIds =
				dbModels.stream().map(MBHBPPayerInfo::getBH_BP_Payer_Info_ID).collect(Collectors.toSet());
		Set<Integer> payerIds = dbModels.stream().map(MBHBPPayerInfo::getBH_Payer_ID).collect(Collectors.toSet());
		Set<Integer> businessPartnerIds =
				dbModels.stream().map(MBHBPPayerInfo::getC_BPartner_ID).collect(Collectors.toSet());

		// Batch calls
		Map<Integer, List<MBHBPGeneralPayerInfo>>
				businessPartnerGeneralPayerInformationByBusinessPartnerPayerInformationId =
				businessPartnerGeneralPayerInformationDBService.getGroupsByIds(MBHBPGeneralPayerInfo::getBH_BP_Payer_Info_ID,
						MBHBPGeneralPayerInfo.COLUMNNAME_BH_BP_Payer_Info_ID, businessPartnerPayerInformationIds);
		Map<Integer, MBPartner_BH> payersById = businessPartnerDBService.getByIds(payerIds);
		Map<Integer, MBPartner_BH> businessPartnersByIds = businessPartnerDBService.getByIds(businessPartnerIds);
		Map<Integer, MBHPayerInfoFld> payerInformationFieldsByIds = payerInformationFieldDBService.getByIds(
				businessPartnerGeneralPayerInformationByBusinessPartnerPayerInformationId.values().stream().flatMap(
						businessPartnerGeneralPayerInformation -> businessPartnerGeneralPayerInformation.stream()
								.map(MBHBPGeneralPayerInfo::getBH_Payer_Info_Fld_ID)).collect(Collectors.toSet()));

		return dbModels.stream().map(this::createInstanceWithAllFields).peek(businessPartnerPayerInformation -> {
			// Set the uuids
			businessPartnerPayerInformation.setPayerUuid(
					payersById.get(businessPartnerPayerInformation.getPayerId()).getC_BPartner_UU());
			businessPartnerPayerInformation.setBusinessPartnerUuid(
					businessPartnersByIds.get(businessPartnerPayerInformation.getBusinessPartnerId()).getC_BPartner_UU());
			// Set the children
			businessPartnerPayerInformation.setBusinessPartnerGeneralPayerInformationList(
					businessPartnerGeneralPayerInformationByBusinessPartnerPayerInformationId
							.getOrDefault(businessPartnerPayerInformation.getId(), new ArrayList<>()).stream()
							.map(BusinessPartnerGeneralPayerInformation::new).peek(
									businessPartnerGeneralPayerInformation -> {
										businessPartnerGeneralPayerInformation.setPayerInformationFieldUuid(
												payerInformationFieldsByIds.get(businessPartnerGeneralPayerInformation.getPayerInformationFieldId())
														.getBH_Payer_Info_Fld_UU());
									}).collect(Collectors.toList()));
		}).collect(Collectors.toList());
	}
}
