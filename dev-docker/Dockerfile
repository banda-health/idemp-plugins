FROM eclipse-temurin:17-jdk AS idempiere
WORKDIR /

# Set prerequisites to install MS fonts that reports use
ENV DEBIAN_FRONTEND=noninteractive
RUN echo "ttf-mscorefonts-installer msttcorefonts/accepted-mscorefonts-eula select true" | debconf-set-selections

# Install download prerequisites
RUN apt-get update && apt-get install -y --no-install-recommends \
		wget \
		unzip

# Download the source code
RUN wget https://github.com/banda-health/idempiere/archive/refs/heads/release-12.zip -O idempiere.zip
RUN unzip idempiere.zip
RUN mv idempiere-release-12 /opt/idempiere
RUN rm -fd idempiere.zip idempiere-release-12

# Install remaining prerequisites
RUN apt-get update && apt-get install -y --no-install-recommends \
    ca-certificates \
    gnupg2 \
    nano \
    telnet \
    ttf-mscorefonts-installer \
  && wget -qO- https://www.postgresql.org/media/keys/ACCC4CF8.asc | gpg --dearmor -o /usr/share/keyrings/postgresql.gpg \
  && . /etc/os-release \
  && echo "deb [signed-by=/usr/share/keyrings/postgresql.gpg] http://apt.postgresql.org/pub/repos/apt ${VERSION_CODENAME}-pgdg main" > /etc/apt/sources.list.d/pgdg.list \
  && apt-get update \
  && apt-get install -y --no-install-recommends postgresql-client-18 \
  && rm -rf /var/lib/apt/lists/*
	
# Tycho 4.x (iDempiere) requires Maven >= 3.9; Ubuntu apt maven is too old.
ARG MAVEN_VERSION=3.9.9
RUN wget -q "https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz" -O /tmp/maven.tar.gz \
    && tar -xf /tmp/maven.tar.gz -C /opt \
    && ln -sf "/opt/apache-maven-${MAVEN_VERSION}" /opt/maven \
    && rm /tmp/maven.tar.gz
ENV PATH="/opt/maven/bin:${PATH}"

# Rebuild the font cache
RUN fc-cache -fv

# Build the source code (GitHub zip unpacks to /opt/idempiere/; each RUN has a fresh cwd)
WORKDIR /opt/idempiere/
RUN mvn verify

# Install ECLIPSE GUI libraries and dependencies
RUN apt-get update && apt-get install -y \
    libgtk-3-0 \
    libglu1-mesa \
    libxxf86vm1 \
    libcanberra-gtk3-module \
    tar \
    && rm -rf /var/lib/apt/lists/*

# Download and install Eclipse
# You can find the latest download links on the [Eclipse Packages page](https://www.eclipse.org/downloads/packages/)
RUN wget -c "https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2026-03/R/eclipse-jee-2026-03-R-linux-gtk-x86_64.tar.gz&r=1" -O /tmp/eclipse.tar.gz \
    && tar -xf /tmp/eclipse.tar.gz -C /opt \
    && rm /tmp/eclipse.tar.gz

COPY docker-entrypoint.sh /usr/local/bin/docker-entrypoint.sh
RUN sed -i 's/\r$//' /usr/local/bin/docker-entrypoint.sh \
    && chmod +x /usr/local/bin/docker-entrypoint.sh

# Match the host UID/GID so bind-mounted repo files are writable by developer.
ARG HOST_UID=1000
ARG HOST_GID=1000
RUN set -eux; \
    if getent passwd ubuntu >/dev/null 2>&1; then \
        userdel -r ubuntu 2>/dev/null || userdel ubuntu; \
    fi; \
    if getent group ubuntu >/dev/null 2>&1; then \
        groupdel ubuntu 2>/dev/null || true; \
    fi; \
    if getent group developer >/dev/null 2>&1; then \
        groupmod -o -g "${HOST_GID}" developer; \
    else \
        groupadd -g "${HOST_GID}" developer; \
    fi; \
    useradd -m -u "${HOST_UID}" -g "${HOST_GID}" -s /bin/bash developer; \
    chown -R developer:developer /opt/idempiere /home/developer
USER root
ENV HOME=/home/developer

ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]
CMD ["/opt/eclipse/eclipse"]
