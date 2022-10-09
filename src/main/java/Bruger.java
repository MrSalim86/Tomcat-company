import java.util.ArrayList;
import java.util.List;

public class Bruger
{
    private String navn;
    private String kode;
    private int saldo;
    private boolean active;

    private List<String> transaktioner = new ArrayList<>();

    public Bruger(String navn, String kode)
    {
        this.navn = navn;
        this.kode = kode;
        this.active = true;
        this.saldo = 0;
    }

    public Bruger(String navn, String kode, int saldo)
    {
        this.navn = navn;
        this.kode = kode;
        this.active = true;
        this.saldo = saldo;
    }


    public String getNavn()
    {
        return navn;
    }

    public String getKode()
    {
        return kode;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<String> getTransaktioner() {
        return transaktioner;
    }


    @Override
    public String toString() {return "Bruger{" + "navn='" + navn + '\'' + ", kode='" + kode + '\'' + '}';}

    public int withdraw (int i) {

        if (i < 0) {
            transaktioner.add(navn + "hæv "+ i + "ny saldo " + saldo + transaktioner.size()+1 );
            return saldo;
        }
        saldo = saldo -i;

        transaktioner.add(navn + "hæv "+ i + "ny saldo " + saldo + transaktioner.size()+1 );
        return saldo;
    }

    public int deposit (int i) {

        if (i < 0) {
            transaktioner.add(navn + "indsæt "+ i + "ny saldo " + saldo + transaktioner.size()+1 );
            return saldo;
        }
        saldo = saldo +i;

        transaktioner.add(navn + "indsæt "+ i + "ny saldo " + saldo + transaktioner.size()+1 );
        return saldo;
    }
}
