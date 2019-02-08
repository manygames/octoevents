package br.com.manygames.githubprovider

import br.com.manygames.githubprovider.config.AppConfig

fun main(vararg args: String) {
    AppConfig().setup().start()
}