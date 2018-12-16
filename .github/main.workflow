workflow "Run tests" {
  on = "push"
  resolves = ["Run tests with gradle"]
}

action "Run tests with gradle" {
  uses = "MrRamych/gradle-actions@master"
  args = "test"
}
