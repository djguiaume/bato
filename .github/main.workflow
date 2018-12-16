workflow "Build and test on push" {
  on = "push"
  resolves = [
    "Run unit tests",
    "Build APK"
   ]
}

action "Run unit tests" {
  uses = "vayan/action-android-gradle@1.0.0"
  args = "test"
}

workflow "Sanity check on PR" {
  on = "pull_request"
  resolves = [
    "Run unit tests",
  ]
}

action "Master branch" {
  uses = "actions/bin/filter@e96fd9a"
  args = "branch master"
}

action "Build APK" {
  uses = "vayan/action-android-gradle@1.0.0"
  needs = ["Master branch"]
  args = "assembleDebug"
}
