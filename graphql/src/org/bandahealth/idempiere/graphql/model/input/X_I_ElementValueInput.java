package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_I_ElementValueResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MElement;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_I_ElementValue;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for I_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_ElementValueInput extends X_I_ElementValue implements I_I_ElementValueInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAccountSign;
	private ForeignEntityInput mAccountType;
	private ForeignEntityInput mC_Element;
	private ForeignEntityInput mC_ElementValue;
	private ForeignEntityInput mParentElementValue;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The I_ElementValue_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_I_ElementValueInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Account Sign.
	 *
	 * @param AccountSign Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	@JsonProperty("AccountSign")
	public void setAccountSignInput(ForeignEntityInput AccountSign) {
		this.mAccountSign = AccountSign;
		if (AccountSign != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_I_ElementValueResolver.ACCOUNTSIGN_UUIDS_BY_VALUE.containsValue(AccountSign.getUU())) {
				throw new AdempiereException("The reference list UU of " + AccountSign.getUU() +
						" is not in the list defined for the AccountSign column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AccountSign.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAccountSign(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AccountSign.getUU());
			}
		} else {
			this.setAccountSign(null);
		}
	}

	/**
	 * Get Account Sign.
	 *
	 * @return Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	@JsonProperty("AccountSign")
	public ForeignEntityInput AccountSign() {
		return mAccountSign;
	}

	/**
	 * Set Account Type.
	 *
	 * @param AccountType Indicates the type of account
	 */
	@JsonProperty("AccountType")
	public void setAccountTypeInput(ForeignEntityInput AccountType) {
		this.mAccountType = AccountType;
		if (AccountType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_I_ElementValueResolver.ACCOUNTTYPE_UUIDS_BY_VALUE.containsValue(AccountType.getUU())) {
				throw new AdempiereException("The reference list UU of " + AccountType.getUU() +
						" is not in the list defined for the AccountType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AccountType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAccountType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AccountType.getUU());
			}
		} else {
			this.setAccountType(null);
		}
	}

	/**
	 * Get Account Type.
	 *
	 * @return Indicates the type of account
	 */
	@JsonProperty("AccountType")
	public ForeignEntityInput AccountType() {
		return mAccountType;
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		if (AD_Column != null) {
			// Since an entity was passed, make sure it's in the DB
			MColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
							.setParameters(AD_Column.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UU " + AD_Column.getUU());
			}
		} else {
			this.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	@JsonProperty("AD_Column")
	public ForeignEntityInput AD_Column() {
		return mAD_Column;
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
	 * Set Element.
	 *
	 * @param C_Element Accounting Element
	 */
	@JsonProperty("C_Element")
	public void setC_ElementInput(ForeignEntityInput C_Element) {
		this.mC_Element = C_Element;
		if (C_Element != null) {
			// Since an entity was passed, make sure it's in the DB
			MElement foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Element", "C_Element_UU=?", get_TrxName())
							.setParameters(C_Element.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Element_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Element with UU " + C_Element.getUU());
			}
		} else {
			this.setC_Element_ID(0);
		}
	}

	/**
	 * Get Element.
	 *
	 * @return Accounting Element
	 */
	@JsonProperty("C_Element")
	public ForeignEntityInput C_Element() {
		return mC_Element;
	}

	/**
	 * Set Account Element.
	 *
	 * @param C_ElementValue Account Element
	 */
	@JsonProperty("C_ElementValue")
	public void setC_ElementValueInput(ForeignEntityInput C_ElementValue) {
		this.mC_ElementValue = C_ElementValue;
		if (C_ElementValue != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(C_ElementValue.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_ElementValue_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UU " + C_ElementValue.getUU());
			}
		} else {
			this.setC_ElementValue_ID(0);
		}
	}

	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	@JsonProperty("C_ElementValue")
	public ForeignEntityInput C_ElementValue() {
		return mC_ElementValue;
	}
	/**
	 * Set Import Account.
	 *
	 * @param I_ElementValue_ID Import Account Value
	 */
	@JsonProperty("I_ElementValue_ID")
	public void setI_ElementValue_IDFromJson(int I_ElementValue_ID) {
		if (get_ID() == 0) {
			super.setI_ElementValue_ID(I_ElementValue_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setI_ElementValue_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getI_ElementValue_UU();
	}

	/**
	 * Set Parent Account.
	 *
	 * @param ParentElementValue The parent (summary) account
	 */
	@JsonProperty("ParentElementValue")
	public void setParentElementValueInput(ForeignEntityInput ParentElementValue) {
		this.mParentElementValue = ParentElementValue;
		if (ParentElementValue != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(ParentElementValue.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setParentElementValue_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UU " + ParentElementValue.getUU());
			}
		} else {
			this.setParentElementValue_ID(0);
		}
	}

	/**
	 * Get Parent Account.
	 *
	 * @return The parent (summary) account
	 */
	@JsonProperty("ParentElementValue")
	public ForeignEntityInput ParentElementValue() {
		return mParentElementValue;
	}
}
