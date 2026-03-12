# CoreCue AI Fitness - Android POC

Android proof-of-concept for AI-guided Pilates coaching based on the `CoreCue_AI_Fitness_Mobile_Requirement_DocV1.1`.

This project is built with Kotlin, XML, MVVM, CameraX, MediaPipe Pose Landmarker, and local Room storage.

## What this POC currently delivers

### End-to-end user flow
- Splash
- Home (exercise selection)
- Calibration and setup check
- Demo video
- Exercise recording
- End-of-set report
- History and Profile via bottom navigation

### Mobile implementation highlights
- Kotlin + XML UI with MVVM architecture
- Single-activity navigation with Jetpack Navigation Component
- Hilt-based dependency injection
- Coroutines + Flow state handling
- Room local database foundation (exercise and session entities, DAOs, database)
- CameraX preview + image analysis + recording integration
- MediaPipe Pose Landmarker pipeline and live skeleton overlay renderer
- Animated 5-to-1 countdown before recording
- Front/back camera switch in calibration and recording screens
- TTS guidance with priority queue behavior (ambient, normal, critical)
- ExoPlayer demo screen flow (skip, watch again, proceed)
- Report screen with analytics charts (bar, radar) and history trend chart (line)
- Android 15 edge-to-edge and insets fixes for cut-off UI issues

## Included assets and model

- MediaPipe model is included:
  - `app/src/main/assets/pose_landmarker_lite.task`
- Local splash and exercise fallback drawables are included to avoid blank UI when network thumbnails fail.

## Tech stack

- **Language/UI**: Kotlin, XML, ViewBinding
- **Architecture**: MVVM, Repository pattern
- **Navigation**: Jetpack Navigation Component
- **DI**: Hilt
- **Async**: Kotlin Coroutines, Flow
- **Local data**: Room
- **Networking scaffold**: Retrofit + OkHttp
- **Camera and recording**: CameraX
- **Pose detection**: MediaPipe Tasks Vision Pose Landmarker
- **Media**: Media3 ExoPlayer
- **Charts**: MPAndroidChart
- **Image loading**: Glide

## Project structure (high level)

- `app/src/main/java/com/corecue/fitness/ui` - screens and UI logic
- `app/src/main/java/com/corecue/fitness/ui/camera` - camera and pose pipeline
- `app/src/main/java/com/corecue/fitness/data` - models, repository, room db layer
- `app/src/main/java/com/corecue/fitness/di` - dependency module
- `app/src/main/res` - layouts, drawables, themes, animations, navigation

## Build and run

1. Open project in Android Studio.
2. Ensure Gradle wrapper is used (already configured).
3. Sync Gradle.
4. Build debug APK:
   - `./gradlew assembleDebug` (mac/linux)
   - `gradlew.bat assembleDebug` (windows)
5. Run on device (recommended) or emulator with camera support.

## Permissions used

- Camera
- Record audio
- Internet

## Current known scope of this POC

This is a mobile-first product prototype with realistic UX and local processing scaffolding. It is not yet fully backend-driven.

## Backend/API integrations pending

- Workout Catalog API integration (replace local seeded exercise list)
- Session Initialization API (real session id and secure upload URLs)
- Video chunk upload APIs (reps 1-5 and reps 6-10 workflow)
- Mid-set feedback API response integration
- Final report API mapping (replace synthetic report generation)
- Media metadata API for robust playable benchmark/correction URLs
- Auth/token strategy if required by backend
- Cloud sync strategy for history/profile preferences

## Notes

- Direct YouTube URLs are used in this POC demo flow. In production, backend-provided playable stream URLs are recommended for reliability with ExoPlayer.
- MediaPipe native libs may show strip warnings in debug builds; they are expected and can be packaged as-is.
