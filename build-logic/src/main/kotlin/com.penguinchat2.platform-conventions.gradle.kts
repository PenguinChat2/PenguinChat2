plugins {
    id("com.penguinchat2.shadow-conventions")
}

tasks.named("shadowJar") {
    this.dependsOn(":core:shadowJar")
}