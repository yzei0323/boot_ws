-- Statement 방식은 쿼리가 만들어지고 실행되는 방식이다, 사용자가 악의적인 코드를 전달할 수 있다
-- SQL injection  예시
-- 1) 예시  : 조건에 모두 만족하게 해서 모든 정보 가져오기 

SELECT * FROM acorntbl WHERE name = ' ' OR '1'='1';

--  String name   = " ' OR  '1' = '1 ";

--name = '' 이거나  뒤에 조건은 무조건 참이 되므로  조건이 만족해서 모든 고객정보가 조회됨
SELECT * FROM acorntbl WHERE name = ' ' OR '1'='1';

insert into acorntbl values('admin', '1234', '관리자');
commit;


-- 2) 관리자 비밀번호 없이 사용하기 
SELECT * FROM acorntbl WHERE id='admin'  AND  pw='1234';

--사용자가   id  =>  admin 
--사용자가   id  =>  admin' --

--sql 에서   --은 주석으로 처리된다
--비밀번호 없이 들어올 수 있다
SELECT * FROM acorntbl WHERE id='admin'--'  and pw='1234';
