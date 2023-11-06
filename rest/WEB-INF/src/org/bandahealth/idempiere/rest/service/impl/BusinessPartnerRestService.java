package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.BusinessPartnerPayerInformation;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.BusinessPartnerDBService;
import org.bandahealth.idempiere.rest.service.db.BusinessPartnerPayerInformationDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Path(IRestConfigs.BUSINESS_PARTNER_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BusinessPartnerRestService
		extends BaseRestService<BusinessPartner, MBPartner_BH, BusinessPartnerDBService> {
	@Autowired
	private BusinessPartnerPayerInformationDBService businessPartnerPayerInformationDBService;
	@Autowired
	private BusinessPartnerDBService businessPartnerDBService;

	@GET
	@Path(IRestConfigs.UUID_PATH + IRestConfigs.PAYER_INFORMATION_LIST)
	public List<BusinessPartnerPayerInformation> getPayerInformationList(@PathParam("uuid") String uuid) {
		MBPartner_BH businessPartner = businessPartnerDBService.getEntityByUuidFromDB(uuid);
		if (businessPartner == null) {
			return new ArrayList<>();
		}
		return businessPartnerPayerInformationDBService.transformData(businessPartnerPayerInformationDBService
				.getGroupsByIds(MBHBPPayerInfo::getC_BPartner_ID, MBHBPPayerInfo.COLUMNNAME_C_BPartner_ID,
						Collections.singleton(businessPartner.getC_BPartner_ID()))
				.getOrDefault(businessPartner.getC_BPartner_ID(), new ArrayList<>()));
	}

	@POST
	@Path(IRestConfigs.UUID_PATH + IRestConfigs.PAYER_INFORMATION_LIST)
	public List<BusinessPartnerPayerInformation> savePayerInformationList(@PathParam("uuid") String uuid,
			List<BusinessPartnerPayerInformation> businessPartnerPayerInformationList) {
		MBPartner_BH businessPartner = businessPartnerDBService.getEntityByUuidFromDB(uuid);
		if (businessPartner == null) {
			return new ArrayList<>();
		}
		// Save what was provided
		List<BusinessPartnerPayerInformation> savedBusinessPartnerPayerInformation =
				businessPartnerPayerInformationList.stream()
						.peek(businessPartnerPayerInformation -> businessPartnerPayerInformation.setBusinessPartnerId(
								businessPartner.getC_BPartner_ID()))
						.map(businessPartnerPayerInformationDBService::saveEntity).collect(Collectors.toList());
		// Delete what is no longer there
		List<MBHBPPayerInfo> businessPartnerPayerInformation = businessPartnerPayerInformationDBService
				.getGroupsByIds(MBHBPPayerInfo::getC_BPartner_ID, MBHBPPayerInfo.COLUMNNAME_C_BPartner_ID,
						Collections.singleton(businessPartner.getC_BPartner_ID())).get(businessPartner.getC_BPartner_ID());
		if (businessPartnerPayerInformation == null) {
			businessPartnerPayerInformation = new ArrayList<>();
		}
		businessPartnerPayerInformation.stream().filter(
				currentBusinessPartnerPayerInformation -> savedBusinessPartnerPayerInformation.stream().noneMatch(
						savedCharge -> savedCharge.getUuid()
								.equals(currentBusinessPartnerPayerInformation.getBH_BP_Payer_Info_UU()))).forEach(
				currentBusinessPartnerPayerInformation -> businessPartnerPayerInformationDBService.deleteEntity(
						currentBusinessPartnerPayerInformation.getBH_BP_Payer_Info_UU()));

		return savedBusinessPartnerPayerInformation;
	}

	@POST
	@Path(IRestConfigs.UUID_PATH + IRestConfigs.PAYER_INFORMATION_LIST + "/{businessPartnerPayerInformationUuid}")
	public BusinessPartnerPayerInformation savePayerInformation(@PathParam("uuid") String uuid,
			@PathParam("businessPartnerPayerInformationUuid") String businessPartnerPayerInformationUuid,
			BusinessPartnerPayerInformation businessPartnerPayerInformation) {
		MBPartner_BH businessPartner = businessPartnerDBService.getEntityByUuidFromDB(uuid);
		if (businessPartner == null) {
			return null;
		}
		businessPartnerPayerInformation.setUuid(businessPartnerPayerInformationUuid);
		businessPartnerPayerInformation.setBusinessPartnerId(businessPartner.getC_BPartner_ID());
		return businessPartnerPayerInformationDBService.saveEntity(businessPartnerPayerInformation);
	}

	@Override
	protected BusinessPartnerDBService getDBService() {
		return businessPartnerDBService;
	}
}
