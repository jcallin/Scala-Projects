package com.scalaprojects.tools.testtools

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.SeveredStackTraces
import org.scalatest.matchers.should.Matchers

trait ScalaProjectsSpec extends AnyFunSpec with Matchers with SeveredStackTraces
