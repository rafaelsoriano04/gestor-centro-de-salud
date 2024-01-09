package utilidades;

public class Controles {

    public static boolean controlCi(String ci) {
        boolean validacion;
        // Verificar que la cédula tenga 10 dígitos
        if (ci == null || ci.length() != 10) {
            validacion = false;
        } else {
            // Extraer los primeros 9 dígitos de la cédula
            String digitos = ci.substring(0, 9);
            // Calcular el dígito verificador
            int suma = 0;
            int mult = 2;
            for (int i = digitos.length() - 1; i >= 0; i--) {
                int digito = Character.getNumericValue(digitos.charAt(i));
                int producto = digito * mult;
                if (producto >= 10) {
                    producto -= 9;
                }
                suma += producto;
                mult = (mult == 2) ? 1 : 2;
            }
            int verificador = (10 - (suma % 10)) % 10;
            // Verificar que el último dígito de la cédula sea igual al dígito verificador
            int ultimoDigito = Character.getNumericValue(ci.charAt(9));
            validacion = (ultimoDigito == verificador);
        }
        return validacion;
    }
}
