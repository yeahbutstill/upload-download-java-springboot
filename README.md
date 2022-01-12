# upload-download-java-springboot

```shell
docker run --rm \
--name upload-download-file \
-e POSTGRES_DB=udfdb \
-e POSTGRES_USER=udfrest \
-e POSTGRES_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v "$PWD/udfdb-data:/var/lib/postgresql/data" \
-p 5432:5432 \
postgres
```