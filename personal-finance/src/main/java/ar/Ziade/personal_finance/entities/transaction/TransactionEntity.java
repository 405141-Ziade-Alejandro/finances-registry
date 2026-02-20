package ar.Ziade.personal_finance.entities.transaction;

import ar.Ziade.personal_finance.entities.BaseEntity;
import ar.Ziade.personal_finance.entities.CurrencyType;
import ar.Ziade.personal_finance.entities.account.AccountEntity;
import ar.Ziade.personal_finance.entities.asset.AssetEntitiy;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * this represents all the money movements
 */
@Entity
@Table(name = TransactionEntity.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionEntity extends BaseEntity {
    /**
     * name of the table in the database
     */
    static final String TABLE_NAME = "transaction";
    /**
     * this means if the currency is in USD or ARS
     */
    private CurrencyType currencyType;
    private TransactionType transactionType;
    private long amount;

    //todo: check the one to many, etc.
//    @Nullable
//    private AccountEntity fromAccount;
//    @Nullable
//    private AccountEntity toAccount;
//
//    @Nullable
//    private AssetEntitiy fromAsset;
//    @Nullable
//    private AssetEntitiy toAsset;
}
