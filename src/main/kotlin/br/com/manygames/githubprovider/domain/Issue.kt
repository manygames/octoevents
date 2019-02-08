package br.com.manygames.githubprovider.domain

data class Issue(
        val id: Int,
        val action: String,
        val number: Int,
        val title: String,
        val url: String)