package entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "observations_table")
class Observation {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "Id")
    var id: Int? = null

    @NonNull
    @ColumnInfo(name = "Trade")
    var trade: String? = null

    @NonNull
    @ColumnInfo(name = "SubContractor")
    var subContractor: String? = null

    @NonNull
    @ColumnInfo(name = "Issue")
    var issue: String? = null

    @NonNull
    @ColumnInfo(name = "Severity")
    var severity: String? = null

    @NonNull
    @ColumnInfo(name = "Condition")
    var condition: String? = null

    @NonNull
    @ColumnInfo(name = "ActionTaken")
    var actionTaken: String = ""

    constructor()


    @Ignore
    constructor(trade: String, subbie: String, issue: String, severrity: String, condition: String, action: String){
        this.trade = trade
        this.subContractor = subbie
        this.issue = issue
        this.severity = severrity
        this.condition = condition
        this.actionTaken = action
    }

}