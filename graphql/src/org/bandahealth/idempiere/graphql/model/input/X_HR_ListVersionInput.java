package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_List;
import org.eevolution.model.X_HR_ListVersion;

import java.sql.ResultSet;

/**
 * Generated Model for HR_ListVersion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_ListVersionInput extends X_HR_ListVersion implements I_HR_ListVersionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mHR_List;
	private ForeignEntityInput mHR_ListBase;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The HR_ListVersion_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_ListVersionInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
	 * Set Payroll List.
	 *
	 * @param HR_List Payroll List
	 */
	@JsonProperty("HR_List")
	public void setHR_ListInput(ForeignEntityInput HR_List) {
		this.mHR_List = HR_List;
		if (!is_new()) {
			return;
		}
		if (HR_List != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_List foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_List", "HR_List_UU=?", get_TrxName())
							.setParameters(HR_List.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setHR_List_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_List with UU " + HR_List.getUU());
			}
		} else {
			this.setHR_List_ID(0);
		}
	}

	/**
	 * Get Payroll List.
	 *
	 * @return Payroll List
	 */
	@JsonProperty("HR_List")
	public ForeignEntityInput HR_List() {
		return mHR_List;
	}

	/**
	 * Set Payroll List Base.
	 *
	 * @param HR_ListBase Payroll List Base
	 */
	@JsonProperty("HR_ListBase")
	public void setHR_ListBaseInput(ForeignEntityInput HR_ListBase) {
		this.mHR_ListBase = HR_ListBase;
		if (HR_ListBase != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_List foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_List", "HR_List_UU=?", get_TrxName())
							.setParameters(HR_ListBase.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setHR_ListBase_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_List with UU " + HR_ListBase.getUU());
			}
		} else {
			this.setHR_ListBase_ID(0);
		}
	}

	/**
	 * Get Payroll List Base.
	 *
	 * @return Payroll List Base
	 */
	@JsonProperty("HR_ListBase")
	public ForeignEntityInput HR_ListBase() {
		return mHR_ListBase;
	}
	/**
	 * Set Payroll List Version.
	 *
	 * @param HR_ListVersion_ID Payroll List Version
	 */
	@JsonProperty("HR_ListVersion_ID")
	public void setHR_ListVersion_IDFromJson(int HR_ListVersion_ID) {
		if (get_ID() == 0) {
			super.setHR_ListVersion_ID(HR_ListVersion_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setHR_ListVersion_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getHR_ListVersion_UU();
	}
}
