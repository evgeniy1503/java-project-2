run-dist: #запуск программы
	./build/install/app/bin/app

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

.PHONY: build




