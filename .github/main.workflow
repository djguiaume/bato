workflow "Build and test on push" {
  on = "push"
  resolves = [
    "Run unit tests",
    "Build debug APK",
  ]
}

action "Run unit tests" {
  uses = "vayan/action-android-gradle@master"
  args = "test"
}

action "Build debug APK" {
  uses = "vayan/action-android-gradle@master"
  args = "assembleDebug"
}

workflow "Sanity check on PR" {
  on = "pull_request"
  resolves = [
    "Run unit tests",
  ]
}
