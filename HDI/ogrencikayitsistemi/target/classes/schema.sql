create table public.t_student(
    id bigint not null,
    first_name varchar(255),
    last_name varchar(255)
);

create table public.t_lesson(
    id bigint not null,
    lesson_name varchar(255),
    capacity int
);

create table public.t_student_lesson(
    id bigint not null,
    student_id bigint not null,
    lesson_id bigint not null
);


alter table t_student add constraint public.constraint_1 primary key (id);
alter table t_lesson add constraint public.constraint_2 primary key (id);
alter table t_student_lesson add constraint public.constraint_3 primary key (id);
alter table t_student_lesson add constraint public.constraint_4 foreign key(student_id) references public.t_student(id);
alter table t_student_lesson add constraint public.constraint_5 foreign key(lesson_id) references public.t_lesson(id);
create sequence public.student_sequence start with 100;
create sequence public.lesson_sequence start with 100;
create sequence public.student_lesson_sequence start with 100;