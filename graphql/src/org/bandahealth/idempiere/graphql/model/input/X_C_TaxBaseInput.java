package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.eevolution.model.X_C_TaxBase;

import java.sql.ResultSet;

/**
 * Generated Model for C_TaxBase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxBaseInput extends X_C_TaxBase implements I_C_TaxBaseInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mBase;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_TaxBaseInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_TaxBase(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
	 * Set Base.
	 *
	 * @param Base Calculation Base
	 */
	@JsonProperty("Base")
	public void setBaseInput(I_AD_Ref_ListInput Base) {
		this.mBase = Base;
		MRefList_BH foreignEntity;
		if (Base != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Base.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBase(foreignEntity.getValue());
		} else {
			this.setBase(null);
		}
	}

	/**
	 * Get Base.
	 *
	 * @return Calculation Base
	 */
	@JsonProperty("Base")
	public I_AD_Ref_ListInput Base() {
		return mBase;
	}
	/**
	 * Set Tax Base.
	 *
	 * @param C_TaxBase_ID Tax Base
	 */

	public void setC_TaxBase_ID(int C_TaxBase_ID) {
		if (get_ID() == 0) {
			super.setC_TaxBase_ID(C_TaxBase_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_TaxBase_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_TaxBase_UU();
	}
}
