plugins {
     alias(libs.plugins.android.application) apply false
     alias(libs.plugins.android.library) apply false
     alias(libs.plugins.kotlin.android) apply false
     alias(libs.plugins.kotlin.jvm) apply false
     alias(libs.plugins.materialthemebuilder) apply false
     alias(libs.plugins.openrewrite) apply true
}

dependencies {
    rewrite(platform("org.openrewrite.recipe:rewrite-recipe-bom:2.21.0"))
    //rewrite("org.openrewrite.recipe:rewrite-testing-frameworks")
    //rewrite("org.openrewrite.recipe:rewrite-spring")
    //rewrite("org.openrewrite.recipe:rewrite-migrate-java")
    //rewrite("org.openrewrite.recipe:rewrite-static-analysis")
}

rewrite {
    activeRecipe(
//        "com.github.scto.ChangeGradleFiles",
        "com.github.scto.ChangeXmlFiles",
//        "com.github.scto.ChangePackage",
//        "com.github.scto.UpgradeAndroidGradlePluginVersion",
//
//        "org.openrewrite.java.testing.junit5.JUnit4to5Migration",
//        "org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_3",
//        "org.openrewrite.java.migrate.guava.NoGuava",
//        "org.openrewrite.java.testing.hamcrest.MigrateHamcrestToAssertJ",
//        "org.openrewrite.staticanalysis.CommonStaticAnalysis",
    )
    exclusion(
        // Excludes a particular yaml file
        //"subproject-a/src/main/resources/generated.yaml",
        // Exclude all json files
        //"**/*.json"
        //"**/*.xml"
    )
    
    //plainTextMask("**/*.txt")
    
    // These are default values, shown for example. It isn't necessary to supply these values manually:
    configFile = project.getRootProject().file("rewrite.yml")
    failOnDryRunResults = false
    sizeThresholdMb = 10
}

tasks.register<Delete>("clean") {
     delete(rootProject.buildDir)
}