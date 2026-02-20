package ar.Ziade.personal_finance.entities.asset;

import ar.Ziade.personal_finance.entities.BaseEntity;
import ar.Ziade.personal_finance.entities.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * this represents the things that are not liquid like accounts, but meant to make money over time
 */
@Entity
@Table(name = AssetEntitiy.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssetEntitiy extends BaseEntity {
    /**
     * name of the table in the database
     */
    static final String TABLE_NAME = "asset";
    /**
     * this is the name of the asset
     */
    private String name;
    /**
     * this is to represent the different types of assets
     */
    private AssetType assetType;
    /**
     * this means if the currency is in USD or ARS
     */
    private CurrencyType currencyType;
    //todo: check about size limit of this string object
    /**
     * this is to put any notes or descriptions that could be helpful
     */
    private String notes;
    /**
     * this holds how much money it is in it right now
     */
    private long balance;
}
