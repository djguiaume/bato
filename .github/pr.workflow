workflow "Test and build APK" {
  resolves = ["Build Debug APK"]
  on = "pull_request"
}

action "Build Debug APK" {
  uses = "vayan/action-gradle@master"
  args = "assembleDebug"
}
