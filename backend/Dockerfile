# https://medium.com/@balaji2000d/create-a-docker-image-for-the-sbt-application-28662ef17c65

# Базовый образ с Java
FROM openjdk:11

# Устанавливаем sbt и scala, используя аргументы для указания версий
ARG SBT_VERSION=1.10.4

RUN mkdir /working/ && \
    cd /working/ && \
    curl -L -o sbt-$SBT_VERSION.deb https://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
    echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" >> /etc/apt/sources.list.d/sbt.list && \
    curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add - && \
    apt-get update && \
    apt-get install -y sbt=$SBT_VERSION && \
    rm sbt-$SBT_VERSION.deb && \
    cd && \
    rm -r /working/ && \
    sbt sbtVersion

RUN mkdir -p backend-api

# ADD ../. /backend-api

# Устанавливаем рабочую директорию
WORKDIR /backend-api

# Копируем проект
COPY ./ ./

# Сборка проекта
RUN sbt compile
# RUN cd /backend-api && sbt compile


# Определение переменной окружения PROJECT для запуска нужного модуля
# ARG PROJECT
# CMD ["sbt", "project backend-api", "run"]
# ARG PROJECT
# CMD ["sbt", "backend-api" "run"]
# CMD sbt backend-api/run
# CMD ["sbt", "backend-api/Compile", "run"]
# CMD sbt "project backend-api" run
CMD sbt "backend-api/Compile / run"

# Expose порт (замените на нужный, если используется другой)
EXPOSE 8080


# docker build -t backend:0.1 .
# docker compose up --build --remove-orphans