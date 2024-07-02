package org.danbrough.test

import klog.logger
import kotlin.test.Test

class CommonTests {
  val log by logger()

  @Test
  fun test() {
    log.info { "ok then" }
  }
}