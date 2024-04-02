-- Update payment rule that is not on credit to be direct deposit

UPDATE c_invoice
SET
	paymentrule = 'T'  
WHERE
	paymentrule != 'P';

SELECT
	register_migration_script('202404011434_GO-2592.sql')
FROM
	dual;  

  