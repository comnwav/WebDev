-- table list
select * from seat;
select * from seat_reserved;
select * from movie;
select * from auditorium;
select * from screening;

SELECT
    *
FROM
    info_cmt;

desc info_cmt;

CREATE TABLE info_cmt (
    usr_id  VARCHAR2(50),
    cm_code VARCHAR2(10),
    cm_cont varchar2(200),
    cm_data date,
    cm_stars number(1)
);

alter table info_cmt add constraint info_cmt_pk primary key (usr_id, cm_code);

CREATE TABLE seat (
    seat_id       VARCHAR2(10),
    seat_row      VARCHAR2(1),
    seat_number   NUMBER,
    auditorium_id VARCHAR2(10)
);

DROP TABLE seat;

CREATE SEQUENCE seat_id_seq START WITH 1 INCREMENT BY 1;

DROP SEQUENCE seat_id_seq;

SELECT
    *
FROM
    seat
ORDER BY
    seat_id;

CREATE TABLE seat_reserved (
    seat_reserved_id NUMBER,
    seat_id          NUMBER,
    screening_id     NUMBER
);

CREATE TABLE auditorium (
    auditorium_id   VARCHAR2(10),
    auditorium_name VARCHAR2(50)
);

DROP TABLE auditorium;

INSERT INTO auditorium (
    auditorium_id,
    auditorium_name
) VALUES (
    'adt3',
    '3관'
);

CREATE TABLE movie (
    movie_id    VARCHAR2(10),
    movie_title VARCHAR2(100),
    duration_min number
);

drop table movie;

SELECT
    *
FROM
    movie;

INSERT INTO movie (
    movie_id,
    movie_title,
    duration_min
) VALUES (
    'mv0001',
    '가타카',
    120
);

CREATE TABLE screening (
    screening_id    VARCHAR2(10),
    movie_id        VARCHAR2(10),
    auditorium_id   VARCHAR2(10),
    screening_start DATE
);


-- create seat_attribute
DECLARE
    seatid  VARCHAR2(50);
    adtid   VARCHAR2(50) := 3;
    seatnum NUMBER := 1;
    v_str   VARCHAR2(1) := 'i';
BEGIN
    WHILE seatnum < 16 LOOP
        INSERT INTO seat (
            seat_id,
            seat_number,
            seat_row,
            auditorium_id
        ) VALUES (
            'st' || lpad(seat_id_seq.NEXTVAL, 3, '0'),
            seatnum,
            v_str,
            'adt' || adtid
        );
        seatnum := seatnum + 1;
    END LOOP;
END;
/