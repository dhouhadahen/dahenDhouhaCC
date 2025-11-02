package ticketmachine;

public class Main {
    public static void main(String[] args) {
        // Crée une machine avec un prix de 50 centimes
        TicketMachine machine1 = new TicketMachine(50);

        System.out.println("Prix du ticket : " + machine1.getPrice() + " centimes");

        // Insère 70 centimes
        machine1.insertMoney(70);
        System.out.println("Balance actuelle : " + machine1.getBalance() + " centimes");

        // Imprime le ticket
        boolean printed = machine1.printTicket();
        if (printed) {
            System.out.println("Ticket imprimé. Reste : " + machine1.getBalance() + " centimes");
        }

        // Remboursement du reste
        machine1.refund();
        System.out.println("Total collecté par la machine : " + machine1.getTotal() + " centimes");
    }
}