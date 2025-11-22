# 1. Java 21 실행 환경 (가벼운 버전)
FROM eclipse-temurin:21-jdk-alpine

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 빌드된 jar 파일을 이미지 내부로 복사
# (GitHub Actions에서 빌드한 결과물을 가져옵니다)
COPY build/libs/*.jar app.jar

# 4. 서버 실행 (8080번 포트)
ENTRYPOINT ["java", "-jar", "app.jar"]