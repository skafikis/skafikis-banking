package br.com.skafikis.domain.repositories;

import br.com.skafikis.dto.BankDTO;

public interface IBassRepository {

    String consultBill(String barCode);

    String payBill(BankDTO payBill);

    String generatedQRCode(Double payBill);
}
