package br.com.manygames.githubprovider.domain

import javax.persistence.Entity
import javax.persistence.Id

data class Issue(
        val id: Int,
        val action: String,
        val number: Int,
        val title: String,
        val url: String)