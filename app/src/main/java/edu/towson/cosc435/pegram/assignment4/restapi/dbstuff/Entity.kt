package edu.towson.cosc435.pegram.assignment4.restapi.dbstuff

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.towson.cosc435.pegram.assignment4.restapi.Photos

@Entity(tableName = "SampleData")
data class Entity(
    val user: Photos,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "title")
    var DBtitle: String = user.title,

    @ColumnInfo(name = "url")
    var DBurl: String = user.url,

    @ColumnInfo(name = "thumbnailUrl")
    var DBthumbnailUrl: String = user.thumbnailUrl,
)
