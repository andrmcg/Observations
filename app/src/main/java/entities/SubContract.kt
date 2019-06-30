package entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "subcontract_table")
class SubContract {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int? = null

    @ColumnInfo(name = "Contractor")
    var subbie: String? = null

    constructor(){}

    @Ignore
    constructor(contractor: String)
    {
        this.subbie = contractor
    }

}