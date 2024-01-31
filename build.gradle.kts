plugins {
    id("com.penguinchat2.java-conventions")
    alias(libs.plugins.shadow)
    `java-library`
}

dependencies {
    implementation(project(":paper"))
}

tasks {
    val shadowJar by existing(com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar::class) {
        archiveClassifier.set("")
        archiveFileName.set("PenguinChat2.jar")
    }

    build {
        dependsOn(shadowJar)
    }
}

tasks.named("shadowJar") {
    this.dependsOn(":core:shadowJar")
    this.dependsOn(":paper:shadowJar")
}