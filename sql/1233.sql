show databases;

use edudb;

commit;

select * from product;

DESC product;
commit;

select * from product;

delete from product	where code = 5;
commit;

select * from product;

drop table product;
commit;

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
commit;

select * from users;

select * from users where id = 3;

desc users;

select * from board;

delete from board where num=11;
commit;