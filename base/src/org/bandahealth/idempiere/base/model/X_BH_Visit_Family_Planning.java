/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for BH_Visit_Family_Planning
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="BH_Visit_Family_Planning")
public class X_BH_Visit_Family_Planning extends PO implements I_BH_Visit_Family_Planning, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260630L;

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning (Properties ctx, int BH_Visit_Family_Planning_ID, String trxName)
    {
      super (ctx, BH_Visit_Family_Planning_ID, trxName);
      /** if (BH_Visit_Family_Planning_ID == 0)
        {
			setBH_Contraceptive_Condoms (false);
// N
			setBH_Contraceptive_Emergency (false);
// N
			setBH_Contraceptive_Implants (false);
// N
			setBH_Contraceptive_Injectable (false);
// N
			setBH_Contraceptive_Iucd (false);
// N
			setBH_Contraceptive_Natural_Fp (false);
// N
			setBH_Contraceptive_Oral (false);
// N
			setBH_Contraceptive_Vsc (false);
// N
			setBH_Screening_Cervical (false);
// N
			setBH_Screening_Hiv (false);
// N
			setBH_Screening_Ipv (false);
// N
			setBH_Screening_Tb (false);
// N
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_ID (0);
			setBH_Vsc_Btl (false);
// N
			setBH_Vsc_Vasectomy (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning (Properties ctx, int BH_Visit_Family_Planning_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Visit_Family_Planning_ID, trxName, virtualColumns);
      /** if (BH_Visit_Family_Planning_ID == 0)
        {
			setBH_Contraceptive_Condoms (false);
// N
			setBH_Contraceptive_Emergency (false);
// N
			setBH_Contraceptive_Implants (false);
// N
			setBH_Contraceptive_Injectable (false);
// N
			setBH_Contraceptive_Iucd (false);
// N
			setBH_Contraceptive_Natural_Fp (false);
// N
			setBH_Contraceptive_Oral (false);
// N
			setBH_Contraceptive_Vsc (false);
// N
			setBH_Screening_Cervical (false);
// N
			setBH_Screening_Hiv (false);
// N
			setBH_Screening_Ipv (false);
// N
			setBH_Screening_Tb (false);
// N
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_ID (0);
			setBH_Vsc_Btl (false);
// N
			setBH_Vsc_Vasectomy (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning (Properties ctx, String BH_Visit_Family_Planning_UU, String trxName)
    {
      super (ctx, BH_Visit_Family_Planning_UU, trxName);
      /** if (BH_Visit_Family_Planning_UU == null)
        {
			setBH_Contraceptive_Condoms (false);
// N
			setBH_Contraceptive_Emergency (false);
// N
			setBH_Contraceptive_Implants (false);
// N
			setBH_Contraceptive_Injectable (false);
// N
			setBH_Contraceptive_Iucd (false);
// N
			setBH_Contraceptive_Natural_Fp (false);
// N
			setBH_Contraceptive_Oral (false);
// N
			setBH_Contraceptive_Vsc (false);
// N
			setBH_Screening_Cervical (false);
// N
			setBH_Screening_Hiv (false);
// N
			setBH_Screening_Ipv (false);
// N
			setBH_Screening_Tb (false);
// N
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_ID (0);
			setBH_Vsc_Btl (false);
// N
			setBH_Vsc_Vasectomy (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_BH_Visit_Family_Planning (Properties ctx, String BH_Visit_Family_Planning_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, BH_Visit_Family_Planning_UU, trxName, virtualColumns);
      /** if (BH_Visit_Family_Planning_UU == null)
        {
			setBH_Contraceptive_Condoms (false);
// N
			setBH_Contraceptive_Emergency (false);
// N
			setBH_Contraceptive_Implants (false);
// N
			setBH_Contraceptive_Injectable (false);
// N
			setBH_Contraceptive_Iucd (false);
// N
			setBH_Contraceptive_Natural_Fp (false);
// N
			setBH_Contraceptive_Oral (false);
// N
			setBH_Contraceptive_Vsc (false);
// N
			setBH_Screening_Cervical (false);
// N
			setBH_Screening_Hiv (false);
// N
			setBH_Screening_Ipv (false);
// N
			setBH_Screening_Tb (false);
// N
			setBH_Visit_Family_Planning_ID (0);
			setBH_Visit_ID (0);
			setBH_Vsc_Btl (false);
// N
			setBH_Vsc_Vasectomy (false);
// N
        } */
    }

    /** Load Constructor */
    public X_BH_Visit_Family_Planning (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_BH_Visit_Family_Planning[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** No = no */
	public static final String BH_CERVICAL_CANCER_SCREENING_No = "no";
	/** Yes = yes */
	public static final String BH_CERVICAL_CANCER_SCREENING_Yes = "yes";
	/** Set Cervical Cancer Screening.
		@param BH_Cervical_Cancer_Screening Cervical Cancer Screening
	*/
	public void setBH_Cervical_Cancer_Screening (String BH_Cervical_Cancer_Screening)
	{

		set_Value (COLUMNNAME_BH_Cervical_Cancer_Screening, BH_Cervical_Cancer_Screening);
	}

	/** Get Cervical Cancer Screening.
		@return Cervical Cancer Screening	  */
	public String getBH_Cervical_Cancer_Screening()
	{
		return (String)get_Value(COLUMNNAME_BH_Cervical_Cancer_Screening);
	}

	/** HPV = hpv */
	public static final String BH_CERVICAL_PAP_METHOD_HPV = "hpv";
	/** ND = nd */
	public static final String BH_CERVICAL_PAP_METHOD_ND = "nd";
	/** Normal = normal */
	public static final String BH_CERVICAL_PAP_METHOD_Normal = "normal";
	/** VIA = via */
	public static final String BH_CERVICAL_PAP_METHOD_VIA = "via";
	/** VILI = vili */
	public static final String BH_CERVICAL_PAP_METHOD_VILI = "vili";
	/** Set Cervical PAP Method.
		@param BH_Cervical_Pap_Method Cervical PAP Method
	*/
	public void setBH_Cervical_Pap_Method (String BH_Cervical_Pap_Method)
	{

		set_Value (COLUMNNAME_BH_Cervical_Pap_Method, BH_Cervical_Pap_Method);
	}

	/** Get Cervical PAP Method.
		@return Cervical PAP Method	  */
	public String getBH_Cervical_Pap_Method()
	{
		return (String)get_Value(COLUMNNAME_BH_Cervical_Pap_Method);
	}

	/** Confirmed = confirmed */
	public static final String BH_CERVICAL_RESULTS_Confirmed = "confirmed";
	/** Not done = notDone */
	public static final String BH_CERVICAL_RESULTS_NotDone = "notDone";
	/** Suspected = suspected */
	public static final String BH_CERVICAL_RESULTS_Suspected = "suspected";
	/** Set Cervical Results.
		@param BH_Cervical_Results Cervical Results
	*/
	public void setBH_Cervical_Results (String BH_Cervical_Results)
	{

		set_Value (COLUMNNAME_BH_Cervical_Results, BH_Cervical_Results);
	}

	/** Get Cervical Results.
		@return Cervical Results	  */
	public String getBH_Cervical_Results()
	{
		return (String)get_Value(COLUMNNAME_BH_Cervical_Results);
	}

	/** Set Condoms for FP.
		@param BH_Contraceptive_Condoms Condoms for FP
	*/
	public void setBH_Contraceptive_Condoms (boolean BH_Contraceptive_Condoms)
	{
		set_Value (COLUMNNAME_BH_Contraceptive_Condoms, Boolean.valueOf(BH_Contraceptive_Condoms));
	}

	/** Get Condoms for FP.
		@return Condoms for FP	  */
	public boolean isBH_Contraceptive_Condoms()
	{
		Object oo = get_Value(COLUMNNAME_BH_Contraceptive_Condoms);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Emergency Contraception.
		@param BH_Contraceptive_Emergency Emergency Contraception
	*/
	public void setBH_Contraceptive_Emergency (boolean BH_Contraceptive_Emergency)
	{
		set_Value (COLUMNNAME_BH_Contraceptive_Emergency, Boolean.valueOf(BH_Contraceptive_Emergency));
	}

	/** Get Emergency Contraception.
		@return Emergency Contraception	  */
	public boolean isBH_Contraceptive_Emergency()
	{
		Object oo = get_Value(COLUMNNAME_BH_Contraceptive_Emergency);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Implants.
		@param BH_Contraceptive_Implants Implants
	*/
	public void setBH_Contraceptive_Implants (boolean BH_Contraceptive_Implants)
	{
		set_Value (COLUMNNAME_BH_Contraceptive_Implants, Boolean.valueOf(BH_Contraceptive_Implants));
	}

	/** Get Implants.
		@return Implants	  */
	public boolean isBH_Contraceptive_Implants()
	{
		Object oo = get_Value(COLUMNNAME_BH_Contraceptive_Implants);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Injectable.
		@param BH_Contraceptive_Injectable Injectable
	*/
	public void setBH_Contraceptive_Injectable (boolean BH_Contraceptive_Injectable)
	{
		set_Value (COLUMNNAME_BH_Contraceptive_Injectable, Boolean.valueOf(BH_Contraceptive_Injectable));
	}

	/** Get Injectable.
		@return Injectable	  */
	public boolean isBH_Contraceptive_Injectable()
	{
		Object oo = get_Value(COLUMNNAME_BH_Contraceptive_Injectable);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IUCD.
		@param BH_Contraceptive_Iucd IUCD
	*/
	public void setBH_Contraceptive_Iucd (boolean BH_Contraceptive_Iucd)
	{
		set_Value (COLUMNNAME_BH_Contraceptive_Iucd, Boolean.valueOf(BH_Contraceptive_Iucd));
	}

	/** Get IUCD.
		@return IUCD	  */
	public boolean isBH_Contraceptive_Iucd()
	{
		Object oo = get_Value(COLUMNNAME_BH_Contraceptive_Iucd);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Natural FP Methods.
		@param BH_Contraceptive_Natural_Fp Natural FP Methods
	*/
	public void setBH_Contraceptive_Natural_Fp (boolean BH_Contraceptive_Natural_Fp)
	{
		set_Value (COLUMNNAME_BH_Contraceptive_Natural_Fp, Boolean.valueOf(BH_Contraceptive_Natural_Fp));
	}

	/** Get Natural FP Methods.
		@return Natural FP Methods	  */
	public boolean isBH_Contraceptive_Natural_Fp()
	{
		Object oo = get_Value(COLUMNNAME_BH_Contraceptive_Natural_Fp);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Oral Contraceptive.
		@param BH_Contraceptive_Oral Oral Contraceptive
	*/
	public void setBH_Contraceptive_Oral (boolean BH_Contraceptive_Oral)
	{
		set_Value (COLUMNNAME_BH_Contraceptive_Oral, Boolean.valueOf(BH_Contraceptive_Oral));
	}

	/** Get Oral Contraceptive.
		@return Oral Contraceptive	  */
	public boolean isBH_Contraceptive_Oral()
	{
		Object oo = get_Value(COLUMNNAME_BH_Contraceptive_Oral);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Voluntary Surgical Contraception.
		@param BH_Contraceptive_Vsc Voluntary Surgical Contraception
	*/
	public void setBH_Contraceptive_Vsc (boolean BH_Contraceptive_Vsc)
	{
		set_Value (COLUMNNAME_BH_Contraceptive_Vsc, Boolean.valueOf(BH_Contraceptive_Vsc));
	}

	/** Get Voluntary Surgical Contraception.
		@return Voluntary Surgical Contraception	  */
	public boolean isBH_Contraceptive_Vsc()
	{
		Object oo = get_Value(COLUMNNAME_BH_Contraceptive_Vsc);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** No = no */
	public static final String BH_CYCLE_BEADS_GIVEN_No = "no";
	/** Yes = yes */
	public static final String BH_CYCLE_BEADS_GIVEN_Yes = "yes";
	/** Set Cycle Beads Given.
		@param BH_Cycle_Beads_Given Cycle Beads Given
	*/
	public void setBH_Cycle_Beads_Given (String BH_Cycle_Beads_Given)
	{

		set_Value (COLUMNNAME_BH_Cycle_Beads_Given, BH_Cycle_Beads_Given);
	}

	/** Get Cycle Beads Given.
		@return Cycle Beads Given	  */
	public String getBH_Cycle_Beads_Given()
	{
		return (String)get_Value(COLUMNNAME_BH_Cycle_Beads_Given);
	}

	/** No = no */
	public static final String BH_EMERGENCY_CONTRACEPTION_GIVEN_No = "no";
	/** Yes = yes */
	public static final String BH_EMERGENCY_CONTRACEPTION_GIVEN_Yes = "yes";
	/** Set Emergency Contraception Given.
		@param BH_Emergency_Contraception_Given Emergency Contraception Given
	*/
	public void setBH_Emergency_Contraception_Given (String BH_Emergency_Contraception_Given)
	{

		set_Value (COLUMNNAME_BH_Emergency_Contraception_Given, BH_Emergency_Contraception_Given);
	}

	/** Get Emergency Contraception Given.
		@return Emergency Contraception Given	  */
	public String getBH_Emergency_Contraception_Given()
	{
		return (String)get_Value(COLUMNNAME_BH_Emergency_Contraception_Given);
	}

	/** Set Emergency Contraception Notes.
		@param BH_Emergency_Contraception_Notes Emergency Contraception Notes
	*/
	public void setBH_Emergency_Contraception_Notes (String BH_Emergency_Contraception_Notes)
	{
		set_Value (COLUMNNAME_BH_Emergency_Contraception_Notes, BH_Emergency_Contraception_Notes);
	}

	/** Get Emergency Contraception Notes.
		@return Emergency Contraception Notes	  */
	public String getBH_Emergency_Contraception_Notes()
	{
		return (String)get_Value(COLUMNNAME_BH_Emergency_Contraception_Notes);
	}

	/** No = no */
	public static final String BH_FIRST_EVER_CONTRACEPTIVE_USER_No = "no";
	/** Yes = yes */
	public static final String BH_FIRST_EVER_CONTRACEPTIVE_USER_Yes = "yes";
	/** Set First Ever Contraceptive User.
		@param BH_First_Ever_Contraceptive_User First Ever Contraceptive User
	*/
	public void setBH_First_Ever_Contraceptive_User (String BH_First_Ever_Contraceptive_User)
	{

		set_Value (COLUMNNAME_BH_First_Ever_Contraceptive_User, BH_First_Ever_Contraceptive_User);
	}

	/** Get First Ever Contraceptive User.
		@return First Ever Contraceptive User	  */
	public String getBH_First_Ever_Contraceptive_User()
	{
		return (String)get_Value(COLUMNNAME_BH_First_Ever_Contraceptive_User);
	}

	/** New to facility = newToFacility */
	public static final String BH_FIRST_VISIT_FP_AT_CLINIC_NewToFacility = "newToFacility";
	/** Revisit = revisit */
	public static final String BH_FIRST_VISIT_FP_AT_CLINIC_Revisit = "revisit";
	/** Set First Visit FP at Clinic.
		@param BH_First_Visit_Fp_At_Clinic First Visit FP at Clinic
	*/
	public void setBH_First_Visit_Fp_At_Clinic (String BH_First_Visit_Fp_At_Clinic)
	{

		set_Value (COLUMNNAME_BH_First_Visit_Fp_At_Clinic, BH_First_Visit_Fp_At_Clinic);
	}

	/** Get First Visit FP at Clinic.
		@return First Visit FP at Clinic	  */
	public String getBH_First_Visit_Fp_At_Clinic()
	{
		return (String)get_Value(COLUMNNAME_BH_First_Visit_Fp_At_Clinic);
	}

	/** Not offered = notOffered */
	public static final String BH_HIV_COUNSELED_TESTED_NotOffered = "notOffered";
	/** Refused = refused */
	public static final String BH_HIV_COUNSELED_TESTED_Refused = "refused";
	/** Yes = yes */
	public static final String BH_HIV_COUNSELED_TESTED_Yes = "yes";
	/** Set HIV Counseled/Tested.
		@param BH_Hiv_Counseled_Tested HIV Counseled/Tested
	*/
	public void setBH_Hiv_Counseled_Tested (String BH_Hiv_Counseled_Tested)
	{

		set_Value (COLUMNNAME_BH_Hiv_Counseled_Tested, BH_Hiv_Counseled_Tested);
	}

	/** Get HIV Counseled/Tested.
		@return HIV Counseled/Tested	  */
	public String getBH_Hiv_Counseled_Tested()
	{
		return (String)get_Value(COLUMNNAME_BH_Hiv_Counseled_Tested);
	}

	/** Known positive = knownPositive */
	public static final String BH_HIV_RESULTS_KnownPositive = "knownPositive";
	/** Negative today = negativeToday */
	public static final String BH_HIV_RESULTS_NegativeToday = "negativeToday";
	/** Positive today = positiveToday */
	public static final String BH_HIV_RESULTS_PositiveToday = "positiveToday";
	/** Unknown = unknown */
	public static final String BH_HIV_RESULTS_Unknown = "unknown";
	/** Set HIV Results.
		@param BH_Hiv_Results HIV Results
	*/
	public void setBH_Hiv_Results (String BH_Hiv_Results)
	{

		set_Value (COLUMNNAME_BH_Hiv_Results, BH_Hiv_Results);
	}

	/** Get HIV Results.
		@return HIV Results	  */
	public String getBH_Hiv_Results()
	{
		return (String)get_Value(COLUMNNAME_BH_Hiv_Results);
	}

	/** Check up = checkUp */
	public static final String BH_IMPLANTS_TYPE_OF_VISIT_CheckUp = "checkUp";
	/** First insertion = firstInsertion */
	public static final String BH_IMPLANTS_TYPE_OF_VISIT_FirstInsertion = "firstInsertion";
	/** Reinsertion = reinsertion */
	public static final String BH_IMPLANTS_TYPE_OF_VISIT_Reinsertion = "reinsertion";
	/** Removal = removal */
	public static final String BH_IMPLANTS_TYPE_OF_VISIT_Removal = "removal";
	/** Set Implants Type of Visit.
		@param BH_Implants_Type_Of_Visit Implants Type of Visit
	*/
	public void setBH_Implants_Type_Of_Visit (String BH_Implants_Type_Of_Visit)
	{

		set_Value (COLUMNNAME_BH_Implants_Type_Of_Visit, BH_Implants_Type_Of_Visit);
	}

	/** Get Implants Type of Visit.
		@return Implants Type of Visit	  */
	public String getBH_Implants_Type_Of_Visit()
	{
		return (String)get_Value(COLUMNNAME_BH_Implants_Type_Of_Visit);
	}

	/** IM = im */
	public static final String BH_INJECTABLE_ROUTE_IM = "im";
	/** SC = sc */
	public static final String BH_INJECTABLE_ROUTE_SC = "sc";
	/** Set Injectable Route.
		@param BH_Injectable_Route Injectable Route
	*/
	public void setBH_Injectable_Route (String BH_Injectable_Route)
	{

		set_Value (COLUMNNAME_BH_Injectable_Route, BH_Injectable_Route);
	}

	/** Get Injectable Route.
		@return Injectable Route	  */
	public String getBH_Injectable_Route()
	{
		return (String)get_Value(COLUMNNAME_BH_Injectable_Route);
	}

	/** New = new */
	public static final String BH_INJECTABLE_TYPE_OF_VISIT_New = "new";
	/** Revisit = revisit */
	public static final String BH_INJECTABLE_TYPE_OF_VISIT_Revisit = "revisit";
	/** Set Injectable Type of Visit.
		@param BH_Injectable_Type_Of_Visit Injectable Type of Visit
	*/
	public void setBH_Injectable_Type_Of_Visit (String BH_Injectable_Type_Of_Visit)
	{

		set_Value (COLUMNNAME_BH_Injectable_Type_Of_Visit, BH_Injectable_Type_Of_Visit);
	}

	/** Get Injectable Type of Visit.
		@return Injectable Type of Visit	  */
	public String getBH_Injectable_Type_Of_Visit()
	{
		return (String)get_Value(COLUMNNAME_BH_Injectable_Type_Of_Visit);
	}

	/** Experience of intimate partner violence = ipv */
	public static final String BH_IPV_REPRODUCTIVE_COERCION_ExperienceOfIntimatePartnerViolence = "ipv";
	/** No gender-based violence = noGbv */
	public static final String BH_IPV_REPRODUCTIVE_COERCION_NoGender_BasedViolence = "noGbv";
	/** Not asked = notAsked */
	public static final String BH_IPV_REPRODUCTIVE_COERCION_NotAsked = "notAsked";
	/** Reproductive coercion = reproductiveCoercion */
	public static final String BH_IPV_REPRODUCTIVE_COERCION_ReproductiveCoercion = "reproductiveCoercion";
	/** Set IPV/Reproductive Coercion.
		@param BH_Ipv_Reproductive_Coercion IPV/Reproductive Coercion
	*/
	public void setBH_Ipv_Reproductive_Coercion (String BH_Ipv_Reproductive_Coercion)
	{

		set_Value (COLUMNNAME_BH_Ipv_Reproductive_Coercion, BH_Ipv_Reproductive_Coercion);
	}

	/** Get IPV/Reproductive Coercion.
		@return IPV/Reproductive Coercion	  */
	public String getBH_Ipv_Reproductive_Coercion()
	{
		return (String)get_Value(COLUMNNAME_BH_Ipv_Reproductive_Coercion);
	}

	/** Check up = checkUp */
	public static final String BH_IUCD_TYPE_OF_VISIT_CheckUp = "checkUp";
	/** First insertion = firstInsertion */
	public static final String BH_IUCD_TYPE_OF_VISIT_FirstInsertion = "firstInsertion";
	/** Reinsertion = reinsertion */
	public static final String BH_IUCD_TYPE_OF_VISIT_Reinsertion = "reinsertion";
	/** Removal = removal */
	public static final String BH_IUCD_TYPE_OF_VISIT_Removal = "removal";
	/** Set IUCD Type of Visit.
		@param BH_Iucd_Type_Of_Visit IUCD Type of Visit
	*/
	public void setBH_Iucd_Type_Of_Visit (String BH_Iucd_Type_Of_Visit)
	{

		set_Value (COLUMNNAME_BH_Iucd_Type_Of_Visit, BH_Iucd_Type_Of_Visit);
	}

	/** Get IUCD Type of Visit.
		@return IUCD Type of Visit	  */
	public String getBH_Iucd_Type_Of_Visit()
	{
		return (String)get_Value(COLUMNNAME_BH_Iucd_Type_Of_Visit);
	}

	/** No = no */
	public static final String BH_NATURAL_FP_COUNSELED_No = "no";
	/** Yes = yes */
	public static final String BH_NATURAL_FP_COUNSELED_Yes = "yes";
	/** Set Natural FP Counseled.
		@param BH_Natural_Fp_Counseled Natural FP Counseled
	*/
	public void setBH_Natural_Fp_Counseled (String BH_Natural_Fp_Counseled)
	{

		set_Value (COLUMNNAME_BH_Natural_Fp_Counseled, BH_Natural_Fp_Counseled);
	}

	/** Get Natural FP Counseled.
		@return Natural FP Counseled	  */
	public String getBH_Natural_Fp_Counseled()
	{
		return (String)get_Value(COLUMNNAME_BH_Natural_Fp_Counseled);
	}

	/** New = new */
	public static final String BH_ORAL_TYPE_OF_VISIT_New = "new";
	/** Revisit = revisit */
	public static final String BH_ORAL_TYPE_OF_VISIT_Revisit = "revisit";
	/** Set Oral Type of Visit.
		@param BH_Oral_Type_Of_Visit Oral Type of Visit
	*/
	public void setBH_Oral_Type_Of_Visit (String BH_Oral_Type_Of_Visit)
	{

		set_Value (COLUMNNAME_BH_Oral_Type_Of_Visit, BH_Oral_Type_Of_Visit);
	}

	/** Get Oral Type of Visit.
		@return Oral Type of Visit	  */
	public String getBH_Oral_Type_Of_Visit()
	{
		return (String)get_Value(COLUMNNAME_BH_Oral_Type_Of_Visit);
	}

	/** 4-6 weeks = fourToSixWeeks */
	public static final String BH_POSTPARTUM_FP_4_6Weeks = "fourToSixWeeks";
	/** None = none */
	public static final String BH_POSTPARTUM_FP_None = "none";
	/** Post abortion = postAbortion */
	public static final String BH_POSTPARTUM_FP_PostAbortion = "postAbortion";
	/** Within 48h = within48h */
	public static final String BH_POSTPARTUM_FP_Within48h = "within48h";
	/** Set Postpartum FP.
		@param BH_Postpartum_Fp Postpartum FP
	*/
	public void setBH_Postpartum_Fp (String BH_Postpartum_Fp)
	{

		set_Value (COLUMNNAME_BH_Postpartum_Fp, BH_Postpartum_Fp);
	}

	/** Get Postpartum FP.
		@return Postpartum FP	  */
	public String getBH_Postpartum_Fp()
	{
		return (String)get_Value(COLUMNNAME_BH_Postpartum_Fp);
	}

	/** Another facility = anotherFacility */
	public static final String BH_REFERRAL_COMMUNITY_FROM_AnotherFacility = "anotherFacility";
	/** Not applicable = notApplicable */
	public static final String BH_REFERRAL_COMMUNITY_FROM_NotApplicable = "notApplicable";
	/** Set Referral Community From.
		@param BH_Referral_Community_From Referral Community From
	*/
	public void setBH_Referral_Community_From (String BH_Referral_Community_From)
	{

		set_Value (COLUMNNAME_BH_Referral_Community_From, BH_Referral_Community_From);
	}

	/** Get Referral Community From.
		@return Referral Community From	  */
	public String getBH_Referral_Community_From()
	{
		return (String)get_Value(COLUMNNAME_BH_Referral_Community_From);
	}

	/** Another facility = anotherFacility */
	public static final String BH_REFERRAL_COMMUNITY_TO_AnotherFacility = "anotherFacility";
	/** Not applicable = notApplicable */
	public static final String BH_REFERRAL_COMMUNITY_TO_NotApplicable = "notApplicable";
	/** Set Referral Community To.
		@param BH_Referral_Community_To Referral Community To
	*/
	public void setBH_Referral_Community_To (String BH_Referral_Community_To)
	{

		set_Value (COLUMNNAME_BH_Referral_Community_To, BH_Referral_Community_To);
	}

	/** Get Referral Community To.
		@return Referral Community To	  */
	public String getBH_Referral_Community_To()
	{
		return (String)get_Value(COLUMNNAME_BH_Referral_Community_To);
	}

	/** No = no */
	public static final String BH_REFERRALS_No = "no";
	/** Yes = yes */
	public static final String BH_REFERRALS_Yes = "yes";
	/** Set Referrals.
		@param BH_Referrals Referrals
	*/
	public void setBH_Referrals (String BH_Referrals)
	{

		set_Value (COLUMNNAME_BH_Referrals, BH_Referrals);
	}

	/** Get Referrals.
		@return Referrals	  */
	public String getBH_Referrals()
	{
		return (String)get_Value(COLUMNNAME_BH_Referrals);
	}

	/** Set Referrals Reason.
		@param BH_Referrals_Reason Referrals Reason
	*/
	public void setBH_Referrals_Reason (String BH_Referrals_Reason)
	{
		set_Value (COLUMNNAME_BH_Referrals_Reason, BH_Referrals_Reason);
	}

	/** Get Referrals Reason.
		@return Referrals Reason	  */
	public String getBH_Referrals_Reason()
	{
		return (String)get_Value(COLUMNNAME_BH_Referrals_Reason);
	}

	/** Set Remarks.
		@param BH_Remarks Remarks
	*/
	public void setBH_Remarks (String BH_Remarks)
	{
		set_Value (COLUMNNAME_BH_Remarks, BH_Remarks);
	}

	/** Get Remarks.
		@return Remarks	  */
	public String getBH_Remarks()
	{
		return (String)get_Value(COLUMNNAME_BH_Remarks);
	}

	/** Set Cervical Screening at Visit.
		@param BH_Screening_Cervical Cervical Screening at Visit
	*/
	public void setBH_Screening_Cervical (boolean BH_Screening_Cervical)
	{
		set_Value (COLUMNNAME_BH_Screening_Cervical, Boolean.valueOf(BH_Screening_Cervical));
	}

	/** Get Cervical Screening at Visit.
		@return Cervical Screening at Visit	  */
	public boolean isBH_Screening_Cervical()
	{
		Object oo = get_Value(COLUMNNAME_BH_Screening_Cervical);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set HIV Screening at Visit.
		@param BH_Screening_Hiv HIV Screening at Visit
	*/
	public void setBH_Screening_Hiv (boolean BH_Screening_Hiv)
	{
		set_Value (COLUMNNAME_BH_Screening_Hiv, Boolean.valueOf(BH_Screening_Hiv));
	}

	/** Get HIV Screening at Visit.
		@return HIV Screening at Visit	  */
	public boolean isBH_Screening_Hiv()
	{
		Object oo = get_Value(COLUMNNAME_BH_Screening_Hiv);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IPV Screening at Visit.
		@param BH_Screening_Ipv IPV Screening at Visit
	*/
	public void setBH_Screening_Ipv (boolean BH_Screening_Ipv)
	{
		set_Value (COLUMNNAME_BH_Screening_Ipv, Boolean.valueOf(BH_Screening_Ipv));
	}

	/** Get IPV Screening at Visit.
		@return IPV Screening at Visit	  */
	public boolean isBH_Screening_Ipv()
	{
		Object oo = get_Value(COLUMNNAME_BH_Screening_Ipv);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set TB Screening at Visit.
		@param BH_Screening_Tb TB Screening at Visit
	*/
	public void setBH_Screening_Tb (boolean BH_Screening_Tb)
	{
		set_Value (COLUMNNAME_BH_Screening_Tb, Boolean.valueOf(BH_Screening_Tb));
	}

	/** Get TB Screening at Visit.
		@return TB Screening at Visit	  */
	public boolean isBH_Screening_Tb()
	{
		Object oo = get_Value(COLUMNNAME_BH_Screening_Tb);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** No signs = noSigns */
	public static final String BH_TB_SCREENING_NoSigns = "noSigns";
	/** Not done = notDone */
	public static final String BH_TB_SCREENING_NotDone = "notDone";
	/** On treatment = onTreatment */
	public static final String BH_TB_SCREENING_OnTreatment = "onTreatment";
	/** Presumed TB = presumedTb */
	public static final String BH_TB_SCREENING_PresumedTB = "presumedTb";
	/** Set TB Screening.
		@param BH_Tb_Screening TB Screening
	*/
	public void setBH_Tb_Screening (String BH_Tb_Screening)
	{

		set_Value (COLUMNNAME_BH_Tb_Screening, BH_Tb_Screening);
	}

	/** Get TB Screening.
		@return TB Screening	  */
	public String getBH_Tb_Screening()
	{
		return (String)get_Value(COLUMNNAME_BH_Tb_Screening);
	}

	/** Set Visit Family Planning.
		@param BH_Visit_Family_Planning_ID Visit Family Planning
	*/
	public void setBH_Visit_Family_Planning_ID (int BH_Visit_Family_Planning_ID)
	{
		if (BH_Visit_Family_Planning_ID < 1)
			set_ValueNoCheck (COLUMNNAME_BH_Visit_Family_Planning_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_BH_Visit_Family_Planning_ID, Integer.valueOf(BH_Visit_Family_Planning_ID));
	}

	/** Get Visit Family Planning.
		@return Visit Family Planning	  */
	public int getBH_Visit_Family_Planning_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Visit_Family_Planning_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BH_Visit_Family_Planning_UU.
		@param BH_Visit_Family_Planning_UU BH_Visit_Family_Planning_UU
	*/
	public void setBH_Visit_Family_Planning_UU (String BH_Visit_Family_Planning_UU)
	{
		set_Value (COLUMNNAME_BH_Visit_Family_Planning_UU, BH_Visit_Family_Planning_UU);
	}

	/** Get BH_Visit_Family_Planning_UU.
		@return BH_Visit_Family_Planning_UU	  */
	public String getBH_Visit_Family_Planning_UU()
	{
		return (String)get_Value(COLUMNNAME_BH_Visit_Family_Planning_UU);
	}

	public I_BH_Visit getBH_Visit() throws RuntimeException
	{
		return (I_BH_Visit)MTable.get(getCtx(), I_BH_Visit.Table_ID)
			.getPO(getBH_Visit_ID(), get_TrxName());
	}

	/** Set Visit.
		@param BH_Visit_ID Visit
	*/
	public void setBH_Visit_ID (int BH_Visit_ID)
	{
		if (BH_Visit_ID < 1)
			set_Value (COLUMNNAME_BH_Visit_ID, null);
		else
			set_Value (COLUMNNAME_BH_Visit_ID, Integer.valueOf(BH_Visit_ID));
	}

	/** Get Visit.
		@return Visit	  */
	public int getBH_Visit_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Visit_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set VSC BTL.
		@param BH_Vsc_Btl VSC BTL
	*/
	public void setBH_Vsc_Btl (boolean BH_Vsc_Btl)
	{
		set_Value (COLUMNNAME_BH_Vsc_Btl, Boolean.valueOf(BH_Vsc_Btl));
	}

	/** Get VSC BTL.
		@return VSC BTL	  */
	public boolean isBH_Vsc_Btl()
	{
		Object oo = get_Value(COLUMNNAME_BH_Vsc_Btl);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** No = no */
	public static final String BH_VSC_GIVEN_No = "no";
	/** Yes = yes */
	public static final String BH_VSC_GIVEN_Yes = "yes";
	/** Set VSC Given.
		@param BH_Vsc_Given VSC Given
	*/
	public void setBH_Vsc_Given (String BH_Vsc_Given)
	{

		set_Value (COLUMNNAME_BH_Vsc_Given, BH_Vsc_Given);
	}

	/** Get VSC Given.
		@return VSC Given	  */
	public String getBH_Vsc_Given()
	{
		return (String)get_Value(COLUMNNAME_BH_Vsc_Given);
	}

	/** Set VSC Vasectomy.
		@param BH_Vsc_Vasectomy VSC Vasectomy
	*/
	public void setBH_Vsc_Vasectomy (boolean BH_Vsc_Vasectomy)
	{
		set_Value (COLUMNNAME_BH_Vsc_Vasectomy, Boolean.valueOf(BH_Vsc_Vasectomy));
	}

	/** Get VSC Vasectomy.
		@return VSC Vasectomy	  */
	public boolean isBH_Vsc_Vasectomy()
	{
		Object oo = get_Value(COLUMNNAME_BH_Vsc_Vasectomy);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}
}