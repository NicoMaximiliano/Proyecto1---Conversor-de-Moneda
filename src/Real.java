
public class Real extends Moneda{

    @Override
    public String convertirMoneda(int moneda) {
        moneda *= 24;
        String resultado = moneda + " Reales";
        return resultado;
    }

}

