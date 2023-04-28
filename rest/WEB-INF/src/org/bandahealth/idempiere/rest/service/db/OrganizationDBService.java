package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Image;
import org.bandahealth.idempiere.rest.model.Location;
import org.bandahealth.idempiere.rest.model.Organization;
import org.bandahealth.idempiere.rest.model.OrganizationInformation;
import org.compiere.model.MImage;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationDBService extends BaseDBService<Organization, MOrg> {

	@Autowired
	private OrganizationInformationDBService organizationInformationDBService;

	/**
	 * Updates the OrganizationInfo object that's nested in Organization. Updating
	 * the Organization object is not yet supported.
	 * 
	 */
	@Override
	public Organization saveEntity(Organization entity) {
		// get org
		MOrg organization = new Query(Env.getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + " =?", null)
				.setParameters(entity.getUuid()).first();
		if (organization == null) {
			throw new AdempiereException("Organization not found.");
		}

		// utilize cache
		MOrgInfo_BH organizationInfo = (MOrgInfo_BH) MOrgInfo_BH.get(Env.getCtx(), organization.get_ID(), null);
		if (organizationInfo == null) {
			throw new AdempiereException("Missing organization information");
		}

		organizationInformationDBService.saveEntity(entity.getOrganizationInformation());

		return createInstanceWithAllFields(organization);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected Organization createInstanceWithDefaultFields(MOrg instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Organization createInstanceWithAllFields(MOrg instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected Organization createInstanceWithSearchFields(MOrg instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MOrg getModelInstance() {
		return new MOrg(Env.getCtx(), 0, null);
	}

	@Override
	public List<Organization> transformData(List<MOrg> dbModels) {
		// Batch call to get organization information
		Set<Integer> organizationIds = dbModels.stream().map(MOrg::get_ID).collect(Collectors.toSet());

		Map<Integer, List<MOrgInfo_BH>> organizationInformationByOrganizationId = organizationInformationDBService
				.getGroupsByIds(MOrgInfo_BH::getAD_Org_ID, MOrgInfo_BH.COLUMNNAME_AD_Org_ID, organizationIds);

		return dbModels.stream().map(mOrganization -> {
			Organization organization = new Organization(mOrganization);
			if (organizationInformationByOrganizationId.containsKey(mOrganization.getAD_Org_ID())) {
				organization.setOrganizationInformation(organizationInformationDBService
						.transformData(Collections.singletonList(
								organizationInformationByOrganizationId.get(mOrganization.getAD_Org_ID()).get(0)))
						.get(0));
			}

			return organization;

		}).collect(Collectors.toList());
	}

}
