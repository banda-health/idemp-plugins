-- Update payment rule that is not on credit to be direct deposit

UPDATE c_invoice i
SET
	i.paymentrule = 'T'
WHERE
	i.paymentrule != 'P';

SELECT
	register_migration_script('202404011434_GO-2592.sql')
FROM
	dual;    