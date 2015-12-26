CREATE TABLE logs (
 id SERIAL NOT NULL,
 no INT,
 date DATE,
 location VARCHAR(255),
 time_in TIME,
 time_out TIME,
 bar_in INT,
 bar_out INT,
 max_depth REAL,
 avg_depth REAL,
 weight INT,
 air_temp REAL,
 surface_temp REAL,
 bottom_temp REAL,
 visibility INT,
 notes VARCHAR(1000)
);

ALTER TABLE logs ADD CONSTRAINT PK_logs PRIMARY KEY (id);
