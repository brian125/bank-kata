import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
    private double saldoActual = 0;
    private ArrayList<Transaction> Transacciones = new ArrayList<>();
    void deposit(int amount, String date) {
        if(amount <= 0){
            System.out.println("El valor ingresado debe ser mayor a cero");
        }
        this.saldoActual += amount;
        LocalDate Fecha = DateFormatter.format(date);
        Transacciones.add(new Transaction(Fecha, saldoActual, "deposito", amount));
    }
    void withdraw(int amount, String date){
        if(amount <= 0){
            System.out.println("El valor ingresado debe ser mayor a cero");
        }
        this.saldoActual -= amount;
        LocalDate Fecha = DateFormatter.format(date);
        Transacciones.add(new Transaction(Fecha, saldoActual, "retiro", amount));
    }
    public void transfer(int amount, long accountNumber, String date) {
        if (amount <= 0) {
            System.out.println("El valor ingresado debe ser mayor a cero");
        }
        this.saldoActual -= amount;
        LocalDate Fecha = DateFormatter.format(date);
        Transacciones.add(new Transaction(Fecha, saldoActual, "transferencia", amount));
    }
    void printStatements() {
        for (Transaction movimiento:this.Transacciones){
            System.out.println("|   DATE   ||  CREDIT  || OPERATION ||  AMOUNT  ||  BALANCE |");
            System.out.print("|"+movimiento.getDate()+ "|");
            System.out.print("|  "+movimiento.getBalance()+"  |");
            if(movimiento.getOperation().getKind().length() == 8){
                System.out.print("|  "+movimiento.getOperation().getKind()+" |");
            }
            if(movimiento.getOperation().getKind().length() == 6) {
                System.out.print("|  " + movimiento.getOperation().getKind() + "   |");
            }
            System.out.print("|  "+movimiento.getOperation().getAmount()+"  |");
            System.out.print("|  "+movimiento.getBalance()+"  |");
            System.out.println();
        }
    }
    public String AcoountState() {
        return ("Saldo Actual: "+this.saldoActual);
    }
}