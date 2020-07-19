package com.wordgenerator.app.model

class Word(var name: String?, var meaning: String?, var enabled: Boolean?) {

    override fun toString(): String {
        return buildString { append(name, " -> ", meaning, ", ", if (enabled == true) "ON" else "OFF") }
    }
}