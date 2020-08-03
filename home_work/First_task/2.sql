SELECT
    dep.depart_name,
    CASE
        WHEN da.add_type = 'CFO' THEN
           da.add_value
    END AS dep_value
FROM
    depart       dep
    JOIN hierarchy    h ON dep.depart_id = h.child_id
    JOIN depart_add   da ON da.depart_id = dep.depart_id
START WITH
    dep.depart_id = 1
CONNECT BY NOCYCLE
    PRIOR h.child_id = h.parent_id
ORDER SIBLINGS BY
    dep.depart_name;