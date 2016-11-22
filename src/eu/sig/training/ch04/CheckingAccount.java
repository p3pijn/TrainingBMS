package eu.sig.training.ch04;

import eu.sig.training.ch04.Money;

// tag::CheckingAccount[]
public class CheckingAccount {
	private int transferLimit = 100;

	public Transfer makeTransfer(String counterAccount, Money amount) throws BusinessException {

		checkWithdrawalLimit(amount);
		// 2. Assuming result is 9-digit bank account number, validate 11-test:
        int sum = getAccountNumberSum(counterAccount);
		if (sum % 11 == 0) {
			return getTransfer(counterAccount, amount);
		} else {
			throw new BusinessException("Invalid account number!");
		}
	}

    private int getAccountNumberSum(String counterAccount) {
        int sum = 0;
        for (int i = 0; i < counterAccount.length(); i++) {
            sum = sum + (9 - i) * Character.getNumericValue(counterAccount.charAt(i));
        }
        return sum;
    }

    // 3. Look up counter account and make transfer object:
	private Transfer getTransfer(String counterAccount, Money amount) {
		CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
		return new Transfer(this, acct, amount);
	}

	private void checkWithdrawalLimit(Money amount) throws BusinessException {
		if (amount.greaterThan(this.transferLimit)) {
			throw new BusinessException("Limit exceeded!");
		}
	}
}
// end::CheckingAccount[]
