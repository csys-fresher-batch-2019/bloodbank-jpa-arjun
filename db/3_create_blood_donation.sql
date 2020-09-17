drop table blood_donations;

create table blood_donations (
    id number,
    user_id number not null,
    donated_on date not null,
    constraint bd_id_pk primary key(id),
    constraint bd_user_id_fk foreign key(user_id) references donor_details(id),
    constraint bd_user_id_donated_on_uq unique(user_id, donated_on)
);

alter table blood_donations add (created_date timestamp not null);

alter table blood_donations add (modified_date timestamp not null);

create sequence blood_donation_id_seq start with 1 increment by 50;

insert into blood_donations(id,user_id,donated_on,created_date,modified_date) values(blood_donation_id_seq.nextVal,1,sysDate,systimestamp,systimestamp);

--delete from blood_donations;

commit;

select * from blood_donations;