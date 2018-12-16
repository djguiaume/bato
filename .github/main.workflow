workflow "Build and test on push" {
  on = "push"
  resolves = [
    "Run tests with gradle",
    "Build Debug APK",
  ]
}

action "Run tests with gradle" {
  uses = "vayan/action-android-gradle@master"
  args = "test"
}

action "Build Debug APK" {
  uses = "vayan/action-android-gradle@master"
  args = "assembleDebug"
}
