FROM eclipse-temurin:17

RUN apt-get update && apt-get install -y unzip

RUN mkdir -p /myapp

## Gradle のバージョンを指定
ENV GRADLE_VERSION=7.2

# Gradle をインストール
RUN wget -q --show-progress --https-only --no-check-certificate "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" && \
    unzip -d /opt/gradle "gradle-${GRADLE_VERSION}-bin.zip" && \
    rm "gradle-${GRADLE_VERSION}-bin.zip"

# Gradle の環境変数を設定
ENV GRADLE_HOME=/opt/gradle/gradle-${GRADLE_VERSION}
ENV PATH=$PATH:$GRADLE_HOME/bin

# Gradle のバージョン確認
RUN gradle --version