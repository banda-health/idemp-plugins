package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCountry;
import org.compiere.model.MCountryGroup;
import org.compiere.model.MOrg;
import org.compiere.model.MRegion;
import org.compiere.model.MRule;
import org.compiere.model.MTax;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MTaxProvider;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxInput extends MTax implements I_C_TaxInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mSOPOType;
	 private I_AD_RuleInput mAD_Rule;
	 private I_C_CountryGroupInput mC_CountryGroupFrom;
	 private I_C_CountryGroupInput mC_CountryGroupTo;
	 private I_C_CountryInput mC_Country;
	 private I_C_RegionInput mC_Region;
	 private I_C_RegionInput mTo_Region;
	 private I_C_TaxCategoryInput mC_TaxCategory;
	 private I_C_TaxInput mParent_Tax;
	 private I_C_TaxProviderInput mC_TaxProvider;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_TaxInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Rule.
	 *
	 * @param AD_Rule Rule
	 */
	@JsonProperty("AD_Rule")
	public void setAD_RuleInput(I_AD_RuleInput AD_Rule) {
		this.mAD_Rule = AD_Rule;
		MRule foreignEntity;
		if (AD_Rule != null &&
				(foreignEntity = new Query(getCtx(), MRule.Table_Name, MRule.COLUMNNAME_AD_Rule_UU + "=?", get_TrxName())
						.setParameters(AD_Rule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Rule_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Rule_ID(0);
		}
	}

	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	@JsonProperty("AD_Rule")
	public I_AD_RuleInput AD_Rule() {
		return mAD_Rule;
	}

	/**
	 * Set Country.
	 *
	 * @param C_Country Country 
	 */
	@JsonProperty("C_Country")
	public void setC_CountryInput(I_C_CountryInput C_Country) {
		this.mC_Country = C_Country;
		MCountry foreignEntity;
		if (C_Country != null &&
				(foreignEntity = new Query(getCtx(), MCountry.Table_Name, MCountry.COLUMNNAME_C_Country_UU + "=?", get_TrxName())
						.setParameters(C_Country.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Country_ID(foreignEntity.get_ID());
		} else {
			super.setC_Country_ID(0);
		}
	}

	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	@JsonProperty("C_Country")
	public I_C_CountryInput C_Country() {
		return mC_Country;
	}

	/**
	 * Set Country Group From.
	 *
	 * @param C_CountryGroupFrom Country Group From
	 */
	@JsonProperty("C_CountryGroupFrom")
	public void setC_CountryGroupFromInput(I_C_CountryGroupInput C_CountryGroupFrom) {
		this.mC_CountryGroupFrom = C_CountryGroupFrom;
		MCountryGroup foreignEntity;
		if (C_CountryGroupFrom != null &&
				(foreignEntity = new Query(getCtx(), MCountryGroup.Table_Name, MCountryGroup.COLUMNNAME_C_CountryGroup_UU + "=?", get_TrxName())
						.setParameters(C_CountryGroupFrom.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_CountryGroupFrom_ID(foreignEntity.get_ID());
		} else {
			super.setC_CountryGroupFrom_ID(0);
		}
	}

	/**
	 * Get Country Group From.
	 *
	 * @return Country Group From
	 */
	@JsonProperty("C_CountryGroupFrom")
	public I_C_CountryGroupInput C_CountryGroupFrom() {
		return mC_CountryGroupFrom;
	}

	/**
	 * Set Country Group To.
	 *
	 * @param C_CountryGroupTo Country Group To
	 */
	@JsonProperty("C_CountryGroupTo")
	public void setC_CountryGroupToInput(I_C_CountryGroupInput C_CountryGroupTo) {
		this.mC_CountryGroupTo = C_CountryGroupTo;
		MCountryGroup foreignEntity;
		if (C_CountryGroupTo != null &&
				(foreignEntity = new Query(getCtx(), MCountryGroup.Table_Name, MCountryGroup.COLUMNNAME_C_CountryGroup_UU + "=?", get_TrxName())
						.setParameters(C_CountryGroupTo.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_CountryGroupTo_ID(foreignEntity.get_ID());
		} else {
			super.setC_CountryGroupTo_ID(0);
		}
	}

	/**
	 * Get Country Group To.
	 *
	 * @return Country Group To
	 */
	@JsonProperty("C_CountryGroupTo")
	public I_C_CountryGroupInput C_CountryGroupTo() {
		return mC_CountryGroupTo;
	}

	/**
	 * Set Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public void setC_RegionInput(I_C_RegionInput C_Region) {
		this.mC_Region = C_Region;
		MRegion foreignEntity;
		if (C_Region != null &&
				(foreignEntity = new Query(getCtx(), MRegion.Table_Name, MRegion.COLUMNNAME_C_Region_UU + "=?", get_TrxName())
						.setParameters(C_Region.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Region_ID(foreignEntity.get_ID());
		} else {
			super.setC_Region_ID(0);
		}
	}

	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public I_C_RegionInput C_Region() {
		return mC_Region;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Tax_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Tax_UU();
	}

	/**
	 * Set Tax Category.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	@JsonProperty("C_TaxCategory")
	public void setC_TaxCategoryInput(I_C_TaxCategoryInput C_TaxCategory) {
		this.mC_TaxCategory = C_TaxCategory;
		MTaxCategory foreignEntity;
		if (C_TaxCategory != null &&
				(foreignEntity = new Query(getCtx(), MTaxCategory.Table_Name, MTaxCategory.COLUMNNAME_C_TaxCategory_UU + "=?", get_TrxName())
						.setParameters(C_TaxCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_TaxCategory_ID(foreignEntity.get_ID());
		} else {
			super.setC_TaxCategory_ID(0);
		}
	}

	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	@JsonProperty("C_TaxCategory")
	public I_C_TaxCategoryInput C_TaxCategory() {
		return mC_TaxCategory;
	}

	/**
	 * Set Tax Provider.
	 *
	 * @param C_TaxProvider Tax Provider
	 */
	@JsonProperty("C_TaxProvider")
	public void setC_TaxProviderInput(I_C_TaxProviderInput C_TaxProvider) {
		this.mC_TaxProvider = C_TaxProvider;
		MTaxProvider foreignEntity;
		if (C_TaxProvider != null &&
				(foreignEntity = new Query(getCtx(), MTaxProvider.Table_Name, MTaxProvider.COLUMNNAME_C_TaxProvider_UU + "=?", get_TrxName())
						.setParameters(C_TaxProvider.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_TaxProvider_ID(foreignEntity.get_ID());
		} else {
			super.setC_TaxProvider_ID(0);
		}
	}

	/**
	 * Get Tax Provider.
	 *
	 * @return Tax Provider
	 */
	@JsonProperty("C_TaxProvider")
	public I_C_TaxProviderInput C_TaxProvider() {
		return mC_TaxProvider;
	}

	/**
	 * Set Parent Tax.
	 *
	 * @param Parent_Tax Parent Tax indicates a tax that is made up of multiple taxes
	 */
	@JsonProperty("Parent_Tax")
	public void setParent_TaxInput(I_C_TaxInput Parent_Tax) {
		this.mParent_Tax = Parent_Tax;
		MTax foreignEntity;
		if (Parent_Tax != null &&
				(foreignEntity = new Query(getCtx(), MTax.Table_Name, MTax.COLUMNNAME_C_Tax_UU + "=?", get_TrxName())
						.setParameters(Parent_Tax.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setParent_Tax_ID(foreignEntity.get_ID());
		} else {
			super.setParent_Tax_ID(0);
		}
	}

	/**
	 * Get Parent Tax.
	 *
	 * @return Parent Tax indicates a tax that is made up of multiple taxes
	 */
	@JsonProperty("Parent_Tax")
	public I_C_TaxInput Parent_Tax() {
		return mParent_Tax;
	}

	/**
	 * Set SO/PO Type.
	 *
	 * @param SOPOType Sales Tax applies to sales situations, Purchase Tax to purchase situations
	 */
	@JsonProperty("SOPOType")
	public void setSOPOTypeInput(I_AD_Ref_ListInput SOPOType) {
		this.mSOPOType = SOPOType;
		MRefList_BH foreignEntity;
		if (SOPOType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(SOPOType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSOPOType(foreignEntity.getValue());
		} else {
			this.setSOPOType(null);
		}
	}

	/**
	 * Get SO/PO Type.
	 *
	 * @return Sales Tax applies to sales situations, Purchase Tax to purchase situations
	 */
	@JsonProperty("SOPOType")
	public I_AD_Ref_ListInput SOPOType() {
		return mSOPOType;
	}

	/**
	 * Set To.
	 *
	 * @param To_Region Receiving Region
	 */
	@JsonProperty("To_Region")
	public void setTo_RegionInput(I_C_RegionInput To_Region) {
		this.mTo_Region = To_Region;
		MRegion foreignEntity;
		if (To_Region != null &&
				(foreignEntity = new Query(getCtx(), MRegion.Table_Name, MRegion.COLUMNNAME_C_Region_UU + "=?", get_TrxName())
						.setParameters(To_Region.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setTo_Region_ID(foreignEntity.get_ID());
		} else {
			super.setTo_Region_ID(0);
		}
	}

	/**
	 * Get To.
	 *
	 * @return Receiving Region
	 */
	@JsonProperty("To_Region")
	public I_C_RegionInput To_Region() {
		return mTo_Region;
	}
}
