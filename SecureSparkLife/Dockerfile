FROM openjdk:8

WORKDIR /secureapp/bin

ENV PORT 6000
ENV TZ America/Bogota

COPY /target/classes /secureapp/bin/classes
COPY /target/dependency /secureapp/bin/dependency
RUN mkdir keystores
COPY keystores/* /secureapp/bin/keystores/

CMD ["java","-cp","./classes:./dependency/*","co.edu.escuelaing.arep.securesparklife.SecureServices"]