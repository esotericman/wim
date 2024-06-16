plugins {
    id("java")
}

group = "org.flmelody"
version = "0.1-SNAPSHOT"

repositories {
    maven(url = "/usr/share/maven-repo")
    mavenCentral()
}

dependencies {
    implementation(libs.windward)
    implementation(libs.jackson.databind)
    implementation(libs.jackson.datatype.jsr310)
    implementation(libs.logback)
    implementation(libs.protobuf.java)
    implementation(libs.protobuf.java.util)
    implementation(libs.protobuf.javanano)
    implementation(libs.mongodb.driver)
    implementation(libs.spring.context)
    implementation(libs.lombok)
    annotationProcessor(libs.lombok)
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.jar {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to project.name,
                "Main-Class" to "org.flmelody.wim.WimApplication"
            )
        )
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

tasks.test {
    useJUnitPlatform()
}