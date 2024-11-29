package br.com.skafikis.infra.celcoin;

import br.com.skafikis.domain.repositories.IBassRepository;
import br.com.skafikis.dto.BankDTO;
import br.com.skafikis.infra.utilities.CelcoinAuthHelper;
import br.com.skafikis.infra.utilities.HttpRequestHelper;

public class CelCoinConsume implements IBassRepository {
    private final CelcoinAuthHelper authHelper;
    private final HttpRequestHelper httpRequestHelper;

    public CelCoinConsume() {
        this.authHelper = new CelcoinAuthHelper("", "41b44ab9a56440.teste.celcoinapi.v5", "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");
        this.httpRequestHelper = new HttpRequestHelper();
    }

    @Override
    public String consultBill(String barCode) {
        return "";
    }

    @Override
    public String payBill(BankDTO payBill) {
        return "";
    }

    @Override
    public String generatedQRCode(Double payBill) {
        return "";
    }
}
