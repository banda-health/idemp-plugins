package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_TaxResolver;
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

import java.sql.ResultSet;

/**
 * Generated Model for C_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxInput extends MTax implements I_C_TaxInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Rule;
	private ForeignEntityInput mC_Country;
	private ForeignEntityInput mC_CountryGroupFrom;
	private ForeignEntityInput mC_CountryGroupTo;
	private ForeignEntityInput mC_Region;
	private ForeignEntityInput mC_TaxCategory;
	private ForeignEntityInput mC_TaxProvider;
	private ForeignEntityInput mParent_Tax;
	private ForeignEntityInput mSOPOType;
	private ForeignEntityInput mTaxPostingIndicator;
	private ForeignEntityInput mTo_Region;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_Tax_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_TaxInput(@JsonProperty("UU") String UU) {
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
	 * Set Rule.
	 *
	 * @param AD_Rule Rule
	 */
	@JsonProperty("AD_Rule")
	public void setAD_RuleInput(ForeignEntityInput AD_Rule) {
		this.mAD_Rule = AD_Rule;
		if (AD_Rule != null) {
			// Since an entity was passed, make sure it's in the DB
			MRule foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Rule", "AD_Rule_UU=?", get_TrxName())
							.setParameters(AD_Rule.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Rule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Rule with UU " + AD_Rule.getUU());
			}
		} else {
			this.setAD_Rule_ID(0);
		}
	}

	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	@JsonProperty("AD_Rule")
	public ForeignEntityInput AD_Rule() {
		return mAD_Rule;
	}

	/**
	 * Set Country.
	 *
	 * @param C_Country Country 
	 */
	@JsonProperty("C_Country")
	public void setC_CountryInput(ForeignEntityInput C_Country) {
		this.mC_Country = C_Country;
		if (C_Country != null) {
			// Since an entity was passed, make sure it's in the DB
			MCountry foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Country", "C_Country_UU=?", get_TrxName())
							.setParameters(C_Country.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Country_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Country with UU " + C_Country.getUU());
			}
		} else {
			this.setC_Country_ID(0);
		}
	}

	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	@JsonProperty("C_Country")
	public ForeignEntityInput C_Country() {
		return mC_Country;
	}

	/**
	 * Set Country Group From.
	 *
	 * @param C_CountryGroupFrom Country Group From
	 */
	@JsonProperty("C_CountryGroupFrom")
	public void setC_CountryGroupFromInput(ForeignEntityInput C_CountryGroupFrom) {
		this.mC_CountryGroupFrom = C_CountryGroupFrom;
		if (C_CountryGroupFrom != null) {
			// Since an entity was passed, make sure it's in the DB
			MCountryGroup foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CountryGroup", "C_CountryGroup_UU=?", get_TrxName())
							.setParameters(C_CountryGroupFrom.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_CountryGroupFrom_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CountryGroup with UU " + C_CountryGroupFrom.getUU());
			}
		} else {
			this.setC_CountryGroupFrom_ID(0);
		}
	}

	/**
	 * Get Country Group From.
	 *
	 * @return Country Group From
	 */
	@JsonProperty("C_CountryGroupFrom")
	public ForeignEntityInput C_CountryGroupFrom() {
		return mC_CountryGroupFrom;
	}

	/**
	 * Set Country Group To.
	 *
	 * @param C_CountryGroupTo Country Group To
	 */
	@JsonProperty("C_CountryGroupTo")
	public void setC_CountryGroupToInput(ForeignEntityInput C_CountryGroupTo) {
		this.mC_CountryGroupTo = C_CountryGroupTo;
		if (C_CountryGroupTo != null) {
			// Since an entity was passed, make sure it's in the DB
			MCountryGroup foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CountryGroup", "C_CountryGroup_UU=?", get_TrxName())
							.setParameters(C_CountryGroupTo.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_CountryGroupTo_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CountryGroup with UU " + C_CountryGroupTo.getUU());
			}
		} else {
			this.setC_CountryGroupTo_ID(0);
		}
	}

	/**
	 * Get Country Group To.
	 *
	 * @return Country Group To
	 */
	@JsonProperty("C_CountryGroupTo")
	public ForeignEntityInput C_CountryGroupTo() {
		return mC_CountryGroupTo;
	}

	/**
	 * Set Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public void setC_RegionInput(ForeignEntityInput C_Region) {
		this.mC_Region = C_Region;
		if (C_Region != null) {
			// Since an entity was passed, make sure it's in the DB
			MRegion foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Region", "C_Region_UU=?", get_TrxName())
							.setParameters(C_Region.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Region_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Region with UU " + C_Region.getUU());
			}
		} else {
			this.setC_Region_ID(0);
		}
	}

	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public ForeignEntityInput C_Region() {
		return mC_Region;
	}
	/**
	 * Set Tax.
	 *
	 * @param C_Tax_ID Tax identifier
	 */
	@JsonProperty("C_Tax_ID")
	public void setC_Tax_IDFromJson(int C_Tax_ID) {
		if (get_ID() == 0) {
			super.setC_Tax_ID(C_Tax_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_Tax_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_Tax_UU();
	}

	/**
	 * Set Tax Category.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	@JsonProperty("C_TaxCategory")
	public void setC_TaxCategoryInput(ForeignEntityInput C_TaxCategory) {
		this.mC_TaxCategory = C_TaxCategory;
		if (C_TaxCategory != null) {
			// Since an entity was passed, make sure it's in the DB
			MTaxCategory foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxCategory", "C_TaxCategory_UU=?", get_TrxName())
							.setParameters(C_TaxCategory.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_TaxCategory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxCategory with UU " + C_TaxCategory.getUU());
			}
		} else {
			this.setC_TaxCategory_ID(0);
		}
	}

	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	@JsonProperty("C_TaxCategory")
	public ForeignEntityInput C_TaxCategory() {
		return mC_TaxCategory;
	}

	/**
	 * Set Tax Provider.
	 *
	 * @param C_TaxProvider Tax Provider
	 */
	@JsonProperty("C_TaxProvider")
	public void setC_TaxProviderInput(ForeignEntityInput C_TaxProvider) {
		this.mC_TaxProvider = C_TaxProvider;
		if (C_TaxProvider != null) {
			// Since an entity was passed, make sure it's in the DB
			MTaxProvider foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxProvider", "C_TaxProvider_UU=?", get_TrxName())
							.setParameters(C_TaxProvider.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_TaxProvider_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxProvider with UU " + C_TaxProvider.getUU());
			}
		} else {
			this.setC_TaxProvider_ID(0);
		}
	}

	/**
	 * Get Tax Provider.
	 *
	 * @return Tax Provider
	 */
	@JsonProperty("C_TaxProvider")
	public ForeignEntityInput C_TaxProvider() {
		return mC_TaxProvider;
	}

	/**
	 * Set Parent Tax.
	 *
	 * @param Parent_Tax Parent Tax indicates a tax that is made up of multiple taxes
	 */
	@JsonProperty("Parent_Tax")
	public void setParent_TaxInput(ForeignEntityInput Parent_Tax) {
		this.mParent_Tax = Parent_Tax;
		if (Parent_Tax != null) {
			// Since an entity was passed, make sure it's in the DB
			MTax foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Tax", "C_Tax_UU=?", get_TrxName())
							.setParameters(Parent_Tax.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setParent_Tax_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Tax with UU " + Parent_Tax.getUU());
			}
		} else {
			this.setParent_Tax_ID(0);
		}
	}

	/**
	 * Get Parent Tax.
	 *
	 * @return Parent Tax indicates a tax that is made up of multiple taxes
	 */
	@JsonProperty("Parent_Tax")
	public ForeignEntityInput Parent_Tax() {
		return mParent_Tax;
	}

	/**
	 * Set SO/PO Type.
	 *
	 * @param SOPOType Sales Tax applies to sales situations, Purchase Tax to purchase situations
	 */
	@JsonProperty("SOPOType")
	public void setSOPOTypeInput(ForeignEntityInput SOPOType) {
		this.mSOPOType = SOPOType;
		if (SOPOType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_TaxResolver.SOPOTYPE_UUIDS_BY_VALUE.containsValue(SOPOType.getUU())) {
				throw new AdempiereException("The reference list UU of " + SOPOType.getUU() +
						" is not in the list defined for the SOPOType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(SOPOType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setSOPOType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + SOPOType.getUU());
			}
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
	public ForeignEntityInput SOPOType() {
		return mSOPOType;
	}

	/**
	 * Set Posting Indicator.
	 *
	 * @param TaxPostingIndicator Type of input tax (deductible and non deductible)
	 */
	@JsonProperty("TaxPostingIndicator")
	public void setTaxPostingIndicatorInput(ForeignEntityInput TaxPostingIndicator) {
		this.mTaxPostingIndicator = TaxPostingIndicator;
		if (TaxPostingIndicator != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_TaxResolver.TAXPOSTINGINDICATOR_UUIDS_BY_VALUE.containsValue(TaxPostingIndicator.getUU())) {
				throw new AdempiereException("The reference list UU of " + TaxPostingIndicator.getUU() +
						" is not in the list defined for the TaxPostingIndicator column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TaxPostingIndicator.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setTaxPostingIndicator(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + TaxPostingIndicator.getUU());
			}
		} else {
			this.setTaxPostingIndicator(null);
		}
	}

	/**
	 * Get Posting Indicator.
	 *
	 * @return Type of input tax (deductible and non deductible)
	 */
	@JsonProperty("TaxPostingIndicator")
	public ForeignEntityInput TaxPostingIndicator() {
		return mTaxPostingIndicator;
	}

	/**
	 * Set To.
	 *
	 * @param To_Region Receiving Region
	 */
	@JsonProperty("To_Region")
	public void setTo_RegionInput(ForeignEntityInput To_Region) {
		this.mTo_Region = To_Region;
		if (To_Region != null) {
			// Since an entity was passed, make sure it's in the DB
			MRegion foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Region", "C_Region_UU=?", get_TrxName())
							.setParameters(To_Region.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setTo_Region_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Region with UU " + To_Region.getUU());
			}
		} else {
			this.setTo_Region_ID(0);
		}
	}

	/**
	 * Get To.
	 *
	 * @return Receiving Region
	 */
	@JsonProperty("To_Region")
	public ForeignEntityInput To_Region() {
		return mTo_Region;
	}
}
