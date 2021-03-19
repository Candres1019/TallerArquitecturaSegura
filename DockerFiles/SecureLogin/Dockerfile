FROM openjdk:8

WORKDIR /secureapp/bin

ENV PORT 6000
ENV TZ America/Bogota

COPY /target/classes /secureapp/bin/classes
COPY /target/dependency /secureapp/bin/dependency
RUN mkdir keystores/
RUN mkdir keystores/service
COPY keystores/service /secureapp/bin/keystores/service

CMD ["java","-cp","./classes:./dependency/*","co.edu.escuelaing.arep.securesparklife.SecureServices"]