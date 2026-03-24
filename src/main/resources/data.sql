insert into user_details(id,name,birth_date) values(10001,'Ram','2000-01-01');

insert into user_details(name,id,birth_date) values('Laksh',10002,CURRENT_DATE);

insert into post(id,user_id,description) values('20001','10001','Want to learn AWS');

insert into post(id,user_id,description) values('20002','10002','Want to learn SPRING');

insert into post(id,user_id,description) values('20003','10001','Want to learn REACT');

insert into post(id,user_id,description) values('20004','10002','Want to learn CLOUD');