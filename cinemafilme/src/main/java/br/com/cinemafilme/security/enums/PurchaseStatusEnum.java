package br.com.cinemafilme.security.enums;

public enum PurchaseStatusEnum {
    PENDING("Pagamento Pendente", 1),
    CONFIRMED("Pagamento Confirmado", 2),
    CANCELLED("Pagamento Cancelado", 3);

    private String status;
    private int code;

    private PurchaseStatusEnum(String status, int code) {
        this.status = status;
        this.code = code;
    }
    private PurchaseStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public String getStatus() {
        return status;
    }

}
