package com.techelevator.tenmo.model;

public class Transfer {
    private int transferId;
    private int accountId;
    private double transferAmount;
    private String senderName;
    private String receiverName;

    public Transfer(int transferId, int accountId, double transferAmount, String senderName, String receiverName) {
        this.transferId = transferId;
        this.accountId = accountId;
        this.transferAmount = transferAmount;
        this.senderName = senderName;
        this.receiverName = receiverName;
    }
    public Transfer(){}

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", accountId=" + accountId +
                ", transferAmount=" + transferAmount +
                ", senderName='" + senderName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                '}';
    }
}
