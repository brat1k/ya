CREATE OR REPLACE PROCEDURE tst IS
    cn        NUMBER := 8;
    cn_fact   NUMBER;
BEGIN
   -- Выполянем тестируемый скрипт
    calc_dept_cfo;
    SELECT
        COUNT(*)
    INTO cn_fact
    FROM
        dept_cfo;
   -- Проверяем количество

    dbms_output.enable;
    IF cn_fact = cn THEN
        dbms_output.put_line('Success actual count '
                             || cn_fact
                             || ' expected '
                             || cn);
    ELSE
        dbms_output.put_line('Fail actual count '
                             || cn_fact
                             || ' expected '
                             || cn);
    END IF;

END tst;
/