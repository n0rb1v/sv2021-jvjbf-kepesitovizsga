create table recorder
(
    id            bigint not null auto_increment,
    date_of_birth date,
    name          varchar(255),
    primary key (id)
) engine = InnoDB;
create table world_record
(
    id              bigint           not null auto_increment,
    date_of_record  date,
    description     varchar(255),
    recorder_id     bigint,
    unit_of_measure varchar(255),
    value           double precision not null,
    primary key (id)
) engine = InnoDB;