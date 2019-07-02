package entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "condition_table")
class Condition {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int? = null

    @NonNull
    @ColumnInfo(name = "Condition")
    var condition: String? = null

    constructor(){}

    @Ignore
    constructor(condition:String)
    {
        this.condition = condition
    }

}