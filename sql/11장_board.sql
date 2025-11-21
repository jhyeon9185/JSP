
use edudb;

create table board(
	num int primary key auto_increment,
    pass varchar(30) not null,
    name varchar(30),
	email varchar(30),
    title varchar(50),
    content varchar(1000),
    readcount int default 0,
    writedate datetime default current_timestamp	
);

desc board;

INSERT INTO board(name, email, pass, title, content) 
VALUES('성윤정', 'pinksung@nate.com', '1234', '첫방문', '반갑습니다');

INSERT INTO board(name, email, pass, title, content) 
VALUES('성윤정', 'pinksung@nate.com', '1234', '김밥', '맛있어요');

INSERT INTO board(name, email, pass, title, content) 
VALUES('전수빈', 'raccon@nate.com', '3333', '고등애', '일식입니다');

INSERT INTO board(name, email, pass, title, content) 
VALUES('전원지', 'one@nate.com', '1111', '갯골마을', '돼지 삼겹살이 맛있습니다');
commit;

select * from board;



