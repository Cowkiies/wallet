FROM library/postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB postgres
COPY init_db/1_create_tables.sql /docker-entrypoint-initdb.d/
COPY init_db/2_insert_data.sql /docker-entrypoint-initdb.d/
