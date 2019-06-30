package entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "issue_table")
class Issue {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int? = null

    @NonNull
    @ColumnInfo(name = "Issue")
    var issueType: String? = null

    constructor(){}

    @Ignore
    constructor(issue:String)
    {
        this.issueType = issue
    }

}