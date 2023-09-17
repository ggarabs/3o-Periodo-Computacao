public class AuxiliarMethods {
    public static int[] split(String values){
        values = values.trim();
        int[] aux = new int[values.length()];
        int cont = 0;
        String buffer = new String(""); //Define um buffer para salvar o elemento
        for(int i = 0; i < values.length(); i++){  //Adiciona os elementos a fila, identificando-os atráves da separação por virgula
            while(i < values.length() && values.charAt(i) != ','){
                buffer += values.charAt(i);
                i++;
            }
            int valor = Integer.parseInt(buffer.trim());
            aux[cont++] = valor;
            buffer = ""; //Reseta o buffer
        }
        int[] ans = new int[cont];
        for(int i = 0; i < cont; i++) ans[i] = aux[i];
        return ans;
    }
}
