create table request_donor(
id number,
title varchar2(50) not null,
description varchar2(200) not null,
posted_by number not null,
posted_date timestamp,
status varchar2(20) default 'OPENED',
constraint request_donor_id_pk primary key(id),
constraint request_donor_posted_by_fk foreign key(posted_by) references donor_details(id)
);

alter table request_donor add(blood_group_id number not null);

create sequence request_donor_seq increment by 50;
