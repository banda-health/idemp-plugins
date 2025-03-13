-- Rename the default price lists
SELECT
	m_pricelist_id
INTO TEMP TABLE
	tmp_m_pricelist_ids_to_update
FROM
	m_pricelist
WHERE
	(ad_client_id > 999999 OR ad_client_id = 2)
	AND isdefault = 'Y'
	AND isactive = 'Y'
	AND issopricelist = 'Y'
	AND name IN ('BandaSales-2018', 'Sale', ' Sale Price List', 'Sale Price List', 'Sales', 'Sales ', 'Sales Price list',
	             'Sales Price List', 'Sales Price List ', 'Sales Price List.', 'Sales Price LIst ',
	             'Sales Price List Version One', 'Sales Prices List', 'Standard');

UPDATE m_pricelist
SET
	name = 'Default Price List'
WHERE
	m_pricelist_id IN (
		SELECT
			m_pricelist_id
		FROM
			tmp_m_pricelist_ids_to_update
	);

UPDATE m_pricelist
SET
	name = 'Default Purchase Price List'
WHERE
	(ad_client_id > 999999 OR ad_client_id = 2)
	AND issopricelist = 'N'
	AND isdefault = 'Y';

UPDATE m_pricelist_version
SET
	name = 'Default Price List'
WHERE
	m_pricelist_id IN (
		SELECT
			m_pricelist_id
		FROM
			tmp_m_pricelist_ids_to_update
	);

UPDATE m_pricelist_version
SET
	name = 'Default Purchase Price List'
WHERE
	m_pricelist_id IN (
		SELECT m_pricelist_id FROM m_pricelist WHERE (ad_client_id > 999999 OR ad_client_id = 2) AND isdefault = 'Y' AND issopricelist = 'N'
	);

-- Register the script and be done
SELECT
	register_migration_script('202503121404_GO-1443.sql')
FROM
	dual;
