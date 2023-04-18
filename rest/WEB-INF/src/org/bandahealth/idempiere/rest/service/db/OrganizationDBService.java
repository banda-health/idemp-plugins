package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Organization;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class OrganizationDBService extends BaseDBService<Organization, MOrg> {

	private OrganizationInformationDBService organizationInformationDBService = new OrganizationInformationDBService();

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
}
