package ar.Ziade.personal_finance.entities.asset;

import ar.Ziade.personal_finance.entities.BaseEntity;
import ar.Ziade.personal_finance.entities.CurrencyType;
import jakarta.persistence.*;
import lombok.*;

/**
 * this represents the things that are not liquid like accounts, but meant to make money over time
 */
@Entity
@Table(name = AssetEntitiy.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AssetEntitiy extends BaseEntity {
    /**
     * name of the table in the database
     */
    static final String TABLE_NAME = "asset";
    /**
     * this is the name of the asset
     */
    @Column(nullable = false)
    private String name;
    /**
     * this is to represent the different types of assets
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssetType assetType;
    /**
     * this means if the currency is in USD or ARS
     */
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
    //todo: check about size limit of this string object
    /**
     * this is to put any notes or descriptions that could be helpful
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "TEXT")
    private String notes;
    /**
     * this holds how much money it is in it right now
     */
    @Column(nullable = false)
    private long balance;
}
