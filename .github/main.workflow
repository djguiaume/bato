workflow "Run tests" {
  on = "push"
  resolves = ["Run tests with gradle"]
}

action "Run tests with gradle" {
  uses = "vayan/action-gradle@master"
  args = "test"
}
