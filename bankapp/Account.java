package gr.aueb.cf.ch11;

/**
 * Javabean + Public API
 */
public class Account {
    private int id;
    private String iban;
    private String firstname;
    private String lastname;
    private String ssn;
    private double balance;

    public Account() {
    }


    public Account(int id, String iban, String firstname, String lastname, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.firstname = firstname;
        this.ssn = ssn;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    /**
     * Withdraws a certain amount of money from
     * account's balance
     *
     * @param amount
     * the amount to be withdrawn
     * @throws Exception
     * if the amount is greater than account's balance
     */
    public void deposit(double amount) throws Exception {
        try {
            if (amount >= 0) {
                balance += amount;
            } else throw new Exception("Negative amount exception");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Withdraws a certain amount of money from
     * account balance
     *
     * @param amount the amount to be withdrawn
     * @throws Exception if the amount is greater than account's balance
     *                   or ssn is not valid
     */
    public void withdraw(double amount) throws Exception {
       try {
           if (!isSsnValid(ssn)) throw new Exception("Ssn not valid exception");
            if (amount <= balance) {
                balance -= amount;
            }else {
                throw new Exception(("Insufficient balance exception"));
            }
        } catch (Exception e) {
           e.printStackTrace();
           throw e;
       }
    }

    /**
     * Returns the account's balance
     *
     * @return
     *              the account's balance
     */
    public double getAccountBalance() {
        return getBalance();
    }


    public String getAccountState() {
        return "(" + id + " ," + iban  + ", " + firstname + ", "
                + lastname + ", " + ssn + " , " + balance + ")";
    }


    /**
     * Withdraw money below accounts balance
     * and set a limit amount for Overdraft
     *
     * @param amount
     * @throws Exception if ssn is not valid
     */
    public void OverdraftAccount(double amount) throws Exception {
        try {
            if (!isSsnValid(ssn)) throw new Exception("Ssn not valid exception");
                if (balance - amount <= -100) {
                    System.out.println("You have Exceed Overdraft Account limit");
                } else if (balance - amount >= -100) {
                    System.out.println("You have withdraw $" + amount);
                }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private boolean isSsnValid(String ssn) {
            return this.ssn.equals(ssn);
    }


}



