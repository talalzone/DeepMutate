plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "io.zenmake.deepmutate"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.gradle.org/gradle/libs-releases") }
}

dependencies {
    // logging
    implementation("org.apache.logging.log4j:log4j-api:2.19.0")
    implementation("org.apache.logging.log4j:log4j-core:2.19.0")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.19.0")

    // parsers
    implementation("org.antlr:antlr4:4.11.1")
    implementation("com.github.javaparser:javaparser-symbol-solver-core:3.25.0")

    // drivers
    implementation("org.mongodb:mongodb-driver-sync:4.9.0")
    implementation("com.arangodb:jackson-dataformat-velocypack:4.0.0") {
        exclude(group = "org.slf4j", module = "slf4j-api")
    }
    implementation("com.arangodb:arangodb-java-driver:6.20.0") {
        exclude(group = "org.slf4j", module = "slf4j-api")
    }

    // writers
    implementation("org.apache.commons:commons-csv:1.10.0")

    // serializers/deserializers
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.14.2")

    // utils
    implementation("commons-io:commons-io:2.11.0")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("commons-cli:commons-cli:1.5.0")
    implementation("com.jakewharton.rxrelay3:rxrelay:3.0.1")

    // build tools
    implementation("org.apache.maven.shared:maven-invoker:3.2.0")
    implementation("org.gradle:gradle-tooling-api:7.1.1")

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    // experimental
    implementation("com.j2html:j2html:1.6.0")
    //implementation("fr.inria.gforge.spoon.labs:gumtree-spoon-ast-diff:1.58") {
    //    exclude(group = "org.slf4j", module = "slf4j-api")
    //}

}

tasks.getByName<Test>(JavaPlugin.TEST_TASK_NAME) {
    useJUnitPlatform()
}

tasks.jar {
    manifest.attributes["Main-Class"] = "io.zenmake.deepmutate.DeepMutate"
}