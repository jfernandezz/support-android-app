package entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import uy.com.geocom.geopos3.foodservice.currency.Currency;

public class FieldsArticlesImport {
    private String       name;
    private String       color;
    private String       talle;
    private String       categoria;
    private String       categoriaRaiz;
    private String       familia;
    private String       supplierName;
    private BigDecimal   stock;
    private BigDecimal   cost;
    private BigDecimal   rate;
    private String       action;
    private BigDecimal   discount;
    private String       internalCode;
    private String       taxName;
    private String       taxRuleId;
    private BigDecimal   salePrice;
    private List<String> barcodes;
    private Date         vto;
    private String       measureUnitName;
    private Currency     currency;
    private String barcode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoriaRaiz() {
        return categoriaRaiz;
    }

    public void setCategoriaRaiz(String categoriaRaiz) {
        this.categoriaRaiz = categoriaRaiz;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getTaxRuleId() {
        return taxRuleId;
    }

    public void setTaxRuleId(String taxRuleId) {
        this.taxRuleId = taxRuleId;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public List<String> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(List<String> barcodes) {
        this.barcodes = barcodes;
    }

    public Date getVto() {
        return vto;
    }

    public void setVto(Date vto) {
        this.vto = vto;
    }

    public String getMeasureUnitName() {
        return measureUnitName;
    }

    public void setMeasureUnitName(String measureUnitName) {
        this.measureUnitName = measureUnitName;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

}
