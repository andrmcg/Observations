package entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "trade_table")
class Trade {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int? = null

    @ColumnInfo(name = "Trade")
    var tradeName: String? = null

    constructor(){}

    @Ignore
    constructor(trade: String)
    {
        this.tradeName = trade
    }
}