DELETE
FROM c_payment
WHERE description = 'Fix for update issue';

SELECT register_migration_script('202105021358_GO-1637.sql') FROM dual;
