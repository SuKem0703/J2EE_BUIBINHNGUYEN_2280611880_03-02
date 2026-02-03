package com.example.j2ee_buibinhnguyen_0302.model

class Book {
    // Getters and Setters
    var id: Int = 0
    var title: String? = null
    var author: String? = null

    constructor()

    constructor(id: Int, title: String?, author: String?) {
        this.id = id
        this.title = title
        this.author = author
    }
}