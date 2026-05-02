plugins {
    id("dev.prism")
}

group = "com.leclowndu93150"
version = "1.0.0"

prism {
    metadata {
        modId = "animalsplus"
        name = "AnimalsPlus"
        description = "A Minecraft mod."
        license = "MIT"
    }

    version("1.12.2") {
        legacyForge {
            mcVersion = "1.12.2"
            forgeVersion = "14.23.5.2864"

            dependencies {
                annotationProcessor("org.ow2.asm:asm:9.7")
                annotationProcessor("org.ow2.asm:asm-tree:9.7")
            }
        }
    }

}
