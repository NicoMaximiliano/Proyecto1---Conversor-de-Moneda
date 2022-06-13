
public class Dolar extends Moneda{

    @Override
    public String convertirMoneda(int moneda) {
        moneda *= 122;
        String resultado = moneda + " Dolares";
        return resultado;
    }

}
