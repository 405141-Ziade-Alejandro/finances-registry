package ar.Ziade.personal_finance.entities.account;

import ar.Ziade.personal_finance.entities.BaseEntity;
import ar.Ziade.personal_finance.entities.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * this entity represents the accounts i have, ex: the bank
 * it holds information on the balance i have on them
 */
@Entity
@Table(name = AccountEntity.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountEntity extends BaseEntity {
    /**
     * name of the table in the database
     */
    static final String TABLE_NAME = "ACCOUNT";

    /**
     * this is the name of the account
     */
    private String name;
    /**
     * this means if the currency is in USD or ARS
     */
    private CurrencyType currencyType;
    /**
     * this is the type of acccount, meaning wallet, bank, cahs or broker
     */
    private AccountType accountType;
    /**
     * this is the actual amount i have on the account
     */
    private long balance;
}
