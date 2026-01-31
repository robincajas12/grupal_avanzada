plugins {
    id("java")
}

group = "com.project007"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.jboss.weld.se:weld-se-core:6.0.3.Final")
}
sourceSets{
    main{
        output.setResourcesDir(file("${buildDir}/classes/java/main"))
    }
}
tasks.test {
    useJUnitPlatform()
}