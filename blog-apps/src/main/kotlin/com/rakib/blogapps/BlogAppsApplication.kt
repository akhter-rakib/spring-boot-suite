package com.rakib.blogapps

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlogAppsApplication

fun main(args: Array<String>) {
	runApplication<BlogAppsApplication>(*args)
}
