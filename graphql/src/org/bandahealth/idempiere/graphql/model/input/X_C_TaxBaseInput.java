package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_TaxBaseResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_C_TaxBase;

import java.sql.ResultSet;

/**
 * Generated Model for C_TaxBase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxBaseInput extends X_C_TaxBase implements I_C_TaxBaseInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBase;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_TaxBase_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_TaxBaseInput(@JsonProperty("UU") String UU) {
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
		if (get_ID() != 0) {
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
	 * Set Base.
	 *
	 * @param Base Calculation Base
	 */
	@JsonProperty("Base")
	public void setBaseInput(ForeignEntityInput Base) {
		this.mBase = Base;
		if (Base != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_TaxBaseResolver.BASE_UUIDS_BY_VALUE.containsValue(Base.getUU())) {
				throw new AdempiereException("The reference list UU of " + Base.getUU() +
						" is not in the list defined for the Base column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Base.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBase(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Base.getUU());
			}
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
	public ForeignEntityInput Base() {
		return mBase;
	}
	/**
	 * Set Tax Base.
	 *
	 * @param C_TaxBase_ID Tax Base
	 */
	@JsonProperty("C_TaxBase_ID")
	public void setC_TaxBase_IDFromJson(int C_TaxBase_ID) {
		if (get_ID() == 0) {
			super.setC_TaxBase_ID(C_TaxBase_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_TaxBase_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_TaxBase_UU();
	}
}
