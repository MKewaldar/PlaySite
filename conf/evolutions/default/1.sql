# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table song (
  id                            integer auto_increment not null,
  title                         varchar(255),
  price_in_dollars              integer not null,
  artist                        varchar(255),
  duration_in_minutes           integer,
  constraint pk_song primary key (id)
);


# --- !Downs

drop table if exists song;

