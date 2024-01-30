package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Desktop;
import org.compiere.model.X_AD_DesktopWorkbench;
import org.compiere.model.X_AD_Workbench;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_DesktopWorkbench - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_DesktopWorkbenchInput extends X_AD_DesktopWorkbench implements I_AD_DesktopWorkbenchInput {

	private ForeignEntityInput mAD_Desktop;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Workbench;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_DesktopWorkbench_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_DesktopWorkbenchInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Desktop.
	 *
	 * @param AD_Desktop Collection of Workbenches
	 */
	@JsonProperty("AD_Desktop")
	public void setAD_DesktopInput(ForeignEntityInput AD_Desktop) {
		this.mAD_Desktop = AD_Desktop;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Desktop != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Desktop foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Desktop", "AD_Desktop_UU=?", get_TrxName())
							.setParameters(AD_Desktop.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Desktop_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Desktop with UUID " + AD_Desktop.getUUID());
			}
		} else {
			this.setAD_Desktop_ID(0);
		}
	}

	/**
	 * Get Desktop.
	 *
	 * @return Collection of Workbenches
	 */
	@JsonProperty("AD_Desktop")
	public ForeignEntityInput AD_Desktop() {
		return mAD_Desktop;
	}
	/**
	 * Set Desktop Workbench.
	 *
	 * @param AD_DesktopWorkbench_ID Desktop Workbench
	 */

	public void setAD_DesktopWorkbench_ID(int AD_DesktopWorkbench_ID) {
		if (get_ID() == 0) {
			super.setAD_DesktopWorkbench_ID(AD_DesktopWorkbench_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_DesktopWorkbench_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_DesktopWorkbench_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Workbench.
	 *
	 * @param AD_Workbench Collection of windows, reports
	 */
	@JsonProperty("AD_Workbench")
	public void setAD_WorkbenchInput(ForeignEntityInput AD_Workbench) {
		this.mAD_Workbench = AD_Workbench;
		if (AD_Workbench != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Workbench foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Workbench", "AD_Workbench_UU=?", get_TrxName())
							.setParameters(AD_Workbench.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Workbench_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Workbench with UUID " + AD_Workbench.getUUID());
			}
		} else {
			this.setAD_Workbench_ID(0);
		}
	}

	/**
	 * Get Workbench.
	 *
	 * @return Collection of windows, reports
	 */
	@JsonProperty("AD_Workbench")
	public ForeignEntityInput AD_Workbench() {
		return mAD_Workbench;
	}
}
