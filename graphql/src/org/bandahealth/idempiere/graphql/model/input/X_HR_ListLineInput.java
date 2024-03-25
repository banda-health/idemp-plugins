package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_ListLine;
import org.eevolution.model.X_HR_ListVersion;

import java.sql.ResultSet;

/**
 * Generated Model for HR_ListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ListLineInput extends X_HR_ListLine implements I_HR_ListLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mHR_ListVersion;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The HR_ListLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_ListLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Payroll List Line.
	 *
	 * @param HR_ListLine_ID Payroll List Line
	 */

	public void setHR_ListLine_ID(int HR_ListLine_ID) {
		if (get_ID() == 0) {
			super.setHR_ListLine_ID(HR_ListLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setHR_ListLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getHR_ListLine_UU();
	}

	/**
	 * Set Payroll List Version.
	 *
	 * @param HR_ListVersion Payroll List Version
	 */
	@JsonProperty("HR_ListVersion")
	public void setHR_ListVersionInput(ForeignEntityInput HR_ListVersion) {
		this.mHR_ListVersion = HR_ListVersion;
		if (get_ID() != 0) {
			return;
		}
		if (HR_ListVersion != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_ListVersion foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_ListVersion", "HR_ListVersion_UU=?", get_TrxName())
							.setParameters(HR_ListVersion.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_ListVersion_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_ListVersion with UUID " + HR_ListVersion.getUUID());
			}
		} else {
			this.setHR_ListVersion_ID(0);
		}
	}

	/**
	 * Get Payroll List Version.
	 *
	 * @return Payroll List Version
	 */
	@JsonProperty("HR_ListVersion")
	public ForeignEntityInput HR_ListVersion() {
		return mHR_ListVersion;
	}
}
