.PHONY: all dist migration run database-up
all: database-up migration dist run
database-up:
	docker start postgresdb || docker run --name postgresdb -e POSTGRES_USER=jjalvarez -e POSTGRES_PASSWORD=jjalvarez -e POSTGRES_DB=metrics -d -p 5432:5432 postgres
dist:
	./mvnw clean package
migration:
	mvn clean flyway:migrate -Dflyway.configFiles=myFlywayConfig.conf
run:
	java -jar target/training-metrics-service-0.0.1.jar