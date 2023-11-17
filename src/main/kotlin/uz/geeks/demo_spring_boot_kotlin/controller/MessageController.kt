package uz.geeks.demo_spring_boot_kotlin.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class MessageController {

    val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/welcome")
    fun hello(): String {
        logger.trace("trace line")
        logger.debug("debug line")
        logger.info("info line")
        logger.warn("warn linr")
        logger.error("error line")

        logger.info("Info {} {}", 1, "abc")

        return "Welcome"
    }


}