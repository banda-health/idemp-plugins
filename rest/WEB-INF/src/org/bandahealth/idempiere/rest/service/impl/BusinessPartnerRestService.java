package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MBHBPartnerCharge;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.BusinessPartnerCharge;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.BusinessPartnerChargeDBService;
import org.bandahealth.idempiere.rest.service.db.BusinessPartnerDBService;
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
public class BusinessPartnerRestService extends BaseRestService<BusinessPartner, MBPartner_BH, BusinessPartnerDBService> {
	@Autowired
	private BusinessPartnerChargeDBService businessPartnerChargeDBService;
	@Autowired
	private BusinessPartnerDBService businessPartnerDBService;

	@GET
	@Path(IRestConfigs.UUID_PATH + IRestConfigs.CHARGES)
	public List<BusinessPartnerCharge> getCharges(@PathParam("uuid") String uuid) {
		MBPartner_BH businessPartner = businessPartnerDBService.getEntityByUuidFromDB(uuid);
		if (businessPartner == null) {
			return new ArrayList<>();
		}
		return businessPartnerChargeDBService.transformData(businessPartnerChargeDBService
				.getGroupsByIds(MBHBPartnerCharge::getC_BPartner_ID, MBHBPartnerCharge.COLUMNNAME_C_BPartner_ID,
						Collections.singleton(businessPartner.getC_BPartner_ID()))
				.getOrDefault(businessPartner.getC_BPartner_ID(), new ArrayList<>()));
	}

	@POST
	@Path(IRestConfigs.UUID_PATH + IRestConfigs.CHARGES)
	public List<BusinessPartnerCharge> saveCharges(@PathParam("uuid") String uuid,
			List<BusinessPartnerCharge> businessPartnerChargeList) {
		MBPartner_BH businessPartner = businessPartnerDBService.getEntityByUuidFromDB(uuid);
		if (businessPartner == null) {
			return new ArrayList<>();
		}
		// Save what was provided
		List<BusinessPartnerCharge> savedCharges = businessPartnerChargeList.stream()
				.peek(businessPartnerCharge -> businessPartnerCharge.setBusinessPartnerId(businessPartner.getC_BPartner_ID()))
				.map(businessPartnerChargeDBService::saveEntity).collect(Collectors.toList());
		// Delete what is no longer there
		List<MBHBPartnerCharge> currentCharges = businessPartnerChargeDBService
				.getGroupsByIds(MBHBPartnerCharge::getC_BPartner_ID, MBHBPartnerCharge.COLUMNNAME_C_BPartner_ID,
						Collections.singleton(businessPartner.getC_BPartner_ID())).get(businessPartner.getC_BPartner_ID());
		if (currentCharges == null) {
			currentCharges = new ArrayList<>();
		}
		currentCharges.stream().filter(currentCharge -> savedCharges.stream()
				.noneMatch(savedCharge -> savedCharge.getUuid().equals(currentCharge.getBH_BPartner_Charge_UU()))).forEach(
				currentCharge -> businessPartnerChargeDBService.deleteEntity(currentCharge.getBH_BPartner_Charge_UU()));

		return savedCharges;
	}

	@POST
	@Path(IRestConfigs.UUID_PATH + IRestConfigs.CHARGES + "/{businessPartnerChargeUuid}")
	public BusinessPartnerCharge saveSingleCharge(@PathParam("uuid") String uuid,
			@PathParam("businessPartnerChargeUuid") String businessPartnerChargeUuid,
			BusinessPartnerCharge businessPartnerCharge) {
		MBPartner_BH businessPartner = businessPartnerDBService.getEntityByUuidFromDB(uuid);
		if (businessPartner == null) {
			return null;
		}
		businessPartnerCharge.setUuid(businessPartnerChargeUuid);
		businessPartnerCharge.setBusinessPartnerId(businessPartner.getC_BPartner_ID());
		return businessPartnerChargeDBService.saveEntity(businessPartnerCharge);
	}

	@Override
	protected BusinessPartnerDBService getDBService() {
		return businessPartnerDBService;
	}
}
