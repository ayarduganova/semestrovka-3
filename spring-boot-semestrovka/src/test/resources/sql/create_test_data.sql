delete from user_role;
delete from account_info;
delete from dog;
delete from walker_form;
delete from post;
delete from walker;
delete from account;

insert into account(id, username, password, is_active, is_admin) values
(1, 'nastya', '$2a$10$u9r840oG0L9ZYkBf8Aqn6uof4I9XfDF.lYLvvlwo74rzJn6TgARLC', true, true),
(2, 'katya', '$2a$10$6xdm/tckd0riXYV4UDaY4uG46Ou.p7W307ojUMdVTrZStx782LeR2', true, false);

insert into account_info(id, birthday, email, first_name, last_name, gender, phone, account_id) values
(1, '2024-05-31 02:15:35.000000', 'a@mail.ru', 'Nastya', 'Arduganova', 'women', '89177492345', 1),
(2, '2024-05-31 02:15:35.000000', 'a@mail.ru', 'Nastya', 'Arduganova', 'women', '89177492345', 2);

insert into user_role(user_id, role_id) values
(1, 1), (1, 2),
(2, 1), (2, 3);

insert into post(id, comment, user_id) values
(1, 'drhhthrth', 2),
(2, 'ghbdtn', 2);

