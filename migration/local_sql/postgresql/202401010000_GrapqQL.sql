-- Make casing correct on this column for code-generation purposes
UPDATE ad_column
SET
	columnname = 'BH_Voided_Reason_UU'
WHERE
	ad_column_uu = '376e96e5-0b52-4daa-87f9-4d3a4dcd86d4';

-- Not sure where this column came from, but it should be on the product category itself, so remove it
ALTER TABLE m_product
	DROP COLUMN bh_product_category_type;
-- These are old fields that were meant for testing that shouldn't be in PROD
ALTER TABLE ad_user
	DROP COLUMN bandahealth_bpartners;
ALTER TABLE ad_user
	DROP COLUMN eve_bpartners;

-- Delete the columns that were removed above
DELETE
FROM
	ad_column
WHERE
	ad_column_uu IN ('14faefde-8b98-4e8a-b703-b0f36091656d', '6709aa10-f347-451e-9824-c09f29082bb3',
	                 '80ed368a-7b59-44d3-b977-9583e60e4528');

-- Update the bh_encounter_type_window table to not make certain columns keys
UPDATE ad_column
SET
	iskey    = 'N',
	isparent = 'Y'
WHERE
	ad_column_uu IN ('7cbc8eec-f8ba-4532-ac24-06dde60c76df', '2a30994f-7159-4802-be91-cdd770b991df');

-- Make the coded diagnosis column on the encounter diagnosis table not mandatory
UPDATE ad_column
SET
	ismandatory = 'N'
WHERE
	ad_column_uu = '65218da9-6835-4cda-a2d8-f275b313b1c4';

-- Set model cascades so iDempiere can handle deletion of dependent entities
UPDATE ad_column
SET
	fkconstrainttype = 'M'
WHERE
	ad_column_uu IN ('8d840880-1948-44d5-b160-c309c8b49716', '3d272d31-6f45-41de-92e5-2ed8ec22d41c',
	                 'a5413729-1309-4f91-addf-7ed9e0599ec5', 'ae09c94f-ec03-4809-9544-1aefb4075799',
	                 'fa2e7bc6-538b-468e-9c90-f740bbd35c4a', 'd4e8a380-4f18-4fcd-a9ac-53f63be918d3',
	                 'c4c984e2-47d8-4a24-afcb-48f4539c6e47');

-- Since invoice lines are cascade delete from invoices, do the same for the BP Specific Payer Information
ALTER TABLE bh_bp_specific_payer_info
	DROP CONSTRAINT IF EXISTS cinvoiceline_bhbpspecificpayer;
ALTER TABLE bh_bp_specific_payer_info
	ADD CONSTRAINT cinvoiceline_bhbpspecificpayer
		FOREIGN KEY (c_invoiceline_id) REFERENCES c_invoiceline
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;
-- Update the column to specify this
UPDATE ad_column
SET
	fkconstrainttype = 'C'
WHERE
	ad_column_uu IN ('69734631-bd60-4d59-b3d7-6104527a00e7');


SELECT
	register_migration_script('202401010000_GrapqQL.sql')
FROM
	dual;
