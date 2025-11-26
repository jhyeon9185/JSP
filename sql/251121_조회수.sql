use edudb;

select * from board;

update board set readcount = readcount+1
where num = 5;
commit;

select * from board;

delete from board
where num = 6;

select * from board;
commit;

use edudb;

create table users (
	userid int auto_increment primary key,
    name varchar(50) not null unique,
    email varchar(100) not null unique,
    password varchar(255) not null
);

INSERT INTO users (userid, email, password)
VALUES 
('test1', 'hong@example.com', '1234'),
('test2', 'kim@example.com', '1234'),
('test3', 'park@example.com', '1234');


drop table users;

use edudb;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,     -- PK (추가)
    name VARCHAR(50) NOT NULL,             -- 이름
    userid VARCHAR(50) NOT NULL UNIQUE,    -- 로그인 ID
    password VARCHAR(255) NOT NULL,        -- 비밀번호 (암호화 저장 권장)
    email VARCHAR(100) NOT NULL UNIQUE,    -- 이메일
    phone VARCHAR(20) NULL,              -- 전화번호
    admin INT DEFAULT 0                  -- 관리자 여부 (0=일반, 1=관리자)
);

INSERT INTO users (name, userid, password, email, phone, admin)
VALUES 
('test1', 'hong123', '1234', 'hong@example.com', '010-1111-2222', 0),
('test2', 'hong456', '1234', 'hong2@example.com', '010-1111-2222', 1),
('test3', 'hong789', '1234', 'hong3@example.com', '010-1111-2222', 0);
commit;

select * from users;

use edudb;

DROP TABLE IF EXISTS product;

CREATE TABLE product (
    num INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    description TEXT,
    pictureurl VARCHAR(200),
    regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO product (name, price, description, pictureurl)
VALUES
('아메리카노', 4500, '진한 에스프레소에 물을 더한 커피', '아메리카노.jpg'),
('아이스 바닐라 라떼', 5500, '우유를 넣은 부드러운 라떼', '아이스 바닐라 라떼.jpg'),
('카라멜 마키아또', 5500, '에스프레소와 달달한 카라멜이 조화로운 커피', '카라멜 마키아또.jpg'),
('아이스 카페 모카', 6500, '초콜릿 시럽과 우유가 들어간 시원한 프라푸치노', '아이스 카페 모카.jpg'),
('자바 칩 프라푸치노', 7000, '초콜릿 칩과 진한 초코우유가 들어간 시원한 프라푸치노', '자바 칩 프라푸치노.jpg'),
('말차 크림 프라푸치노', 7000, '말차와 크림의 부드러운 조화 프라푸치노', '말차 크림 프라푸치노.jpg'),
('밀크티', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '밀크티.jpg'),
('아이스티', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '아이스티.jpg'),
('얼크레이티', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '얼크레이티.jpg'),
('자몽 허니 블렌디드', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '자몽 허니 블렌디드.jpg'),
('라벤더 카페 라떼', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '라벤더 카페 라떼.jpg'),
('피치 에이드', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '피치 에이드.jpg');

DESC product;

select * from product;

show tables;

CREATE TABLE product (
    num INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    description TEXT,
    pictureurl VARCHAR(200),
    regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO product (name, price, description, pictureurl)
VALUES
('아메리카노', 4500, '진한 에스프레소에 물을 더한 커피', '아메리카노.jpg'),
('아이스 바닐라 라떼', 5500, '우유를 넣은 부드러운 라떼', '아이스 바닐라 라떼.jpg'),
('카라멜 마키아또', 5500, '에스프레소와 달달한 카라멜이 조화로운 커피', '카라멜 마키아또.jpg'),
('아이스 카페 모카', 6500, '초콜릿 시럽과 우유가 들어간 시원한 프라푸치노', '아이스 카페 모카.jpg'),
('자바 칩 프라푸치노', 7000, '초콜릿 칩과 진한 초코우유가 들어간 시원한 프라푸치노', '자바 칩 프라푸치노.jpg'),
('말차 크림 프라푸치노', 7000, '말차와 크림의 부드러운 조화 프라푸치노', '말차 크림 프라푸치노.jpg'),
('밀크티', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '밀크티.jpg'),
('아이스티', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '아이스티.jpg'),
('얼크레이티', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '얼크레이티.jpg'),
('자몽 허니 블렌디드', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '자몽 허니 블렌디드.jpg'),
('라벤더 카페 라떼', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '라벤더 카페 라떼.jpg'),
('피치 에이드', 6000, '말차와 크림의 부드러운 조화 프라푸치노', '피치 에이드.jpg');
commit;

DESC product;

select * from product;
