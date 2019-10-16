package com.scalaprojects.exercises.boundaries

import java.time.LocalDateTime

case class User(name: String, active: Boolean, paidAt: LocalDateTime)
