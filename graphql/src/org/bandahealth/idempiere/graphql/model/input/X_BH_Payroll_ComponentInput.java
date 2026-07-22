package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_Payroll_ComponentResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Payroll_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_ComponentInput extends MBHPayrollComponent implements I_BH_Payroll_ComponentInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_CalcMethod;
	private ForeignEntityInput mBH_Category;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Payroll_Component_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Payroll_ComponentInput(@JsonProperty("UU") String UU) {
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
	 * Set Calculation Method.
	 *
	 * @param BH_CalcMethod Calculation Method
	 */
	@JsonProperty("BH_CalcMethod")
	public void setBH_CalcMethodInput(ForeignEntityInput BH_CalcMethod) {
		this.mBH_CalcMethod = BH_CalcMethod;
		if (BH_CalcMethod != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Payroll_ComponentResolver.BH_CALCMETHOD_UUIDS_BY_VALUE.containsValue(BH_CalcMethod.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_CalcMethod.getUU() +
						" is not in the list defined for the BH_CalcMethod column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_CalcMethod.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_CalcMethod(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_CalcMethod.getUU());
			}
		} else {
			this.setBH_CalcMethod(null);
		}
	}

	/**
	 * Get Calculation Method.
	 *
	 * @return Calculation Method
	 */
	@JsonProperty("BH_CalcMethod")
	public ForeignEntityInput BH_CalcMethod() {
		return mBH_CalcMethod;
	}

	/**
	 * Set Category.
	 *
	 * @param BH_Category Category
	 */
	@JsonProperty("BH_Category")
	public void setBH_CategoryInput(ForeignEntityInput BH_Category) {
		this.mBH_Category = BH_Category;
		if (BH_Category != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Payroll_ComponentResolver.BH_CATEGORY_UUIDS_BY_VALUE.containsValue(BH_Category.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Category.getUU() +
						" is not in the list defined for the BH_Category column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Category.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Category(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Category.getUU());
			}
		} else {
			this.setBH_Category(null);
		}
	}

	/**
	 * Get Category.
	 *
	 * @return Category
	 */
	@JsonProperty("BH_Category")
	public ForeignEntityInput BH_Category() {
		return mBH_Category;
	}

	/**
	 * Set Payroll Component.
	 *
	 * @param BH_Payroll_Component_ID Payroll Component
	 */
	@JsonProperty("BH_Payroll_Component_ID")
	public void setBH_Payroll_Component_IDFromJson(int BH_Payroll_Component_ID) {
		if (get_ID() == 0) {
			super.setBH_Payroll_Component_ID(BH_Payroll_Component_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Payroll_Component_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Payroll_Component_UU();
	}
}
