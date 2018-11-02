package br.com.manygames.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery

@Entity
data class Issue(
        @Id
        val id: Int,
        val number: Int,
        val action: String,
        val title: String,
        val url: String)