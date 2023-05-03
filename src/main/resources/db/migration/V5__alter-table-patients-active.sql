ALTER TABLE patients ADD COLUMN active TINYINT;
UPDATE patients SET active = 1;
alter table patients MODIFY active TINYINT NOT NULL;