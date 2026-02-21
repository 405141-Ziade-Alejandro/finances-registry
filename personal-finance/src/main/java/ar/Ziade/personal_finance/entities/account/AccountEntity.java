package ar.Ziade.personal_finance.entities.account;

import ar.Ziade.personal_finance.entities.BaseEntity;
import ar.Ziade.personal_finance.entities.CurrencyType;
import jakarta.persistence.*;
import lombok.*;

/**
 * this entity represents the accounts i have, ex: the bank
 * it holds information on the balance i have on them
 */
@Entity
@Table(name = AccountEntity.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountEntity extends BaseEntity {
    /**
     * name of the table in the database
     */
    static final String TABLE_NAME = "ACCOUNT";

    /**
     * this is the name of the account
     */
    @Column(nullable = false)
    private String name;
    /**
     * this means if the currency is in USD or ARS
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CurrencyType currencyType;
    /**
     * this is the type of acccount, meaning wallet, bank, cahs or broker
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;
    /**
     * this is the actual amount i have on the account
     */
    @Column(nullable = false)
    private long balance;
}
