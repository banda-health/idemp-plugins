-- GO-3634: Rename NHIF payer info field labels to SHA and remove unused NHIF metadata.
-- Chart-of-accounts payroll accounts and Personnel expense charge align with import CSVs / ExpenseList.
-- NHIF cashier report processes were deleted in GO-2722; this migration removes orphaned dictionary rows.

/**********************************************************************************************************************/
-- Payer info fields (user-facing label only) — SHA insurer only (GO-3120 created Social Health Authority)
/**********************************************************************************************************************/
UPDATE
	bh_payer_info_fld pif
SET
	name = 'SHA Number'
FROM
	c_bpartner bp
WHERE
	pif.bh_payer_id = bp.c_bpartner_id
	AND bp.name = 'Social Health Authority'
	AND pif.name = 'NHIF Number';

/**********************************************************************************************************************/
-- Remove NHIF tender type list entries (do not rename)
/**********************************************************************************************************************/
DELETE
FROM
	ad_ref_list_trl
WHERE
	ad_ref_list_id IN (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu IN ('28617687-cb93-494a-8f03-bc453da32658', '3d12c6d9-92f9-495f-b2f0-d35baedc614e')
	);

DELETE
FROM
	ad_ref_list
WHERE
	ad_ref_list_uu IN ('28617687-cb93-494a-8f03-bc453da32658', '3d12c6d9-92f9-495f-b2f0-d35baedc614e');

/**********************************************************************************************************************/
-- Remove NHIF-specific reference lists (relationship and type), not rename
/**********************************************************************************************************************/
DELETE
FROM
	ad_ref_list_trl
WHERE
		ad_ref_list_id IN (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
				ad_reference_id IN (
				SELECT
					ad_reference_id
				FROM
					ad_reference
				WHERE
					ad_reference_uu IN ('3b5a9677-584f-468d-ab4b-f55647cd7cfa', 'f0b910fa-cb95-46b3-8542-89b594c4c2b4')
			)
	);

DELETE
FROM
	ad_ref_list
WHERE
		ad_reference_id IN (
		SELECT
			ad_reference_id
		FROM
			ad_reference
		WHERE
			ad_reference_uu IN ('3b5a9677-584f-468d-ab4b-f55647cd7cfa', 'f0b910fa-cb95-46b3-8542-89b594c4c2b4')
	);

UPDATE
	ad_column
SET
	ad_reference_value_id = NULL
WHERE
	ad_reference_value_id IN (
		SELECT
			ad_reference_id
		FROM
			ad_reference
		WHERE
			ad_reference_uu IN ('3b5a9677-584f-468d-ab4b-f55647cd7cfa', 'f0b910fa-cb95-46b3-8542-89b594c4c2b4')
	);

DELETE
FROM
	ad_reference_trl
WHERE
		ad_reference_id IN (
		SELECT
			ad_reference_id
		FROM
			ad_reference
		WHERE
			ad_reference_uu IN ('3b5a9677-584f-468d-ab4b-f55647cd7cfa', 'f0b910fa-cb95-46b3-8542-89b594c4c2b4')
	);

DELETE
FROM
	ad_reference
WHERE
	ad_reference_uu IN ('3b5a9677-584f-468d-ab4b-f55647cd7cfa', 'f0b910fa-cb95-46b3-8542-89b594c4c2b4');

/**********************************************************************************************************************/
-- Chart of accounts and payroll expense charge (align with import CSVs and ExpenseList report)
/**********************************************************************************************************************/
UPDATE c_elementvalue
SET
	name = 'SHA Paid'
WHERE
	name = 'NHIF Paid';

UPDATE c_elementvalue
SET
	name = 'SHA Payable'
WHERE
	name = 'NHIF Payable';

UPDATE c_validcombination
SET
	description = REPLACE(description, 'NHIF Paid', 'SHA Paid'),
	combination = REPLACE(combination, 'NHIF Paid', 'SHA Paid')
WHERE
	description LIKE '%NHIF Paid%' OR combination LIKE '%NHIF Paid%';

UPDATE c_charge
SET
	name = 'Personnel - SHA',
	description = 'SHA payroll'
WHERE
	name = 'Personnel - NHIF';

/**********************************************************************************************************************/
-- Remove orphaned NHIF cashier report dictionary (processes deleted in GO-2722; buttons in GO-2532)
/**********************************************************************************************************************/
DELETE
FROM
	ad_element_trl
WHERE
	ad_element_id IN (
		SELECT ad_element_id FROM ad_element
		WHERE ad_element_uu IN ('39664999-42ff-48f5-97ae-03159fabff9e', '8f3723e5-7cd6-4c97-bd59-06fd9da287e9')
	);

DELETE
FROM
	ad_element
WHERE
	ad_element_uu IN ('39664999-42ff-48f5-97ae-03159fabff9e', '8f3723e5-7cd6-4c97-bd59-06fd9da287e9');

DELETE
FROM
	bh_tabnavbtn_tab_trl
WHERE
	bh_tabnavbtn_tab_id IN (
		SELECT bh_tabnavbtn_tab_id FROM bh_tabnavbtn_tab
		WHERE bh_tabnavbtn_id IN (
			SELECT bh_tabnavbtn_id FROM bh_tabnavbtn
			WHERE bh_tabnavbtn_uu IN ('81089221-596a-4ce2-a2ea-19c9a92d6837', '127fb899-61a7-4e55-a421-a5032f5998ce')
		)
	);

DELETE
FROM
	bh_tabnavbtn_tab
WHERE
	bh_tabnavbtn_id IN (
		SELECT bh_tabnavbtn_id FROM bh_tabnavbtn
		WHERE bh_tabnavbtn_uu IN ('81089221-596a-4ce2-a2ea-19c9a92d6837', '127fb899-61a7-4e55-a421-a5032f5998ce')
	);

DELETE
FROM
	bh_tabnavbtn_trl
WHERE
	bh_tabnavbtn_id IN (
		SELECT bh_tabnavbtn_id FROM bh_tabnavbtn
		WHERE bh_tabnavbtn_uu IN ('81089221-596a-4ce2-a2ea-19c9a92d6837', '127fb899-61a7-4e55-a421-a5032f5998ce')
	);

DELETE
FROM
	bh_tabnavbtn
WHERE
	bh_tabnavbtn_uu IN ('81089221-596a-4ce2-a2ea-19c9a92d6837', '127fb899-61a7-4e55-a421-a5032f5998ce');

/**********************************************************************************************************************/
-- Drop unused NHIF columns from c_payment (GO-1335 removed most; NHIF_Number remained)
/**********************************************************************************************************************/
ALTER TABLE c_payment
	DROP COLUMN IF EXISTS nhif_number;

ALTER TABLE c_payment
	DROP COLUMN IF EXISTS bh_nhif_claim_number;

ALTER TABLE c_payment
	DROP COLUMN IF EXISTS bh_nhif_member_id;

ALTER TABLE c_payment
	DROP COLUMN IF EXISTS bh_nhif_member_name;

ALTER TABLE c_payment
	DROP COLUMN IF EXISTS bh_nhif_relationship;

ALTER TABLE c_payment
	DROP COLUMN IF EXISTS bh_nhif_valid;

ALTER TABLE c_payment
	DROP COLUMN IF EXISTS bh_nhif_linda_mama;

ALTER TABLE c_payment
	DROP COLUMN IF EXISTS bh_nhif_type;

DELETE
FROM
	ad_field_trl
WHERE
		ad_field_id IN (
		SELECT
			ad_field_id
		FROM
			ad_field
		WHERE
				ad_column_id IN (
				SELECT
					ad_column_id
				FROM
					ad_column
				WHERE
						LOWER(columnname) IN ('nhif_number', 'bh_nhif_claim_number', 'bh_nhif_member_id',
						                       'bh_nhif_member_name', 'bh_nhif_relationship', 'bh_nhif_valid',
						                       'bh_nhif_linda_mama', 'bh_nhif_type')
					AND ad_table_id = (
						SELECT ad_table_id FROM ad_table WHERE tablename = 'C_Payment'
					)
			)
	);

DELETE
FROM
	ad_field
WHERE
		ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
				LOWER(columnname) IN ('nhif_number', 'bh_nhif_claim_number', 'bh_nhif_member_id', 'bh_nhif_member_name',
				                      'bh_nhif_relationship', 'bh_nhif_valid', 'bh_nhif_linda_mama', 'bh_nhif_type')
			AND ad_table_id = (
				SELECT ad_table_id FROM ad_table WHERE tablename = 'C_Payment'
			)
	);

DELETE
FROM
	ad_column
WHERE
		LOWER(columnname) IN ('nhif_number', 'bh_nhif_claim_number', 'bh_nhif_member_id', 'bh_nhif_member_name',
		                      'bh_nhif_relationship', 'bh_nhif_valid', 'bh_nhif_linda_mama', 'bh_nhif_type')
	AND ad_table_id = (
		SELECT ad_table_id FROM ad_table WHERE tablename = 'C_Payment'
	);

SELECT
	update_sequences();

SELECT
	register_migration_script('202606251529_GO-3634.sql')
FROM
	dual;
