import java.util.ArrayList;
import java.util.List;

public class Bruger
{
    private String navn;
    private String kode;
    private int saldo;

    private List<String> transaktioner = new ArrayList<>();

    public Bruger(String navn, String kode)
    {
        this.navn = navn;
        this.kode = kode;
        this.saldo = 0;
    }

    public Bruger(String navn, String kode,int saldo)
    {
        this.navn = navn;
        this.kode = kode;
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

    public List<String> getTransaktioner() {
        return transaktioner;
    }

    public int getSaldo() {
        return saldo;
    }

    @Override
    public String toString()
    {
        return "Bruger{" + "navn='" + navn + '\'' + ", kode='" + kode + '\'' + '}';}

    public int withdraw (int i) {

        if (i < 0) {
            transaktioner.add("forsøger at hæve et negativt beløb - kunden er idiot");
            return saldo;
        }
        saldo = saldo -i;
        transaktioner.add("Hæver " + i + " , ny saldo er " + saldo);
        return saldo;
    }

    public int deposit (int i) {

        if (i < 0) {
            transaktioner.add("forsøger at hæve et negativt beløb - kunden er idiot");
            return saldo;
        }
        saldo = saldo +i;
        transaktioner.add("kunden indsætter " + i + "på kontoen. Ny saldo er " + saldo);
        return saldo;
    }
}
