# Quotes

An old pet project in view system with upgraded dependencies, brought back into existence to demonstrate migration to compose.

### Points to note in this branch and in its related MR.
* This branch includes an android studio update (to Hedgehog | 2023.1.1 Canary 8), and thus gradle plugin updates.
* Also it includes update for [ksp](https://github.com/google/ksp/releases).
* To enable compose (with material), it includes minimum required dependencies. Check [here](https://developer.android.com/jetpack/compose/setup#setup-compose).
* In this branch compose is enabled only for features:quotelist module, and only in module build.gradle.kts, no extra code changes in module.
* Watch compose compiler with kotlin version compatibility [here](https://developer.android.com/jetpack/androidx/releases/compose-kotlin#pre-release_kotlin_compatibility).
* More compose dependencies are added in next branches, on required bases.