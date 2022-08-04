.PHONY: all dist migration run
all: container migration dist run
dist:
	./mvnw clean package
migration:
	mvn clean flyway:migrate -Dflyway.configFiles=myFlywayConfig.conf
run:
	java -jar target/training-metrics-service-0.0.1.jar
container:
	docker start postgresql