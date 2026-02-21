package ar.Ziade.personal_finance.entities.transaction;

import ar.Ziade.personal_finance.entities.BaseEntity;
import ar.Ziade.personal_finance.entities.CurrencyType;
import ar.Ziade.personal_finance.entities.account.AccountEntity;
import ar.Ziade.personal_finance.entities.asset.AssetEntitiy;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

/**
 * this represents all the money movements
 */
@Entity
@Table(name = TransactionEntity.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransactionEntity extends BaseEntity {
    /**
     * name of the table in the database
     */
    static final String TABLE_NAME = "transaction";
    /**
     * this describe the type of transaction, ex: income, expense, etc.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;
    /**
     * this is how much was move
     */
    @Column(nullable = false)
    private long amount;

    /**
     * account money is coming FROM
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FROM_ACCOUNT_ID")
    private AccountEntity fromAccount;
    /**
     * account money is going TO
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TO_ACCOUNT_ID")
    private AccountEntity toAccount;

    /**
     * asset money is coming FROM
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FROM_ASSET_ID")
    private AssetEntitiy fromAsset;
    /**
     * asset money is going TO
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TO_ASSET_ID")
    private AssetEntitiy toAsset;
}
