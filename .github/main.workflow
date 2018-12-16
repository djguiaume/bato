workflow "Build and test on push" {
  on = "push"
  resolves = [
    "Run unit tests",
    "Build APK"
   ]
}

action "Run unit tests" {
  uses = "vayan/action-android-gradle@master"
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
  uses = "vayan/action-android-gradle@master"
  needs = ["Master branch"]
  args = "assembleDebug"
}
