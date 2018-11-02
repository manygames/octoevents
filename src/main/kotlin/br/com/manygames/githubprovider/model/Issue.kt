package br.com.manygames.githubprovider.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Issue(
        @Id
        val id: Int,
        val number: Int,
        val action: String,
        val title: String,
        val url: String)