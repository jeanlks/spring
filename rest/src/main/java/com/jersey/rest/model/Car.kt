package com.jersey.rest.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null
    var model: String? = null
    var year: String? = null

    constructor(model: String, year: String) {
        this.model = model
        this.year = year
    }

    constructor() {}
}