package br.com.skafikis.infra.utilities;

import java.util.Map;

public class FormatterHelper {

    public String formatConsultBillResponse(Map<String, Object> response) {
        Map<String, Object> registerData = (Map<String, Object>) response.get("registerData");

        return String.join(
                "\nAssignor: " + response.get("assignor"),
                "Recipient: " + registerData.get("recipient"),
                "Document Recipient: " + registerData.get("documentRecipient"),
                "Payer: " + registerData.get("payer"),
                "Document Payer: " + registerData.get("documentPayer"),
                "Pay Due Date: " + registerData.get("payDueDate"),
                "Value: " + response.get("value"),
                "Discount Value: " + registerData.get("discountValue"),
                "Transaction ID: " + response.get("transactionId"),
                "Digitable: " + response.get("digitable"),
                "Type: " + response.get("type")
        );
    }

    public String formatPayBillResponse(Map<String, Object> response) {
        Map<String, Object> receipt = (Map<String, Object>) response.get("receipt");

        return String.join(
                "\nConvenant: " + response.get("convenant"),
                "Recipient Formatted: " + response.get("receiptformatted")
        );
    }

    public String formatQRCodeResponse(Map<String, Object> response) {
        return String.join(
                "\nTransaction ID: " + response.get("transactionId"),
                "Emvqrcps: " + response.get("emvqrcps"),
                "Transaction Identification: " + response.get("transactionIdentification")
        );
    }

}
