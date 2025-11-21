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

