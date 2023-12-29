package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCountry;
import org.compiere.model.MCountryGroup;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput SOPOType_RL;
	 private I_AD_RuleInput AD_Rule;
	 private I_C_CountryGroupInput C_CountryGroupFrom;
	 private I_C_CountryGroupInput C_CountryGroupTo;
	 private I_C_CountryInput C_Country;
	 private I_C_RegionInput C_Region;
	 private I_C_RegionInput To_Region;
	 private I_C_TaxCategoryInput C_TaxCategory;
	 private I_C_TaxInput Parent_Tax;
	 private I_C_TaxProviderInput C_TaxProvider;

	/**
	 * Standard constructor
	 */
	public X_C_TaxInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Rule.
	 *
	 * @param AD_Rule Rule
	 */
	public void setAD_Rule(I_AD_RuleInput AD_Rule) {
		this.AD_Rule = AD_Rule;
		MRule foreignEntity;
		if (AD_Rule != null &&
				(foreignEntity = new Query(getCtx(), MRule.Table_Name, MRule.COLUMNNAME_AD_Rule_UU + "=?", get_TrxName())
						.setParameters(AD_Rule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Rule_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Rule_ID(0);
		}
	}

	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	public I_AD_RuleInput getAD_Rule() {
		return AD_Rule;
	}

	/**
	 * Set Country.
	 *
	 * @param C_Country Country 
	 */
	public void setC_Country(I_C_CountryInput C_Country) {
		this.C_Country = C_Country;
		MCountry foreignEntity;
		if (C_Country != null &&
				(foreignEntity = new Query(getCtx(), MCountry.Table_Name, MCountry.COLUMNNAME_C_Country_UU + "=?", get_TrxName())
						.setParameters(C_Country.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Country_ID(foreignEntity.get_ID());
		} else {
			this.setC_Country_ID(0);
		}
	}

	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	public I_C_CountryInput getC_Country() {
		return C_Country;
	}

	/**
	 * Set Country Group From.
	 *
	 * @param C_CountryGroupFrom Country Group From
	 */
	public void setC_CountryGroupFrom(I_C_CountryGroupInput C_CountryGroupFrom) {
		this.C_CountryGroupFrom = C_CountryGroupFrom;
		MCountryGroup foreignEntity;
		if (C_CountryGroupFrom != null &&
				(foreignEntity = new Query(getCtx(), MCountryGroup.Table_Name, MCountryGroup.COLUMNNAME_C_CountryGroup_UU + "=?", get_TrxName())
						.setParameters(C_CountryGroupFrom.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_CountryGroupFrom_ID(foreignEntity.get_ID());
		} else {
			this.setC_CountryGroupFrom_ID(0);
		}
	}

	/**
	 * Get Country Group From.
	 *
	 * @return Country Group From
	 */
	public I_C_CountryGroupInput getC_CountryGroupFrom() {
		return C_CountryGroupFrom;
	}

	/**
	 * Set Country Group To.
	 *
	 * @param C_CountryGroupTo Country Group To
	 */
	public void setC_CountryGroupTo(I_C_CountryGroupInput C_CountryGroupTo) {
		this.C_CountryGroupTo = C_CountryGroupTo;
		MCountryGroup foreignEntity;
		if (C_CountryGroupTo != null &&
				(foreignEntity = new Query(getCtx(), MCountryGroup.Table_Name, MCountryGroup.COLUMNNAME_C_CountryGroup_UU + "=?", get_TrxName())
						.setParameters(C_CountryGroupTo.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_CountryGroupTo_ID(foreignEntity.get_ID());
		} else {
			this.setC_CountryGroupTo_ID(0);
		}
	}

	/**
	 * Get Country Group To.
	 *
	 * @return Country Group To
	 */
	public I_C_CountryGroupInput getC_CountryGroupTo() {
		return C_CountryGroupTo;
	}

	/**
	 * Set Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	public void setC_Region(I_C_RegionInput C_Region) {
		this.C_Region = C_Region;
		MRegion foreignEntity;
		if (C_Region != null &&
				(foreignEntity = new Query(getCtx(), MRegion.Table_Name, MRegion.COLUMNNAME_C_Region_UU + "=?", get_TrxName())
						.setParameters(C_Region.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Region_ID(foreignEntity.get_ID());
		} else {
			this.setC_Region_ID(0);
		}
	}

	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	public I_C_RegionInput getC_Region() {
		return C_Region;
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
	public void setC_TaxCategory(I_C_TaxCategoryInput C_TaxCategory) {
		this.C_TaxCategory = C_TaxCategory;
		MTaxCategory foreignEntity;
		if (C_TaxCategory != null &&
				(foreignEntity = new Query(getCtx(), MTaxCategory.Table_Name, MTaxCategory.COLUMNNAME_C_TaxCategory_UU + "=?", get_TrxName())
						.setParameters(C_TaxCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_TaxCategory_ID(foreignEntity.get_ID());
		} else {
			this.setC_TaxCategory_ID(0);
		}
	}

	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	public I_C_TaxCategoryInput getC_TaxCategory() {
		return C_TaxCategory;
	}

	/**
	 * Set Tax Provider.
	 *
	 * @param C_TaxProvider Tax Provider
	 */
	public void setC_TaxProvider(I_C_TaxProviderInput C_TaxProvider) {
		this.C_TaxProvider = C_TaxProvider;
		MTaxProvider foreignEntity;
		if (C_TaxProvider != null &&
				(foreignEntity = new Query(getCtx(), MTaxProvider.Table_Name, MTaxProvider.COLUMNNAME_C_TaxProvider_UU + "=?", get_TrxName())
						.setParameters(C_TaxProvider.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_TaxProvider_ID(foreignEntity.get_ID());
		} else {
			this.setC_TaxProvider_ID(0);
		}
	}

	/**
	 * Get Tax Provider.
	 *
	 * @return Tax Provider
	 */
	public I_C_TaxProviderInput getC_TaxProvider() {
		return C_TaxProvider;
	}

	/**
	 * Set Parent Tax.
	 *
	 * @param Parent_Tax Parent Tax indicates a tax that is made up of multiple taxes
	 */
	public void setParent_Tax(I_C_TaxInput Parent_Tax) {
		this.Parent_Tax = Parent_Tax;
		MTax foreignEntity;
		if (Parent_Tax != null &&
				(foreignEntity = new Query(getCtx(), MTax.Table_Name, MTax.COLUMNNAME_C_Tax_UU + "=?", get_TrxName())
						.setParameters(Parent_Tax.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setParent_Tax_ID(foreignEntity.get_ID());
		} else {
			this.setParent_Tax_ID(0);
		}
	}

	/**
	 * Get Parent Tax.
	 *
	 * @return Parent Tax indicates a tax that is made up of multiple taxes
	 */
	public I_C_TaxInput getParent_Tax() {
		return Parent_Tax;
	}

	/**
	 * Set SO/PO Type.
	 *
	 * @param SOPOType_RL Sales Tax applies to sales situations, Purchase Tax to purchase situations
	 */
	public void setSOPOType_RL(I_AD_Ref_ListInput SOPOType_RL) {
		this.SOPOType_RL = SOPOType_RL;
		MRefList foreignEntity;
		if (SOPOType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(SOPOType_RL.getID())
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
	public I_AD_Ref_ListInput getSOPOType_RL() {
		return SOPOType_RL;
	}

	/**
	 * Set To.
	 *
	 * @param To_Region Receiving Region
	 */
	public void setTo_Region(I_C_RegionInput To_Region) {
		this.To_Region = To_Region;
		MRegion foreignEntity;
		if (To_Region != null &&
				(foreignEntity = new Query(getCtx(), MRegion.Table_Name, MRegion.COLUMNNAME_C_Region_UU + "=?", get_TrxName())
						.setParameters(To_Region.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTo_Region_ID(foreignEntity.get_ID());
		} else {
			this.setTo_Region_ID(0);
		}
	}

	/**
	 * Get To.
	 *
	 * @return Receiving Region
	 */
	public I_C_RegionInput getTo_Region() {
		return To_Region;
	}
}
