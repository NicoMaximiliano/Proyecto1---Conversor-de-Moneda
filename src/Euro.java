
public class Euro extends Moneda{

    @Override
    public String convertirMoneda(int moneda) {
        moneda *= 128;
        String resultado = moneda + " Euros";
        return resultado;
    }

}

