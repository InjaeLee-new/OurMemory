--반려동물 자랑하기 !
create table showoffboard (
  board_num number,                      -- 글번호
  board_name varchar2(20) not null,      -- 글작성자
  board_id varchar2(15) not null, 
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
drop sequence sequence_num;

-- 테이블 확인
select * from tab;

-- 데이터 저장
insert into showoffboard values
(sequence_num.nextval, '홍길동','id1', '1234', '나비나비', '내용1', 0, 0, 0, 'navi.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '이인제','id1', '1234', '퉁퉁이', '내용1', 0, 0, 0, 'tungtung.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '전성환','id1', '1234', '귤이ㅠㅠㅠ', '내용1', 0, 0, 0, 'gyul2.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '전상만','id1', '1234', '귤이귀여워ㅠㅠ', '내용1', 0, 0, 0, 'gyul3.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '문성하','id1', '1234', '귤이최고야ㅠㅠ', '내용1', 0, 0, 0, 'gyul1.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '김승원','id1', '1234', '옷안칸쵸~', '내용1', 0, 0, 0, 'kancho2.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '홍성인','id1', '1234', '코코!!', '내용1', 0, 0, 0, 'coco.jpg', sysdate);
insert into showoffboard values
(sequence_num.nextval, '정성빈','id1', '1234', '거북이법규', '내용1', 0, 0, 0, 'turtle.png', sysdate);

-- 데이터 확인
select * from showoffboard;
select * from showoffboard where board_num = 2;

-- 게시판 내에 TOP 3 게시글만 노출시키기 위해서 해당 구문을 작성함.
select * from
(select rownum rn, tt.* from 
(select * from showoffboard order by board_rec desc) tt)
where rn>=1 and rn<=3;

-- 데이터 수정
update showoffboard set board_id = 'id2' where board_num = 3;
update showoffboard set board_subject = '너도나와칸쵸' where board_num = 11;
update showoffboard set board_subject = '햄찌' where board_num = 7;
update showoffboard set board_file = 'tungtung.jpg' where board_num = 23;

-- 내용 1이라고만 써있는 내용을 좀 길게 써서 view에서 확인할 수 있도록.
update showoffboard set board_content = '일단 임의로 내용을 무지하게 늘려서 있어보이게 만들거야. 나중에 수정은 따로 할 수 있으니까 긴 글을
쓸 수 있게만 만들자 그게 최고인거같아.';

-- 조회수 증가
update showoffboard set board_hit = board_hit + 1 where board_num = 2;

-- 추천수 증가
update showoffboard set board_rec = board_rec + 1 where board_num = 2;

-- 비추천수 증가
update showoffboard set board_nrec = board_nrec + 1 where board_num = 2;

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
  memory_id varchar2(15) not null,        -- 글아이디
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
(seq_memory_num.nextval,'홍길동','id1', '1234', '추억1', '내용1', 0, 0, 0, 'memory1.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'이인제','id1', '1234', '추억2', '내용1', 0, 0, 0, 'memory2.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'전성환','id1', '1234', '추억3', '내용1', 0, 0, 0, 'memory3.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'전상만','id1', '1234', '추억4', '내용1', 0, 0, 0, 'memory4.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'문성하','id1', '1234', '추억5', '내용1', 0, 0, 0, 'memory5.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'김승원','id1', '1234', '추억6', '내용1', 0, 0, 0, 'memory6.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'홍성인','id1', '1234', '추억7', '내용1', 0, 0, 0, 'memory1.jpg' , sysdate);
insert into mymemoryalbum values
(seq_memory_num.nextval,'정성빈','id1', '1234', '추억8', '내용1', 0, 0, 0, 'memory2.jpg' , sysdate);


-- 데이터 확인
select * from mymemoryalbum;
select * from mymemoryalbum where memory_num = 1;

-- 게시판 내에 TOP 3 게시글만 노출시키기 위해서 해당 구문을 작성함.
select * from
(select rownum rn, tt.* from 
(select * from mymemoryalbum order by memory_rec desc) tt)
where rn>=1 and rn<=3;
-- 테스트 아이디 수정 
update mymemoryalbum set memory_id = 'id2' where memory_num = 2 ;

-- 데이터 수정
update mymemoryalbum set memory_name = '요기까지!' where memory_num = 6;

-- 조회수 증가
update mymemoryalbum set memory_hit = memory_hit + 1 where memory_num = 2;

-- 추천수 증가
update mymemoryalbum set memory_rec = memory_rec + 1 where memory_num = 2;

-- 비추천수 증가
update mymemoryalbum set memory_nrec = memory_nrec + 1 where memory_num = 2;

select * from
(select rownum rn, tt.* from 
(select * from mymemoryalbum order by memory_num desc) tt)
where rn>=1 and rn<=5;

select * from mymemoryalbum where memory_num = 2;

-- 데이터 저장
commit;

select * from tab;
-----------------------------------------------------------------------------
-- 회원관리 테이블
-- primary key = 기본키 , unique , not null
create table memoryMember (
    name varchar2(30) not null,
    id varchar2(30) primary key,
    pwd varchar2(30) not null,
    nickname varchar2(30) not null,
    gender varchar2(3),
    email1 varchar2(30),
    email2 varchar2(30),
    tel1 varchar2(10),
    tel2 varchar2(10),
    tel3 varchar2(10),
    addr varchar2(100),
    check_email number not null,
    check_sms number not null,
    profile_image varchar2(30),
    logtime date
);

--테이블 구조 확인
desc memoryMember;
--테이블 삭제
drop table memoryMember purge;
--테이블 목록
select * from tab;

-- 데이터 추가하기
insert into memoryMember values('홍길동', 'hong01' , '1234' , '하츠바', '0', 'hong', 'naver.com', '010', '1234' , '5678', '경기도 수원시', 0, 0, 'image1.png', sysdate);
insert into memoryMember values('홍길동', 'hong02' , '1234' , '하츠바', '0', 'hong', 'naver.com', '010', '1234' , '5678', '경기도 수원시', 0, 0, 'image1.png', sysdate);
insert into memoryMember values('홍길동', 'hong03' , '1234' , '하츠바', '0', 'hong', 'naver.com', '010', '1234' , '5678', '경기도 수원시', 0, 0, 'image1.png', sysdate);
insert into memoryMember values('홍길동', 'hong04' , '1234' , '하츠바', '0', 'hong', 'naver.com', '010', '1234' , '5678', '경기도 수원시', 0, 0, 'image1.png', sysdate);
insert into memoryMember values('홍길동', 'hong05' , '1234' , '하츠바', '0', 'hong', 'naver.com', '010', '1234' , '5678', '경기도 수원시', 0, 0, 'image1.png', sysdate);
insert into memoryMember values('홍길동', 'hong06' , '1234' , '하츠바', '0', 'hong', 'naver.com', '010', '1234' , '5678', '경기도 수원시', 0, 0, 'image1.png', sysdate);
insert into memoryMember values('홍길동', 'hong07' , '1234' , '하츠바', '0', 'hong', 'naver.com', '010', '1234' , '5678', '경기도 수원시', 0, 0, 'image1.png', sysdate);
insert into memoryMember values('홍길동', 'hong08' , '1234' , '하츠바', '0', 'hong', 'naver.com', '010', '1234' , '5678', '경기도 수원시', 0, 0, 'image1.png', sysdate);
insert into memoryMember values('홍길동', 'hong09' , '1234' , '하츠바', '0', 'hong', 'naver.com', '010', '1234' , '5678', '경기도 수원시', 0, 0, 'image1.png', sysdate);
insert into memoryMember values('홍길동', 'hong10' , '1234' , '하츠바', '0', 'hong', 'naver.com', '010', '1234' , '5678', '경기도 수원시', 0, 0, 'image1.png', sysdate);
insert into memoryMember values('홍길동', 'hong11' , '1234' , '하츠바', '0', 'hong', 'naver.com', '010', '1234' , '5678', '경기도 수원시', 0, 0, 'image1.png', sysdate);

-- 데이터 확인하기
select * from memoryMember;
select * from memoryMember where name = '홍길동';
select * from memoryMember where id ='hong10';

-- 회원정보 수정하기
update memoryMember set pwd = 2345, tel1 = 010, tel2 = 3333, tel3 = 4444 where id = 'hong';

update memoryMember set pwd = 2345, tel1 = 010, tel2 = 3333, tel3 = 4444, email1 = 'eij9404' , email2 = 'naver' , addr = 'ㅋㅋㅋㅋ' where id = 'eij9404';

-- 필요한 회원정보만 추출하기
select name, id, gender, nickname, email1, email2, tel1, tel2, tel3, addr, check_email, check_sms, profile_image, sysdate
from (select rownum rn, tt. * from (select * from memoryMember order by id desc) tt)
where rn>=1 and rn<=5;

-- 테스트할 구문
select name, id, gender, email1, email2, tel1, tel2, tel3, sysdate from (select rownum rn, tt. * from (select * from memoryMember order by id desc) tt) where rn>=1 and rn<=5;

-- 성별 맞추기
update memoryMember set gender = 'M' where gender = '0';

commit;

--------------------------
-- 글 게시글 
