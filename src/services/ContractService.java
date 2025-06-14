package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;
public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract (Contract contract, int months){

        double subQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(subQuota, i);
            double fee = onlinePaymentService.paymentFee(subQuota + interest);


            Double quota = subQuota + interest + fee;
            contract.getInstallments().add(new Installment(dueDate, quota));
        }
    }
}
