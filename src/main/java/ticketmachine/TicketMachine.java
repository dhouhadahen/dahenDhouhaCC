package ticketmachine;
public class TicketMachine {
    // The price of a ticket from this machine.
    private final int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     *
     * @param ticketCost the price of a ticket, >=0
     */
    public TicketMachine(int ticketCost) {
        // Test de validité du paramètre
        if (ticketCost <= 0) {
            throw new IllegalArgumentException("Ticket price must be positive");
        }
        price = ticketCost;
        balance = 0;
        total = 0;
    }

    /**
     *
     * @return the price of tickets for this machine
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @return the total amount collected by the machine.
     */
    public int getTotal() {
        return total;
    }

    /**
     * @return the amount of money already inserted for the next ticket.
     */
    public int getBalance() {
        return balance;
    }

    /**
     *
     * @param amount the amount inserted, in cents (positive)
     * @throws IllegalArgumentException if amount is not positive
     */
    public void insertMoney(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif: " + amount);
        }
        balance = balance + amount;
    }

    /**
     *
     * @return the balance
     */
    public int refund() {
        int amountToRefund = balance;
        balance = 0; // CORRECTION IMPORTANTE : remettre la balance à zéro
        System.out.println("Je vous rends : " + amountToRefund + " centimes");
        return amountToRefund;
    }

    /**
     *
     * @return vrai si le ticket a été imprimé, faux sinon
     */
    public boolean printTicket() {
        if (balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            balance = balance - price;
            total = total + price;

            return true;
        } else {
            System.out.println("Montant insuffisant. Veuillez insérer au moins " + price + " cents.");
            return false;
        }
    }
}