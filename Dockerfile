FROM openjdk:8
COPY ./target/Mini_Spe_calculator-1.0-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-jar", "Mini_Spe_calculator-1.0-SNAPSHOT.jar", "Main"]
