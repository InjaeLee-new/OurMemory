--반려동물 자랑하기 !
create table showoffboard (
  board_num number,                      -- 글번호
  board_name varchar2(20) not null,      -- 글작성자
  board_pass varchar2(15) not null,      -- 글비밀번호
  board_subject varchar2(50) not null,   -- 글제목
  board_content varchar2(2000) not null, -- 글내용
  board_rec number,                      -- 추천수
  board_nrec number,                     -- 비추천수
  board_hit number,                      -- 조회수
  board_file varchar2(50) not null,      -- 첨부파일
  board_date date,                       -- 올린 날짜 저장용
  primary key(board_num)
);

-- 테이블 삭제
drop table showoffboard purge;

-- 시퀀스 만들기
create sequence sequence_num nocycle nocache;

-- 시퀀스 삭제
drop sequence seqence_num;

-- 테이블 확인
select * from tab;

-- 데이터 저장
insert into showoffboard values
(sequence_num.nextval, '홍길동', '1234', '나비나비', '내용1', 0, 0, 0, 'navi.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '이인제', '1234', '퉁퉁이', '내용1', 0, 0, 0, 'tungtung.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '전성환', '1234', '귤이ㅠㅠㅠ', '내용1', 0, 0, 0, 'gyul2.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '전상만', '1234', '귤이귀여워ㅠㅠ', '내용1', 0, 0, 0, 'gyul3.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '문성하', '1234', '귤이최고야ㅠㅠ', '내용1', 0, 0, 0, 'gyul1.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '김승원', '1234', '옷안칸쵸~', '내용1', 0, 0, 0, 'kancho2.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '홍성인', '1234', '코코!!', '내용1', 0, 0, 0, 'coco.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '정성빈', '1234', '거북이법규', '내용1', 0, 0, 0, 'turtle.png', sysdate);

-- 데이터 확인
select * from showoffboard;
select * from showoffboard where board_num = 1;

-- 데이터 수정
update showoffboard set board_subject = '너도나와칸쵸' where board_num = 11;
update showoffboard set board_subject = '햄찌' where board_num = 7;
update showoffboard set board_file = 'tungtung.jpg' where board_num = 23;

select * from
(select rownum rn, tt.* from 
(select * from showoffboard order by board_num desc) tt)
where rn>=1 and rn<=5;

-- 데이터 저장
commit;

--------------------------------------------------------
-- 우리들의 추억 저장소
create table mymemoryalbum (
  memory_num number,                      -- 글번호
  memory_name varchar2(20) not null,      -- 글작성자
  memory_pass varchar2(15) not null,      -- 글비밀번호
  memory_subject varchar2(50) not null,   -- 글제목
  memory_content varchar2(2000) not null, -- 글내용
  memory_rec number,                      -- 추천수
  memory_nrec number,                     -- 비추천수
  memory_hit number,                      -- 조회수
  memory_file varchar2(50) not null,      -- 첨부파일
  memory_date date,                       -- 올린 날짜 저장용
  primary key(memory_num)
);

-- 테이블 삭제
drop table mymemoryalbum purge;

-- 시퀀스 만들기
create sequence seq_memory_num nocycle nocache;

-- 시퀀스 삭제
drop sequence seq_memory_num;

-- 테이블 확인
select * from tab;

-- 데이터 저장
insert into mymemoryalbum values
(seq_memory_num.nextval,'홍길동', '1234', '추억1', '내용1', 0, 0, 0, 'memory1.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'이인제', '1234', '추억2', '내용1', 0, 0, 0, 'memory2.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'전성환', '1234', '추억3', '내용1', 0, 0, 0, 'memory3.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'전상만', '1234', '추억4', '내용1', 0, 0, 0, 'memory4.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'문성하', '1234', '추억5', '내용1', 0, 0, 0, 'memory5.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'김승원', '1234', '추억6', '내용1', 0, 0, 0, 'memory6.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'홍성인', '1234', '추억7', '내용1', 0, 0, 0, 'memory1.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'정성빈', '1234', '추억8', '내용1', 0, 0, 0, 'memory2.jpg' , sysdate);


-- 데이터 확인
select * from mymemoryalbum;
select * from mymemoryalbum where memory_num = 1;

-- 데이터 수정
update mymemoryalbum set memory_name = '요기까지!' where memory_num = 6;

select * from
(select rownum rn, tt.* from 
(select * from mymemoryalbum order by memory_num desc) tt)
where rn>=1 and rn<=5;

-- 데이터 저장
commit;

select * from tab;

--------------------------