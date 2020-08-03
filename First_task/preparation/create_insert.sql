create table depart(depart_id NUMBER, depart_name VARCHAR2(100));
create table depart_add(depart_id NUMBER, add_type VARCHAR2(100), add_value VARCHAR2(100));
create table hierarchy(parent_id NUMBER, child_id NUMBER);
create table dept_cfo(depart_id NUMBER, cfo VARCHAR2(100));

INSERT INTO depart VALUES (1, 'Отдел1');
INSERT INTO depart VALUES (8, 'Служба11');
INSERT INTO depart VALUES (3, 'Группа111');
INSERT INTO depart VALUES (4, 'Группа112');
INSERT INTO depart VALUES (5, 'Служба12');
INSERT INTO depart VALUES (6, 'Группа121');
INSERT INTO depart VALUES (7, 'Группа122');
INSERT INTO depart VALUES (2, 'Группа123');

INSERT INTO depart_add VALUES (1, 'CFO', 'D1');
INSERT INTO depart_add VALUES (8, null, null);
INSERT INTO depart_add VALUES (3, null, null);
INSERT INTO depart_add VALUES (4, null, null);
INSERT INTO depart_add VALUES (5, 'CFO', 'S12');
INSERT INTO depart_add VALUES (6, null, null);
INSERT INTO depart_add VALUES (7, 'CFO', null);
INSERT INTO depart_add VALUES (2, 'CFO', 'G123');

INSERT INTO hierarchy VALUES (1, 1);
INSERT INTO hierarchy VALUES (1, 8);
INSERT INTO hierarchy VALUES (8, 3);
INSERT INTO hierarchy VALUES (8, 4);
INSERT INTO hierarchy VALUES (1, 5);
INSERT INTO hierarchy VALUES (5, 6);
INSERT INTO hierarchy VALUES (5, 7);
INSERT INTO hierarchy VALUES (5, 2);
commit;