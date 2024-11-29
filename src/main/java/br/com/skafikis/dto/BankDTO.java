package br.com.skafikis.dto;

public class BankDTO {

    private String barCode;
    private String transactionId;
    private Double value;

    /*public BankDTO(String barCode, String transactionId, Double value) {
        this.barCode = barCode;
        this.transactionId = transactionId;
        this.value = value;
    }*/

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
