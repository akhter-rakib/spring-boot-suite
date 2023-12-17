package com.rakib.blogapps.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

@Entity
data class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @NotBlank
    val title: String = "",

    @NotBlank
    val content: String = ""
)

/*That’s because A Kotlin class does’t need getters and setters like Java.
Moreover, I have used a data class here. A data class automatically generates
equals(), hashcode(), toString() and copy() methods.

Note that, I’ve assigned a default value for all the fields in the Article class.
This is needed because Hibernate requires an entity to have a no-arg constructor.

Assigning default values to all the member fields will let hibernate instantiate
 an Article without passing any argument. It Works because Kotlin supports Default Arguments :).*/