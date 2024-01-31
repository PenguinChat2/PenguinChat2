plugins {
    alias(libs.plugins.lombok)
    id("com.penguinchat2.platform-conventions")
}

dependencies {
    api(project(":core"))
    implementation(libs.dotenv.kotlin)
    implementation(libs.bundles.cloud.paper)
    implementation(libs.bundles.adventure.bukkit)
    implementation(libs.configurate.yaml)
    compileOnly(libs.paper.api)
    compileOnly(libs.luckperms.api)
}

description = "paper"