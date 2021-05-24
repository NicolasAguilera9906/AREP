FROM openjdk:8

WORKDIR /logic/bin

ENV PORT 8000
ENV TZ America/Bogota

COPY /target/classes /logic/bin/classes
COPY /target/dependency /logic/bin/dependency
RUN mkdir keyscerts
COPY keyscerts/* /logic/bin/keyscerts/

CMD ["java","-cp","./classes:./dependency/*","co.escuelaing.edu.SparkWebApp"]