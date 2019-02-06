package br.com.manygames.githubprovider.domain.repository

import br.com.manygames.githubprovider.domain.Issue
import org.jetbrains.exposed.dao.LongIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

internal object Issues : LongIdTable("issue") {
    //val id = integer("id").autoIncrement().primaryKey()
    val action = varchar("action", 50)
    val number = integer("number")
    val title = varchar("title", 80)
    val url = varchar("url", 80)
}

class IssueRepository() {
/*    init {
        transaction(Database.connect("jdbc:postgresql://localhost:5432/githubevents", driver = "org.postgresql.Driver",
                user = "postgres", password = "123")) {
            SchemaUtils.create(Issues)
        }
    }*/

    fun create(issue: Issue) {
        return transaction(Database.connect("jdbc:postgresql://localhost:5432/githubevents", driver = "org.postgresql.Driver",
                user = "postgres", password = "123")) {
            Issues.insertAndGetId { row ->
                row[action] = issue.action
                row[number] = issue.number
                row[title] = issue.title
                row[url] = issue.url
            }.value
        }
    }

    fun getAll(): List<Pair<String, String>> {
        return transaction(Database.connect("jdbc:postgresql://localhost:5432/githubevents", driver = "org.postgresql.Driver",
                user = "postgres", password = "123")) {
            Issues.slice(Issues.title, Issues.url)
                  .selectAll().map {
                      it[Issues.title] to it[Issues.url]
                  }

        }
    }

}