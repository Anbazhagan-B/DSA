package LLD2.OnlineShoppingService.services;

import com.DsaProject.LLD.OnlineShoppingLLD.strategy.PaymentStrategy;

public class PaymentService {
    public boolean processPayment(PaymentStrategy strategy, double amount)
    {
        return strategy.pay(amount);
    }
}
