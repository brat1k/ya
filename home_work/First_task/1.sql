CREATE OR REPLACE PROCEDURE calc_dept_cfo  IS
    -- Считываем таблицу depart
    CURSOR di IS
    SELECT
        *
    FROM
        depart      d
        JOIN hierarchy   hi ON d.depart_id = hi.child_id
    START WITH
        d.depart_id = 1
    CONNECT BY NOCYCLE
        PRIOR hi.child_id = hi.parent_id
    ORDER SIBLINGS BY
        d.depart_name;
    -- Переменные
    cfo_type      VARCHAR2(100);
    cfo_value     VARCHAR2(100);
    name_depart   VARCHAR2(100);
    temp_value    VARCHAR2(100);
BEGIN
    -- Очистка таблицы
    DELETE FROM dept_cfo;
    -- Цикл по всем depart
    FOR i IN di LOOP
        -- Заполняем переменные
        SELECT
            dep.depart_name,
            da.add_type,
            da.add_value
        INTO
            name_depart,
            cfo_type,
            cfo_value
        FROM
            depart       dep
            JOIN hierarchy    h ON dep.depart_id = h.child_id
            JOIN depart_add   da ON da.depart_id = dep.depart_id
        WHERE
            dep.depart_id = i.depart_id;

        -- Ищем CFO
        IF lower(cfo_type) = 'cfo' AND cfo_value IS NOT NULL THEN
            temp_value := cfo_value;
        END IF;
        -- Заполняем таблицу dept_cfo
        INSERT INTO dept_cfo VALUES (
            i.depart_id,
            temp_value
        );

    END LOOP;

    COMMIT;
END calc_dept_cfo;
/