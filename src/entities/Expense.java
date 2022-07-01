package entities;

public class Expense {
    private double amount;
    private PurchaseOrder purchaseOrder;

    public Expense(double amount, PurchaseOrder purchaseOrder) {
        this.amount = amount;
        this.purchaseOrder = purchaseOrder;

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }




//    @Override
//    public String toString(){
//        return "Amount="+this.getAmount()+"ExpenseType="+this.getExpenseType();
//    }
}
