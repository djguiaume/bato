workflow "Build and test on push" {
  on = "push"
  resolves = [
    "Run unit tests",
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
