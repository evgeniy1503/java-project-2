run-dist: #запуск программы
	./build/install/app/bin/app

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

build:
	./gradlew clean build

run:
	./gradlew run

install:
	./gradlew clean installDist

report:
	./gradlew jacocoTestReport

build-run: build test lint

.PHONY: build




