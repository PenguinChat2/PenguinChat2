import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.penguinchat2.java-conventions")
    id("com.github.johnrengelman.shadow")
}

tasks {
    shadowJar {
        archiveClassifier.set("")
        // relocations here
        // relocate("tld.domain.package", "com.penguinchat2.libs")
    }

    build {
        dependsOn(shadowJar)
    }
}