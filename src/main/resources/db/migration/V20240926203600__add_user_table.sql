create table "user"(
    id uuid not null primary key,
    email text not null,
    password text not null,
    roles text[] not null,
    enabled boolean not null
);

create unique index user_email_unique_idx on "user"(email);

insert into "user" (id, email, password, roles, enabled)
values ('123e4567-e89b-12d3-a456-426614174000', 'test@test.com', 'password', array['USER'], true);
