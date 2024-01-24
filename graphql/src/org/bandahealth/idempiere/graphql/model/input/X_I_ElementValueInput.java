package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MElement;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_I_ElementValue;

import java.sql.ResultSet;

/**
 * Generated Model for I_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_ElementValueInput extends X_I_ElementValue implements I_I_ElementValueInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Element;
	private ForeignEntityInput mC_ElementValue;
	private ForeignEntityInput mParentElementValue;
	private I_AD_Ref_ListInput mAccountSign;
	private I_AD_Ref_ListInput mAccountType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_I_ElementValueInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_I_ElementValue(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Account Sign.
	 *
	 * @param AccountSign Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	@JsonProperty("AccountSign")
	public void setAccountSignInput(I_AD_Ref_ListInput AccountSign) {
		this.mAccountSign = AccountSign;
		MRefList_BH foreignEntity;
		if (AccountSign != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccountSign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAccountSign(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput AccountSign() {
		return mAccountSign;
	}

	/**
	 * Set Account Type.
	 *
	 * @param AccountType Indicates the type of account
	 */
	@JsonProperty("AccountType")
	public void setAccountTypeInput(I_AD_Ref_ListInput AccountType) {
		this.mAccountType = AccountType;
		MRefList_BH foreignEntity;
		if (AccountType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccountType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAccountType(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput AccountType() {
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
		MColumn foreignEntity;
		if (AD_Column != null &&
				(foreignEntity = new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
						.setParameters(AD_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Column_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Column_ID(0);
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
	 * Set Element.
	 *
	 * @param C_Element Accounting Element
	 */
	@JsonProperty("C_Element")
	public void setC_ElementInput(ForeignEntityInput C_Element) {
		this.mC_Element = C_Element;
		MElement foreignEntity;
		if (C_Element != null &&
				(foreignEntity = new Query(getCtx(), "C_Element", "C_Element_UU=?", get_TrxName())
						.setParameters(C_Element.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Element_ID(foreignEntity.get_ID());
		} else {
			super.setC_Element_ID(0);
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
		MElementValue foreignEntity;
		if (C_ElementValue != null &&
				(foreignEntity = new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
						.setParameters(C_ElementValue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ElementValue_ID(foreignEntity.get_ID());
		} else {
			super.setC_ElementValue_ID(0);
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

	public void setI_ElementValue_ID(int I_ElementValue_ID) {
		if (get_ID() == 0) {
			super.setI_ElementValue_ID(I_ElementValue_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setI_ElementValue_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MElementValue foreignEntity;
		if (ParentElementValue != null &&
				(foreignEntity = new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
						.setParameters(ParentElementValue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setParentElementValue_ID(foreignEntity.get_ID());
		} else {
			super.setParentElementValue_ID(0);
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
