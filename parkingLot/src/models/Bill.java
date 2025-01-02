package models;

import java.util.List;
import java.util.Date;

public class Bill extends BaseModel {
    private Ticket ticket;
    private Gate gate;
    private BillSatus billSatus;
    private int amount;
    private List<Payment> payments;
    private Date exitTime;
    private FeeCalculationStrategy feeCalculationStrategy;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public BillSatus getBillSatus() {
        return billSatus;
    }

    public void setBillSatus(BillSatus billSatus) {
        this.billSatus = billSatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public FeeCalculationStrategy getFeeCalculationStrategy() {
        return feeCalculationStrategy;
    }

    public void setFeeCalculationStrategy(FeeCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }
}
